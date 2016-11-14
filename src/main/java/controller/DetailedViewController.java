package controller;

import java.util.List;

import model.CarFacade;
import model.CarVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import factory.FacadeFactory;

@Controller
@RequestMapping("/detailedView")
public class DetailedViewController {
	
	@RequestMapping(value="/getDetailedView/{carModelNumber}",method=RequestMethod.GET)
	public ModelAndView getDetailedView(@PathVariable("carModelNumber") String carModelNumber){
			
		CarVO car = null;
		try{
			FacadeFactory facadeFactory = new FacadeFactory();
			CarFacade facade = facadeFactory.getFacade();
			List<CarVO> carList = facade.getCarBasedOnModelNumber(carModelNumber);
			car = carList.get(carList.size()-1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new ModelAndView("DetailedCarView","car",car);
	}
}