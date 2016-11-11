package model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daoLayer.CarDAO;

@Service
public class CarFacade {
	
	@Autowired
	private CarDAO carDao;

	/**
	 * @return the carDao
	 */
	public CarDAO getCarDao() {
		return carDao;
	}

	/**
	 * @param carDao the carDao to set
	 */
	@Autowired
	public void setCarDao(CarDAO carDao) {
		this.carDao = carDao;
	}

	public int addAndValidateCar(CarVO car){

		int result = 0;

		try{

			if(carDao.selectCarBasedOnParameters(car)){

				result = 1;
			}

			else if(carDao.addCar(car)){

				result = 2;
			}

		}catch(Exception ex){

			ex.printStackTrace();
		}

		return result;
	}

	public boolean updateAndValidateCar(CarVO car){

		boolean flag = false;

		try{
			if(carDao.updateCar(car)){

				flag = true;
			}

		}catch(Exception ex){

			ex.printStackTrace();
		}
		return flag;
	}

	public List<CarVO> getAllCars(){

		List<CarVO> listOfCars = null;
		

		try{

			listOfCars = carDao.selectAllCars();

		}catch(Exception ex){

			ex.printStackTrace();
		}
		return listOfCars;
	}
}