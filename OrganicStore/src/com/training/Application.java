package com.training;

import com.training.services.ProductService;
import com.training.models.Edible;
import com.training.models.Electronics;
import com.training.models.Garments;
import com.training.models.Products;
import com.training.utils.ConnectionUtils;
import java.sql.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class Application { 
	
//prints the retrieved stored in list 
public static void print(List<Products> productList) {
		
		Iterator<Products> itr = productList.iterator();
		int i=1;
		System.out.println("SNo. Item Name	Unit Price	Quantity	Amount");
		while(itr.hasNext()) {
			
			Products productObj=itr.next();
			System.out.print(i);
			System.out.println(productObj);
			i++;
		}
	}
	public static void main(String[] args) {
		//creating Logger object
		Logger log = Logger.getRootLogger();
		
		//Initialize values to be inserted in different tables
		Edible e1 = new Edible(102,"Bread",30.0,1,"2020-10-12", "2020-11-12","veg");
		Electronics p1 = new Electronics(202, "Headphones", 1000.0, 5, 2.3,"40cm", 1);
		Garments g1 = new Garments(305,"Sweater",800.0,100,"M","wool");
		Connection con = ConnectionUtils.getConnectionFromPool();
		ProductService service = new ProductService(con);
		//Uncomment below lines based on your insert into table requirement
		
		//service.add(e1);
		//service.add(p1);
		//service.add(g1);
		
		//retrieve content of a table as a list based on a particular date of purchase
		//and print them on console
		List<Products> list=service.findAll("Electronics","2020-11-12");
		print(list);
		
	
		String category;
		System.out.println("Enter the product category to see the top 3 sold product of that type");
		Scanner sc = new Scanner(System.in);
		category =sc.next();
		
		log.info("You entered: "+category);
		if(!(category.equals("Garments")||category.equals("Edible")||category.equals("Electronics"))) {
			log.error("such table does not exist");
		}

		List<Products> list1=service.findMax(category);
		print(list1);
		
		
	}

}
