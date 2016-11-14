package controller;

import java.util.List;

import model.CarFacade;
import model.CarVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import factory.FacadeFactory;

@Controller
@RequestMapping("/view")
public class ViewCarController {
	
	@RequestMapping(value="/ViewCars",method=RequestMethod.GET)
	public ModelAndView viewCars(){
		
		FacadeFactory facadeFactory = new FacadeFactory();
		CarFacade facade = facadeFactory.getFacade();
		List<CarVO> list = facade.getAllCars();
		ModelAndView model = new ModelAndView("ViewCars");
		model.addObject("lists",list);
		return model;
	}
}
