package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDAO {
	
	private static CarDAO carDAOObject = null;	
	private static PreparedStatement statement;	
	
	private CarDAO() {
		
	}
	
	
	public List<Car> getCarList() {
	
	}
	
	public Car getCarDetailsById(int id) {
		
	}
	
	public Car getCarDetailsByMake(String make) {
		
	}
	
	public boolean insertCarDetails(CarVO carVo, CarTO carTo) {
		
	}
	
	public boolean updateCarDetails(CarVO carVo, CarTO carTo) {
	
	}
		
	public static CarDAO getObject() {
	
	}
	
	
	public static void closeCarDAO() {
		try {
			statement.close();
			ConnectionFactory.closeConnection();
		} catch (SQLException e) {
			try {
				statement.close();
				ConnectionFactory.closeConnection();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
