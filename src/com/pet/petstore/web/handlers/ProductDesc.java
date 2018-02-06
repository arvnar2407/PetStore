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

public class ProductDesc implements HttpRequestHandler {
	public final static Logger LOG = Logger.getLogger(ProductDesc.class);
@Override
public void handle(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	RequestDispatcher dispatcher= null;
	PetStoreFacade facade=new PetStoreFacade();
	String id=request.getParameter("select2");
	String cid[]=id.split(" ");
	int rid=Integer.parseInt(cid[0]);
	int pid=Integer.parseInt(cid[1]);
	
	List<Item> result= new ArrayList<Item>();
	try {
		result=facade.getItem(rid, pid);
	} catch (PetStoreException e) {
		String error=e.getMessage();
		LOG.info(error);
	}
	dispatcher= request.getRequestDispatcher("ProductDescription.jsp");
	request.setAttribute("result", result);
	dispatcher.forward(request, response);
}
}
