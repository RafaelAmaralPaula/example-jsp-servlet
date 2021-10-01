package com.rafaelamaral.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static ConnectionUtil connectionUtil;
	
	public static ConnectionUtil getInstance() {
		if(connectionUtil == null) {
			connectionUtil = new ConnectionUtil();
		}
		
		return connectionUtil;
	}
	
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost/example_jsp" , "root" , "root");
	}

}
