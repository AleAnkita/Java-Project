package com.training.utils;

import java.io.*;
import java.sql.*;
import java.util.Properties;

import javax.sql.DataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class ConnectionUtils {
	
	public static Connection getMySqlConnection() {
		Connection con = null;
		try {
		
		/*String fileName = "resources/DbConnection.Properties";
		
		InputStream stream = ConnectionUtils.class.getClassLoader().getResourceAsStream(fileName);
		
		Properties props = new Properties();//to convert streams to map
		
		props.load(stream);//stream represents DbConnection.properties
		
		String url=props.getProperty("database.url");
		String passWord = props.getProperty("database.passWord");
		String userName = props.getProperty("database.userName");
		*/
			String[] values = getPropsAsArray();
            con = DriverManager.getConnection(values[0],values[1],values[2]);
            
       } catch (Exception e) {
           
           //System.out.println("Exception in making connection: "+e.getMessage());
           e.printStackTrace();
       }
       return con;
}
				
private static String[] getPropsAsArray() throws IOException {
    
    String fileName="resources/DbConnection.properties";
    
    InputStream stream = ConnectionUtils.class.getClassLoader().getResourceAsStream(fileName);
    
    Properties props = new Properties();
     
    props.load(stream);
     String url=props.getProperty("database.url");
     String username=props.getProperty("database.userName");
     String password=props.getProperty("database.passWord");
     
     return new String[] {url, username, password};
}

	
		public static Connection getConnectionFromPool() {
			Connection connection = null;
			try {
				HikariConfig config = new HikariConfig();
				String[] values = getPropsAsArray();
				config.setJdbcUrl(values[0]);
				config.setUsername(values[1]);
				config.setPassword(values[2]);
				
				config.addDataSourceProperty("maximumPoolSize","25");
				
				DataSource datasource = new HikariDataSource(config);
				connection = datasource.getConnection();
				
			} catch(SQLException|IOException e) {
				e.printStackTrace();
				}
			return connection;
			}

	public static void main(String[] args) {
		//System.out.println(ConnectionUtils.getMySqlConnection());
		
	
		
	}
	
}

	