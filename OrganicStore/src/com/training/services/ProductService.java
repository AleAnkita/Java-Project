package com.training.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.training.models.Edible;
import com.training.models.Electronics;
import com.training.models.Products;
import com.training.models.Garments;


public class ProductService {

	Logger log = Logger.getLogger(this.getClass().getName());//creating logger object
	
	public ProductService() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Connection con;
	public ProductService(Connection con) {
		super();
		this.con = con;
	}
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}
	//Adding product details in the corresponding tables
	
	public boolean add(Products t) {
		int rowAdded=0;
		 String sql;
	        if(t instanceof Edible) {
	            sql ="insert into Edible values(?,?,?,?,?)";
	        } 
	        else if(t instanceof Garments) {
	            sql ="insert into Garments values(?,?,?,?,?)";
	        }
	        else {
	            sql ="insert into Electronics values(?,?,?,?,?)";
	        }        
		try(PreparedStatement pst = con.prepareStatement(sql)) {
			log.debug("executing insert query");
			pst.setString(1,t.getItemName());
			pst.setDouble(2,t.getUnitPrice());
			pst.setInt(3,t.getQuantity());
			pst.setInt(4,t.getItemCode());
			pst.setDate(5,getCurrentDate());
			
			rowAdded = pst.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rowAdded==1?true:false;
	}
	
	//Getting information of Sales Done on a Category of Product on a Given Day
	
public List<Products> findAll(String obj, String dt) {
		
		String sql = "select * from " + obj +" where dateOfPurchase = '"+ dt +"'";
		
		List<Products> list = new ArrayList<Products>();
		
		try(PreparedStatement pst = con.prepareStatement(sql);){
			log.debug("executing select query")	;
			
			ResultSet rs= pst.executeQuery();
			
			while(rs.next()) {
				
				Products productObj = rowMapper(rs, obj);
				list.add(productObj);
			}
			
		} catch (Exception e) {
			
			//log.debug("Inside catch block : Exception occurred");
			e.printStackTrace();
		}
		
		return list;
	}

private Products rowMapper(ResultSet tableSet, String obj) throws SQLException {
		
	int qty = tableSet.getInt("quantity");
	String name = tableSet.getString("itemName");
	double price  = tableSet.getDouble("unitPrice");
	int code  = tableSet.getInt("itemCode");
	
	Products productObj;
	
	if(obj.equals("Edibles")){
		productObj = new Edible(code, name,price, qty);
	}
	else if(obj.equals("Electronics")){
		productObj = new Electronics(code, name,price, qty);
	}
	else {
		productObj = new Garments(code, name,price, qty);
	}
	
	return productObj;
}

//Top Three Products Sold  on the basis of Quantity on Each Category based on the client request
public List<Products> findMax(String obj) {
	
	String sql = "select * from " + obj +" ORDER BY quantity DESC limit 3";
	
	List<Products> list = new ArrayList<Products>();
	
	try(PreparedStatement pst = con.prepareStatement(sql);){
					
		ResultSet rs= pst.executeQuery();
		
		while(rs.next()) {
			
			Products productObj = rowMapper(rs, obj);
			list.add(productObj);
		}
		
	} catch (Exception e) {
		//log.debug("Inside catch block : Exception occurred");
		e.printStackTrace();
	}
	
	return list;
}

}
