package com.employeemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	
	private Connection con=null;
	 /*private static DBConnection instance = new DBConnection();
	 
	 private DBConnection(){
	 }*/
	 
	 public Connection getConnection(){
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Driver Class Error"+e);
			}
			
			String host = "jdbc:mysql://localhost:3306/";
			String db = "empdb";		
			String mysqlURL = host.trim() + db.trim();
			String user ="root";
			String pass = "12345";
			
			try {
				con = DriverManager.getConnection(mysqlURL.trim(),user,pass);
			} catch (SQLException e) {
				System.out.println("SQL execption"+e);
			}
			
			return con;
		}
	
	/*public static DBConnection getInstance(){
		
		return instance;
	}*/
}
