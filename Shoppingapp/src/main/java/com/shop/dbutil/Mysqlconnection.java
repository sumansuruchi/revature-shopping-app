package com.shop.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysqlconnection {
	private static Connection connection;

	private Mysqlconnection() {
		
		// TODO Auto-generated constructor stub
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/Shopping_app";
		String username = "root";
		String password = "Suruchi@123";
		connection = DriverManager.getConnection(url, username, password);
		return connection;

	}


}
