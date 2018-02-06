package com.pet.petstore.web.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pet.mvc.HttpRequestHandler;
import com.pet.petstore.domain.Item;
import com.pet.petstore.service.PetStoreException;
import com.pet.petstore.service.PetStoreFacade;

public class Catalog implements HttpRequestHandler {
	
	public Catalog()
	{
		
	}
	public final static Logger LOG = Logger.getLogger(Catalog.class);
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher= null;
		int id=Integer.parseInt(request.getParameter("cid"));
		List<Item> result= new ArrayList<Item>();
		PetStoreFacade facade=new PetStoreFacade();
		try {
			result=facade.getItemList(id);
		} catch (PetStoreException e) {
			
			LOG.error(e.getMessage());
		}
		dispatcher= request.getRequestDispatcher("ProductDescription.jsp");
		request.setAttribute("result", result);
		dispatcher.forward(request, response);
	}

}
