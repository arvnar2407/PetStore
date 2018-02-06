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

public class DisplayBasket implements HttpRequestHandler{
	public final static Logger LOG = Logger.getLogger(DisplayBasket.class);
@Override
public void handle(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	List<Item> data= new ArrayList<Item>();
	List<Item> passdetails= new ArrayList<Item>();
	HttpSession session=request.getSession();
	PetStoreFacade facade= new PetStoreFacade();
	RequestDispatcher dispatcher=null;
	int total=0;
	int orderId=0;
	Cart cart= new Cart();
	List <String> qty= new ArrayList();
	List<Cart> display=null;
	String[] values = (String[])session.getAttribute("values");
	String[] quantity=request.getParameterValues("qty");
	
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
			
			for(int j=0;j<data.size();j++)
			{
				
				cart.addCartItem(data.get(j), Integer.parseInt(qty.get(j)));
				cart.setCustId(session.getAttribute("uid").toString());
			
			}
			
		
		} catch (PetStoreException e) {
			
			LOG.error(e.getMessage());
		}
        }
	  List<CartItem> cartp=cart.getItemDetails();
	  
		for(int i=0;i<quantity.length;i++)
		{
		
			total=total+(Integer.parseInt(quantity[i])*cartp.get(i).getItem().getItemPrice());
			//total=total+((data.get(i)).getItemPrice()*Integer.parseInt(qty.get(i)));
		}
		Cart myCart=new Cart();
	   
	 try {
		orderId=facade.placeOrder(cart);
	} catch (PetStoreException e) {
		
		
		LOG.error(e.getMessage());
	}
	
	
	dispatcher=request.getRequestDispatcher("PurchaseSummary.jsp");
	request.setAttribute("quantity", qty);
	session.setAttribute("orderId", orderId);
	session.setAttribute("tprice", total);
	dispatcher.forward(request, response);
	
       
          
}
}
