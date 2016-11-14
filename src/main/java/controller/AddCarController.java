package controller;

import model.CarVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.CarServiceImpl;

@Controller
@RequestMapping("/add")
public class AddCarController {
	
	
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

	@RequestMapping(value="/AddCar",method=RequestMethod.GET)
	public ModelAndView car(){
		CarVO car = new CarVO();
		return new ModelAndView("AddCar","car",car);
	}

	@RequestMapping(value="/addCar",method=RequestMethod.POST)
	public ModelAndView addCar(@ModelAttribute("car") CarVO car,BindingResult bindingResult){
		
		String message="You did something wrong";
		try{
			if(car.getId() == null){
				this.service.addCar(car);
				message="Car Added Succesfully";
			}else{
				message = "Car Already Present";
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new ModelAndView("ResultPage","result",message);
	}
}