package service;

import java.util.List;

import javax.transaction.Transactional;

import model.CarVO;

import org.springframework.beans.factory.annotation.Autowired;

import daoLayer.CarDAOImpl;

@Transactional
public class CarServiceImpl  {
	
	@Autowired
	private CarDAOImpl carDao;

	

	/**
	 * @return the carDao
	 */
	public CarDAOImpl getCarDao() {
		return carDao;
	}

	/**
	 * @param carDao the carDao to set
	 */
	public void setCarDao(CarDAOImpl carDao) {
		this.carDao = carDao;
	}

	@Transactional
	public void addCar(CarVO car) {
		this.carDao.addCar(car);
	}
	
	@Transactional
	public void updateCar(CarVO car) {
		this.carDao.updateCar(car);
	}

	@Transactional
	public List<CarVO> listCars() {
		return this.carDao.listCars();
	}
	
	@Transactional
	public CarVO getCarById(String id) {
		return this.carDao.getCarById(id);
	}
}