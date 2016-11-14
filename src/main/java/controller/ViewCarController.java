package controller;

import java.util.List;

import model.CarVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.CarServiceImpl;

@Controller
@RequestMapping("/view")
public class ViewCarController {

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
	
	@RequestMapping(value="/ViewCars",method=RequestMethod.GET)
	public ModelAndView viewCars(){

		System.out.println("service: "+this.service);

		List<CarVO> list = this.service.listCars();

		ModelAndView model = new ModelAndView("ViewCars");
		model.addObject("lists",list);
		return model;
	}
}
