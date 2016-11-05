package com.metacube.dsp2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.metacube.dsp2.vo.CarVO;

public class CarDAO {

	private static CarDAO carDAOObject = null;	//CarDAO object for singleton pattern
	private static PreparedStatement statement;	//Prepared statement object
	
	/**
	 * Constructor to implement the singleton pattern
	 */
	private CarDAO() {
		
	}
	
	/**
	 * To get the available car list
	 * @return The result set containing the cars details
	 */
	public ResultSet getCarList() {
		try {
			//Getting the connection object
			Connection connection = ConnectionFactory.getConnection();
			//Creating the prepared statement query
			statement = connection.prepareStatement(
					"SELECT * FROM vehicle v INNER JOIN car c ON c.idCar = v.id_vehicle");
			
			//Executing the query
			ResultSet result = statement.executeQuery();
			
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet getCarDetailsById(int id) {
		try {
			//Getting the connection object
			Connection connection = ConnectionFactory.getConnection();
			//Creating the prepared statement query
			PreparedStatement statement = connection.prepareStatement(
					"SELECT * FROM vehicle v INNER JOIN car c ON c.idCar = v.id_vehicle WHERE c.idCar = ?");
			statement.setInt(1, id);
			
			//Executing the query
			ResultSet result = statement.executeQuery();
			
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean updateCarDetails(CarVO carVo) {
		//Getting the connection object
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement;
		
		try {
			
			//Creating the prepared statement query
			statement = connection.prepareStatement(
					"UPDATE vehicle SET "
					+ "make = ?, model = ?, engine_in_cc = ?, fuel_capacity = ?, mileage = ?, price = ?, road_tax = ? "
					+ "WHERE id_vehicle = ?");
			//Setting the parameters to the prepared statement
			statement.setString(1, carVo.getMake());
			statement.setString(2, carVo.getModel());
			statement.setInt(3, carVo.getEngineInCC());
			statement.setDouble(4, carVo.getFuelCapacity());
			statement.setDouble(5, carVo.getMilage());
			statement.setDouble(6, carVo.getPrice());
			statement.setDouble(7, carVo.getRoadTax());
			statement.setInt(8, carVo.getId());

			//Executing the query
			statement.executeUpdate();
			statement.close();
			
			//Creating the prepared statement query
			statement = connection.prepareStatement(
					"UPDATE car SET "
					+ "ac = ?, power_steering = ?, accessory_kit = ?,updated_by = ?, updated_time = ?   "
					+ "WHERE idCar = ?");
			//Setting the parameters to the prepared statement
			statement.setString(1, carVo.getAc());
			statement.setString(2, carVo.getpowerSteering());
			statement.setString(3, carVo.getAccessoryKit());
			statement.setString(4, carVo.getUpdatedBy());
			statement.setString(5, carVo.getUpdatedTime());
			statement.setInt(6, carVo.getId());
			
			//Executing the query
			statement.executeUpdate();
			statement.close();
			
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean insertCarDetails(CarVO carVo) {
		//Getting the connection object
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement;
		
		try {
			//Creating the prepared statement query
			statement = connection.prepareStatement(
					"INSERT INTO vehicle "
					+ "(make, model, engine_in_cc, fuel_capacity, mileage, price, road_tax) VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			//Setting the parameters to the prepared statement
			statement.setString(1, carVo.getMake());
			statement.setString(2, carVo.getModel());
			statement.setInt(3, carVo.getEngineInCC());
			statement.setDouble(4, carVo.getFuelCapacity());
			statement.setDouble(5, carVo.getMilage());
			statement.setDouble(6, carVo.getPrice());
			statement.setDouble(7, carVo.getRoadTax());
			
			//Executing the query
			statement.executeUpdate();
			
			//Fetching the auto generated key to be used by tables also
			ResultSet rs = statement.getGeneratedKeys();
			int lastInsertedID = 0;
            if(rs.next()) {
                lastInsertedID = rs.getInt(1);
            }
			statement.close();
			
			//Creating the prepared statement query
			statement = connection.prepareStatement(
					"INSERT INTO car "
					+ "(idCar, ac, power_steering, accessory_kit, created_by, ceated_time, updated_by, updated_time) VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?)");
			//Setting the parameters to the prepared statement
			statement.setInt(1, lastInsertedID);
			statement.setString(2, carVo.getAc());
			statement.setString(3, carVo.getpowerSteering());
			statement.setString(4, carVo.getAccessoryKit());
			statement.setString(5, carVo.getCreatedBy());
			statement.setString(6, carVo.getCreatedTime());
			statement.setString(7, carVo.getUpdatedBy());
			statement.setString(8, carVo.getUpdatedTime());
			
			//Executing the query
			statement.executeUpdate();
			statement.close();
			
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * To get the carDAO object
	 * @return - The CarDAO object
	 */
	public static CarDAO getObject() {
		//Checking if facade object already exists or not
		if(carDAOObject == null) {
			carDAOObject = new CarDAO();
		}
		return carDAOObject;
	}
	
	/**
	 * To close the carDAO object
	 */
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
