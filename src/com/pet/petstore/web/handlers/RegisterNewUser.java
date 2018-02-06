package com.pet.petstore.web.handlers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.pet.mvc.HttpRequestHandler;
import com.pet.petstore.domain.Category;
import com.pet.petstore.domain.Customer;
import com.pet.petstore.service.PetStoreException;
import com.pet.petstore.service.PetStoreFacade;

public class RegisterNewUser implements HttpRequestHandler{
	public final static Logger LOG = Logger.getLogger(RegisterNewUser.class);
public void handle(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
Customer customer= new Customer();
PetStoreFacade facade= new PetStoreFacade();
String cid=null;
HttpSession session=request.getSession();
RequestDispatcher dispatcher=null;
List<Category> data= new ArrayList<Category>();
customer.setPassword(request.getParameter("pass"));
customer.setFirstName(request.getParameter("fname"));
customer.setLastName(request.getParameter("lname"));
String date=request.getParameter("dob");
  SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
java.util.Date d=null;
try{
 d=sf.parse(date);
} catch (java.text.ParseException e) {
	LOG.error(e.getMessage());
}
customer.setDateOFBirth(d);
customer.setAddress(request.getParameter("address"));
long contactno=Long.parseLong(request.getParameter("contact"));
customer.setContactNumber(contactno);
long creditno=Long.parseLong(request.getParameter("credit"));
customer.setCreditCardno(creditno);
customer.setCardType(request.getParameter("cardtype"));
String cdate=request.getParameter("carddate");
java.util.Date d1=null;
try{
	 d1=sf.parse(cdate);
	} catch (java.text.ParseException e) {
		LOG.error(e.getMessage());
	}
customer.setCardExpiryDate(d1);


try {
	data=facade.getCategories();
	cid=facade.registerUser(customer);
	
} catch (PetStoreException e) {
	LOG.error(e.getMessage());
}
session.setAttribute("uid", cid);
if(!cid.equals(null))
{

dispatcher=request.getRequestDispatcher("../pages/search.jsp");
session.setAttribute("categories", data);
dispatcher.forward(request, response);
}
else
{
	dispatcher=request.getRequestDispatcher("../pages/Registration.jsp");
	request.setAttribute("error", "The insertion was not sucessful please login again");
	dispatcher.forward(request, response);
}
}
}

