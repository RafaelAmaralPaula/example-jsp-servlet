package com.rafaelamaral.repository.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionDataBase {
	
	private static String url = "jdbc:mysql://localhost/example_jsp?createDatabaseIfNotExist=true&useSSL=false";
	private static String user = "root";
	private static String password = "javalove123";
	
	private static Connection connection = null;
	
	static {
		toConnect();
	}
	
	
	public SingleConnectionDataBase() {
		toConnect();
	}
	
	
	public static Connection getConnection() {
		return connection;
	}
	
	private static void toConnect() {
		try {
			if( connection == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);
			
				
			}
			
		} catch (Exception e) {
		
		}
		
		
	}

}
