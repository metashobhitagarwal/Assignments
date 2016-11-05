package com.metacube.dsp2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.dsp2.facade.CarFacade;

@SuppressWarnings("serial")
@WebServlet
public class ListCars extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		//Getting the object of Car Facade Class
		CarFacade facade = CarFacade.getFacade();
		//Getting the request dispatcher object
		RequestDispatcher dispatcher = request.getRequestDispatcher("/View/listCar.jsp");
		ServletContext context = getServletContext();
		
		//Setting the list of cars as attribute to the request context
		context.setAttribute("listOfCars", facade.getCarList());
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
}
