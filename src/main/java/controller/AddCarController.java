package controller;

import model.CarFacade;
import model.CarVO;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import factory.FacadeFactory;

@Controller
@RequestMapping("/add")
public class AddCarController {

	@RequestMapping(value="/AddCar",method=RequestMethod.GET)
	public ModelAndView car(){
		CarVO car = new CarVO();
		return new ModelAndView("AddCar","car",car);
	}

	@RequestMapping(value="/addCar",method=RequestMethod.POST)
	public ModelAndView addCar(@ModelAttribute("car") CarVO car,BindingResult bindingResult){
		
		String message="";
		try{
			FacadeFactory facadeFactory = new FacadeFactory();
			CarFacade facade = facadeFactory.getFacade();
			int result = facade.addAndValidateCar(car);
			if(result == 2){
				message = "Car Added Succesfully";
			}else if(result == 1){
				message = "Car Already Present";
			}else{
				message = "You did something wrong";
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new ModelAndView("ResultPage","result",message);
	}
}