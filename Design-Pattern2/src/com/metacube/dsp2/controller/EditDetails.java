package com.metacube.dsp2.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.dsp2.facade.CarFacade;
import com.metacube.dsp2.vo.CarVO;

@SuppressWarnings("serial")
@WebServlet
public class EditDetails extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		CarVO carVO = new CarVO();
		
		//Getting the current date and time
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String currentDate = dateFormat.format(cal.getTime());
		
		//Setting the form values to the bean object
		carVO.setMake(request.getParameter("make"));
		carVO.setModel(request.getParameter("model"));
		carVO.setEngineInCC(Integer.parseInt(request.getParameter("engine")));
		carVO.setFuelCapacity(Double.parseDouble(request.getParameter("fuel")));
		carVO.setMilage(Double.parseDouble(request.getParameter("milage")));
		carVO.setPrice(Double.parseDouble(request.getParameter("price")));
		carVO.setRoadTax(Double.parseDouble(request.getParameter("tax")));
		
		carVO.setAc(request.getParameter("ac"));
		carVO.setPowerSteering(request.getParameter("steering"));
		carVO.setAccessoryKit(request.getParameter("kit"));
		
		carVO.setUpdatedBy("root");
		carVO.setUpdatedTime(currentDate);
		
		//Checking that the purpose for form was to edit or create a record
		if(request.getParameter("id") != null) {
			carVO.setId(Integer.parseInt(request.getParameter("id")));
		} else {
			carVO.setCreatedBy("root");
			carVO.setCreatedTime(currentDate);
		}
		
		//Getting the object of Car Facade Class
		CarFacade facade = CarFacade.getFacade();
		RequestDispatcher dispatcher;
		
		boolean result = facade.addUpdateCarDetails(carVO);
		//Getting the request dispatcher object based upon the operation
		if(result) {
			dispatcher = request.getRequestDispatcher("carlist");
		} else {
			dispatcher = request.getRequestDispatcher("carform");
		}
		
		try {
			//Forwarding the request
			dispatcher.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} 
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	
}
