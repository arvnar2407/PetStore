package com.pet.petstore.dao;

import static org.junit.Assert.*;

import java.awt.image.SampleModel;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pet.petstore.domain.Cart;
import com.pet.petstore.domain.Item;

public class OrderDAOTest {
OrderDAO order= new OrderDAO();
	@Test
	public void testGenerateOrderId() throws PetStoreDAOException {
		int id=0;
		try {
			id=order.generateOrderId();
		} catch (PetStoreDAOException e) {
			// TODO Auto-generated catch block
			throw new PetStoreDAOException();
		}
		assertEquals(id, 262);
	}

	@Test
	public void testPlaceOrder() throws PetStoreDAOException {
		Cart cart=new Cart();
		Item item=new Item();
		item.setCategoryId(1);
		item.setProductId(10001);
		item.setItemId(1011);
		item.setItemName("steel chain");
		item.setItemDescription("to tie the dog");
		item.setItemPrice(400);
		cart.addCartItem(item, 4);
		cart.setCustId("63");
		
		
	try {
			int id= order.placeOrder(cart);
			assertEquals(id, 262);
	} catch (PetStoreDAOException e) {
		// TODO Auto-generated catch block
		throw new PetStoreDAOException(e);
	} 
	
		
		
	}

	@Test
	public void testGetPurchaseDetails() throws PetStoreDAOException {
	int size=0;
		List sample= new ArrayList();
		try {
			sample=order.getPurchaseDetails(240);
		} catch (PetStoreDAOException e) {
			// TODO Auto-generated catch block
			throw new PetStoreDAOException(e);
		}
		size=sample.size();
		assertEquals(size, 2);
		
	}

}
