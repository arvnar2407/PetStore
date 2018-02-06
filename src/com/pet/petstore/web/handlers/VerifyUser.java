package com.pet.petstore.web.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.pet.mvc.HttpRequestHandler;
import com.pet.petstore.domain.Category;
import com.pet.petstore.service.PetStoreException;
import com.pet.petstore.service.PetStoreFacade;

public class VerifyUser  implements HttpRequestHandler{

public final static Logger LOG = Logger.getLogger(VerifyUser.class);
public void handle(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	boolean res= false;
	LOG.info("in handler");
	PetStoreFacade facade= new PetStoreFacade();
String username=request.getParameter("uname");
String password= request.getParameter("pass");
HttpSession session=request.getSession(true);
RequestDispatcher dispatcher=null;
List<Category> data= new ArrayList<Category>();
try {
	res=facade.validateUser(username, password);
	data=facade.getCategories();
	
} catch (PetStoreException e) {
	LOG.error(e.getMessage());
}
if(res)
{
session.setAttribute("uid", username);
session.setAttribute("categories", data);
dispatcher=request.getRequestDispatcher("../pages/search.jsp");
dispatcher.forward(request, response);
}
else
{
	dispatcher=request.getRequestDispatcher("Login.jsp");
	request.setAttribute("msg", "The user does not exsist");
	dispatcher.forward(request, response);
}
	
}
}
