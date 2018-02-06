package com.pet.petstore.web.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.mvc.HttpRequestHandler;
import com.pet.petstore.domain.Category;

public class CatalogDesc implements HttpRequestHandler{
@Override
public void handle(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	HttpSession session=request.getSession();
	RequestDispatcher dispatcher= null;
	List<Category> data= new ArrayList<Category>();
	data=(List<Category>)session.getAttribute("categories");
	dispatcher=request.getRequestDispatcher("../pages/Catalog.jsp");
	dispatcher.forward(request, response);
	
}
}
