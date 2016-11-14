package controller;

import model.CarVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.CarServiceImpl;

@Controller
@RequestMapping("/update")
public class UpdateCarController {	

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

	@RequestMapping(value="/UpdateCar/{carId}",method=RequestMethod.GET)
	public ModelAndView getCar(@PathVariable("carId") String carId,Model model){
		
		CarVO car = null;
		try{
			car = this.service.getCarById(carId);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new ModelAndView("UpdateCar","car",car);
	}


	@RequestMapping(value="/updateCar",method=RequestMethod.GET)
	public ModelAndView updateCar(@ModelAttribute("car") CarVO car,BindingResult bindingResult){

		String message="You did something wrong";
		try{
			this.service.updateCar(car);
			message = "Car Updated Succesfully";

		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new ModelAndView("ResultPage","result",message);
	}
}
