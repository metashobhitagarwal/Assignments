package com.metacube.dsp2.facade;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metacube.dsp2.dao.CarDAO;
import com.metacube.dsp2.vo.CarVO;

public class CarFacade {

private static CarFacade facade = null;	//Facade object for singleton pattern
	
	/**
	 * Constructor to implement the singleton pattern
	 */
	private CarFacade() {
		
	}
	
	/**
	 * To get the available car list
	 * @return The list of CarVO objects containing the make and models of the cars
	 */
	public List<CarVO> getCarList() {
		List<CarVO> carVOList = new ArrayList<CarVO>();
		CarDAO carDAO = CarDAO.getObject();
		ResultSet result = carDAO.getCarList();
		
		try {
			//Iterating over the result set
			while(result.next()) {
				CarVO car = new CarVO();
				car.setId(result.getInt("id_vehicle"));
				car.setMake(result.getString("make"));
				car.setModel(result.getString("model"));
				
				carVOList.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carVOList;
	}
	
	/**
	 * To get the CarVO object based on the id
	 * @param id - The id of the car whose details needs to be fetched
	 * @return - The object of CarVO class
	 */
	public CarVO getCarDetailsById(int id) {
		CarDAO carDAO = CarDAO.getObject();
		//Getting the result set
		ResultSet result = carDAO.getCarDetailsById(id);
		CarVO car = new CarVO();
		
		try {
			//Iterating over the result set
			while(result.next()) {
				//Saving the details of car in the bean object
				car.setId(result.getInt("id_vehicle"));
				car.setMake(result.getString("make"));
				car.setModel(result.getString("model"));
				car.setEngineInCC(result.getInt("engine_in_cc"));
				car.setFuelCapacity(result.getDouble("fuel_capacity"));
				car.setMilage(result.getDouble("mileage"));
				car.setPrice(result.getDouble("price"));
				car.setRoadTax(result.getDouble("road_tax"));		
				
				car.setAc(result.getString("ac"));
				car.setPowerSteering(result.getString("power_steering"));
				car.setAccessoryKit(result.getString("accessory_kit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return car;
	}
	

	/**
	 * To update or insert the car details
	 * @param carvo - The CarVO object containing the cars details
	 * @param carto - The CarTO object containing the cars metadata details
	 * @return - True if the operation is successful else false
	 */
	public boolean addUpdateCarDetails(CarVO carvo) {
		CarDAO carDAO = CarDAO.getObject();
		if(carvo.getCreatedTime() != null) {
			return carDAO.insertCarDetails(carvo);
		} else {
			return carDAO.updateCarDetails(carvo);
		}
	}
	
	
	public static CarFacade getFacade() {
		//Checking if facade object already exists or not
		if(facade == null) {
			facade = new CarFacade();
		}
		return facade;
	}
	
	/**
	 * To close the facade object
	 */
	public static void closeFacade() {
		CarDAO.closeCarDAO();
	}
}
