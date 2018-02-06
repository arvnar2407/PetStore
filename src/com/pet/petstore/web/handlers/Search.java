package com.pet.petstore.web.handlers;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.mvc.HttpRequestHandler;
import com.pet.petstore.domain.Product;
import com.pet.petstore.service.PetStoreException;
import com.pet.petstore.service.PetStoreFacade;

public class Search implements HttpRequestHandler{
	public final static Logger LOG = Logger.getLogger(Search.class);

public void handle(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	LOG.debug("Constructor Called For Test Function");


	PetStoreFacade facade= new PetStoreFacade();
	RequestDispatcher dispatcher= null;
	HttpSession session=request.getSession();
	String value=request.getParameter("val");
	int passid=Integer.parseInt(value); 
	
	
	List<Product> prodList=new ArrayList<Product>();
	
	try {
		
		prodList=facade.getProductList(passid);
	} catch (PetStoreException e) {
		LOG.error(e.getMessage());
	}
	
	dispatcher=request.getRequestDispatcher("../pages/search.jsp");
	session.setAttribute("prodList", prodList);
	request.setAttribute("category", value);
	dispatcher.forward(request, response);
}
}





