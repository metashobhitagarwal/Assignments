package factory;

import model.CarFacade;
import model.CarVO;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class FacadeFactory {

	public CarFacade getFacade() {
		
		CarFacade facade = null;

		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");){
			
			facade = (CarFacade) context.getBean("facade",CarFacade.class);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return facade;
		
	}

	public CarVO getCar(){

		CarVO car = null;

		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");){
			
			car = (CarVO) context.getBean("car",CarVO.class);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return car;
	}
}