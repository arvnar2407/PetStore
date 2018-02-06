package com.pet.petstore.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;







//import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.pet.dbfw.DBFWException;
import com.pet.petstore.dao.OrderDAO;
import com.pet.petstore.dao.PetStoreDAOException;
import com.pet.petstore.dao.ProductDAO;
import com.pet.petstore.dao.UserDAO;
import com.pet.petstore.domain.Cart;
import com.pet.petstore.domain.Category;
import com.pet.petstore.domain.Customer;
import com.pet.petstore.domain.Item;
import com.pet.petstore.service.PetStoreException;

public class PetStoreFacade {
	
	public boolean validateUser(String userId, String password) throws PetStoreException
	{
		boolean result=false;
		UserDAO user= new UserDAO();
		try {
			result=user.validateUser(userId, password);
		} catch (PetStoreDAOException e) {
			throw new PetStoreException(e);
			
		} catch (Exception e) {
			throw new PetStoreException(e);
		}
		return result;
	}
	
	public String registerUser(Customer customer) throws PetStoreException
	{
		UserDAO user= new UserDAO();
		Customer c= new Customer();
		Boolean b=false;
	boolean result= false;
		try {
			c=user.registerUser(customer);
			
			
		} catch (PetStoreDAOException e) {
			throw new PetStoreException(e);
		} catch (Exception e) {
			throw new PetStoreException(e);
		}
		
	return c.getCustId();
		
	}
	
	
	public List<Category> getCategories() throws PetStoreException
	{
		ProductDAO product= new ProductDAO();
		List<Category> result= new ArrayList<Category>();
		try {
			result=product.getCategories();
		} catch (PetStoreDAOException e) {
			throw new PetStoreException(e);
		}
		return result;
	}
	
	public Category getcatById(int categId) throws PetStoreException
	{
		ProductDAO product= new ProductDAO();
		List<Category>  data= new ArrayList<Category>();
		Category temp=new Category();
		
		try {
			data= product.getcatById(categId);
			 Iterator t= data.iterator();
			 while(t.hasNext())
			 {
				 temp=(Category) t.next();
			 }
	
		} catch (PetStoreDAOException e) {
			throw new PetStoreException(e);
		}
		return temp;
	}
	
public List getProductList(int categid) throws PetStoreException
{
	ProductDAO product= new ProductDAO();
	List data = new ArrayList();
	try {
		data= product.getProductList(categid);
	} catch (PetStoreDAOException e) {
		throw new PetStoreException(e);
	}
	return data;
}

public List getProduct(int categid, int prodId) throws PetStoreException
{
	ProductDAO product= new ProductDAO();
	List data = new ArrayList();
	try {
		data= product.getProduct(categid, prodId);
	} catch (PetStoreDAOException e) {
		throw new PetStoreException(e);
	}
	return data;
}

public List<Item> getItemList(int categid) throws PetStoreException
{
	ProductDAO product= new ProductDAO();
	List<Item> data = new ArrayList();
	try {
		data= product.getItemList(categid);
	} catch (PetStoreDAOException e) {
		throw new PetStoreException(e);
	}
	return data;
}

public List<Item> getItem(int categid, int productId) throws PetStoreException
{
	ProductDAO product= new ProductDAO();
	List<Item> data = new ArrayList();
	try {
		data= product.getItem(categid, productId);
	} catch (PetStoreDAOException e) {
		throw new PetStoreException(e);
	}
	return data;
}

public List getItem(int categid, int productId, int itemid) throws PetStoreException
{
	ProductDAO product= new ProductDAO();
	List<Item> data = new ArrayList();
	try {
		data= product.getItem(categid, productId,itemid);
	} catch (PetStoreDAOException e) {
		throw new PetStoreException(e);
	}
	return data;
}


public int placeOrder(Cart shoppingCart) throws PetStoreException
{
	int result=0;
	OrderDAO order= new OrderDAO();
	try {
		result=order.placeOrder(shoppingCart);
		
		
	} catch (PetStoreDAOException e) {
		throw new PetStoreException(e);
	}
	return result;
}

public List<Cart> getpurchaseDetails(int orderid) throws PetStoreException
{
	OrderDAO order= new OrderDAO();
	List<Cart> rdata= null;
	try {
		rdata=(List<Cart>) order.getPurchaseDetails(orderid);
	} catch (PetStoreDAOException e) {
		throw new PetStoreException(e);
	}
	return rdata;
}
}
