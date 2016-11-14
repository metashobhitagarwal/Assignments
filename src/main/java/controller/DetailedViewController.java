package controller;

import model.CarVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.CarServiceImpl;

@Controller
@RequestMapping("/detailedView")
public class DetailedViewController {

	private CarServiceImpl service;


	/**
	 * @return the service
	 */
	public CarServiceImpl getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	@Autowired(required=true)
	public void setService(CarServiceImpl service) {
		this.service = service;
	}
	@RequestMapping(value="/getDetailedView/{carId}",method=RequestMethod.GET)
	public ModelAndView getDetailedView(@PathVariable("carId") String carId){

		CarVO car = null;
		try{
			car = this.service.getCarById(carId);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new ModelAndView("DetailedCarView","car",car);
	}
}