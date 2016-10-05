package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Singleton Connection Factory Class
 * @author admin
 *
 */
public class ConnectionFactory {
	
	private static Connection connection;
	
	private ConnectionFactory(){}
	
	private static void createConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CarBecho", "root", "gogogo");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		if(connection==null){
			createConnection();
		}
		return connection;
	}
	
	public static void closeConnection(){
		try{
			connection.close();
		}
		catch(Exception e){
			e.printStackTrace();	
		}
	}
}
