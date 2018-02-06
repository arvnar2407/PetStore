package com.pet.petstore.web.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.pet.mvc.HttpRequestHandler;
import com.pet.petstore.domain.Cart;
import com.pet.petstore.domain.CartItem;
import com.pet.petstore.domain.Item;
import com.pet.petstore.service.PetStoreException;
import com.pet.petstore.service.PetStoreFacade;

public class ConfirmPurchase implements HttpRequestHandler{
	public final static Logger LOG = Logger.getLogger(ConfirmPurchase.class);
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Item> data= new ArrayList<Item>();
		HttpSession session=request.getSession();
		PetStoreFacade facade= new PetStoreFacade();
		RequestDispatcher dispatcher=null;
		Cart cart= new Cart();
		String[] values = request.getParameterValues("checkboxGroup");
		String[] quantity=request.getParameterValues("qty");
		session.setAttribute("values", values);
		List<String> qty= new ArrayList();
		List<Item> pass= new ArrayList<Item>();
		List<Cart> display=null;
		for(int i=0;i<quantity.length;i++)
		{
			qty.add(quantity[i]);
		}
		  for(int i=0; i<values.length; i++) {	
			 
			  String a[]  = values[i].split(",");
			int itemid=Integer.parseInt(a[0]);
			int prodid=Integer.parseInt(a[1]);
			int cid=Integer.parseInt(a[2]);
			try {
				data=facade.getItem(cid, prodid, itemid);
				for(Item p:data)
				{
					pass.add(p);
				}
			
			} catch (PetStoreException e) {
				
				LOG.info(e.getMessage());
			}
	        }
		 
		dispatcher=request.getRequestDispatcher("PaymentMode.jsp");
		session.setAttribute("pdata", pass);
		dispatcher.forward(request, response);
		
	       
	          
	        }

	}


