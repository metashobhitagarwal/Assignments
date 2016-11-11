/**
 * 
 */
package daoLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import model.CarVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import factory.ConnectionFactory;
import factory.FacadeFactory;

/**
 * @author admin
 *
 */
@Repository
public class CarDAO {

	private List<CarVO> listOfCars;

	public CarDAO(){

		listOfCars = new ArrayList<CarVO>();
	}

	public boolean addCar(CarVO car){

		String sqlQuery = "INSERT INTO Car (ID,CompanyName,ModelNumber,Name,FuelCapacity,Milege,Price,RoadTax"
				+ ",AC,PowerSteering,AccessoryKit) "
				+ "Values (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?);";

		boolean flag = false;
		PreparedStatement prepareStatement = null;
		Connection connection  = null;
		try{
			
			connection = ConnectionFactory.getInstance().getConnection();
			
			if(connection != null){
				prepareStatement = connection.prepareStatement(sqlQuery);
			}
			if(prepareStatement != null){

				prepareStatement.setString(1, UUID.randomUUID().toString());
				prepareStatement.setString(2, car.getCompanyName());
				prepareStatement.setString(3, car.getModelNumber());
				prepareStatement.setString(4, car.getName());
				prepareStatement.setDouble(5, car.getFuelCapacity());
				prepareStatement.setDouble(6, car.getMilege());
				prepareStatement.setDouble(7, car.getPrice());
				prepareStatement.setDouble(8, car.getRoadTax());
				prepareStatement.setInt(9, car.isAcPresent());
				prepareStatement.setInt(10, car.isPowerSteeringPresent());
				prepareStatement.setInt(11, car.isAccessoryKitPresent());

				prepareStatement.executeUpdate();

				flag = true;
			}

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

		return flag;
	}

	public boolean selectCarBasedOnParameters(CarVO car){

		boolean isCarPresent = true;

		String sqlQuery = "SELECT CompanyName , ModelNumber , Name , FuelCapacity,"
				+ "Milege, Price, RoadTax, AC, PowerSteering , AccessoryKit FROM car "
				+ "WHERE CompanyName = ? AND ModelNumber = ? AND Name = ?;";

		PreparedStatement prepareStatement = null;
		Connection connection = null;
		try{
			
			connection = ConnectionFactory.getInstance().getConnection();
			if(connection != null){
				
				prepareStatement = connection.prepareStatement(sqlQuery);
				
			}
			if(prepareStatement != null){

				prepareStatement.setString(1, car.getCompanyName());
				prepareStatement.setString(2, car.getModelNumber());
				prepareStatement.setString(3, car.getName());

				ResultSet resultSet = prepareStatement.executeQuery();

				if(resultSet != null){
					if (!resultSet.isBeforeFirst() ) {    
						isCarPresent = false;
					} 
				}
			}

		}catch(Exception ex){

			ex.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

		return isCarPresent;

	}
	public List<CarVO> selectAllCars(){

		String sqlQuery = "SELECT CompanyName , ModelNumber , Name , FuelCapacity,"
				+ "Milege, Price, RoadTax, AC, PowerSteering , AccessoryKit FROM car;";

		PreparedStatement prepareStatement = null;
		Connection connection = null;
		CarVO car = null;
		FacadeFactory facadeFactory = null;
		try{
			connection = ConnectionFactory.getInstance().getConnection();
			prepareStatement = connection.prepareStatement(sqlQuery);

			ResultSet resultSet = prepareStatement.executeQuery();
			if(resultSet != null){
				facadeFactory = new FacadeFactory();
				while(resultSet.next()){
					
					car = facadeFactory.getCar();
					car.setCompanyName(resultSet.getString(1));
					car.setModelNumber(resultSet.getString(2));
					car.setName(resultSet.getString(3));
					car.setFuelCapacity(resultSet.getDouble(4));
					car.setMilege(resultSet.getDouble(5));
					car.setPrice(resultSet.getDouble(6));
					car.setRoadTax(resultSet.getDouble(7));
					car.setAcPresent(resultSet.getInt(8));
					car.setPowerSteeringPresent(resultSet.getInt(9));
					car.setAccessoryKitPresent(resultSet.getInt(10));
					listOfCars.add(car);
				}
			}

		}catch(Exception ex){

			System.out.println(ex.getLocalizedMessage());
			ex.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

		return listOfCars;
	}

	public boolean updateCar(CarVO car){
		
		String sqlQuery = "UPDATE Car SET CompanyName = ? , ModelNumber = ? , Name = ? , "
				+ "FuelCapacity = ? , Milege = ? , Price = ?, RoadTax = ? , AC = ? ,PowerSteering = ?,"
				+ "AccessoryKit = ? WHERE ModelNumber = ?";

		boolean flag = false;
		PreparedStatement prepareStatement = null;
		Connection connection = null;
		try{
			connection = ConnectionFactory.getInstance().getConnection();
			if(connection != null){
				prepareStatement = connection.prepareStatement(sqlQuery);
			}
			if(prepareStatement != null){


				prepareStatement.setString(1, car.getCompanyName());
				prepareStatement.setString(2, car.getModelNumber());
				prepareStatement.setString(3, car.getName());
				prepareStatement.setDouble(4, car.getFuelCapacity());
				prepareStatement.setDouble(5, car.getMilege());
				prepareStatement.setDouble(6, car.getPrice());
				prepareStatement.setDouble(7, car.getRoadTax());
				prepareStatement.setInt(8, car.isAcPresent());
				prepareStatement.setInt(9, car.isPowerSteeringPresent());
				prepareStatement.setInt(10, car.isAccessoryKitPresent());
				prepareStatement.setString(11, car.getModelNumber());

				prepareStatement.executeUpdate();

				flag = true;
			}

		}catch(Exception ex){

			ex.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

		return flag;
	}
}