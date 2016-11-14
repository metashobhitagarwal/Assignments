package controller;

import java.util.List;

import model.CarFacade;
import model.CarVO;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import factory.FacadeFactory;

@Controller
@RequestMapping("/update")
public class UpdateCarController {

	@RequestMapping(value="/UpdateCar/{carModelNumber}",method=RequestMethod.GET)
	public ModelAndView getCar(@PathVariable("carModelNumber") String carModelNumber){
			
		CarVO car = null;
		try{
			FacadeFactory facadeFactory = new FacadeFactory();
			CarFacade facade = facadeFactory.getFacade();
			List<CarVO> carList = facade.getCarBasedOnModelNumber(carModelNumber);
			car = carList.get(carList.size()-1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new ModelAndView("UpdateCar","car",car);
	}


	@RequestMapping(value="/updateCar",method=RequestMethod.POST)
	public ModelAndView updateCar(@ModelAttribute("car") CarVO car,BindingResult bindingResult){

		String message="";
		try{
			FacadeFactory facadeFactory = new FacadeFactory();
			CarFacade facade = facadeFactory.getFacade();
			boolean result = facade.updateAndValidateCar(car);
			if(result){
				message = "Car Updated Succesfully";
			}else{
				message = "You did something wrong";
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new ModelAndView("ResultPage","result",message);
	}
}
