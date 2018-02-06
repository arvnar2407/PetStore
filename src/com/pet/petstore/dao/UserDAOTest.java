package com.pet.petstore.dao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import org.junit.Test;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.pet.dbfw.DBFWException;
import com.pet.petstore.domain.Customer;

public class UserDAOTest {
	UserDAO ud= new UserDAO();
	@Test
	public void testValidateUser() throws PetStoreDAOException {
		
		String userId="181";
		String password="asdf";
		boolean res=false;
		try {
			res=ud.validateUser(userId, password);
		} catch (PetStoreDAOException e) {
		throw new PetStoreDAOException(e);
		}
		assertEquals(res, true);
		
	}

	@Test
	public void testRegisterUser() throws PetStoreDAOException {
		Customer customer= new Customer();
		Customer rcustomer= new Customer();
		customer.setAddress("hyd");
		String date="12/12/2050";
	
		SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date d=null;
		try{
		 d=sf.parse(date);
		} catch (java.text.ParseException e) {
			throw new PetStoreDAOException(e);
		}
		customer.setCardExpiryDate(d);
		customer.setCardType("visa");
		customer.setCiryDate(d);
		customer.setContactNumber(1234567890);
		customer.setCustId("100");
		customer.setDateOFBirth(d);
		customer.setCreditCardno(1234567890);
		customer.setFirstName("laxman");
		customer.setLastName("laxman");
		customer.setPassword("qaws");
		try {
			rcustomer=ud.registerUser(customer);
		} catch (PetStoreDAOException e) {
			// TODO Auto-generated catch block
			throw new PetStoreDAOException(e);
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			throw new PetStoreDAOException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new PetStoreDAOException(e);
		}
		
		assertEquals(rcustomer,customer );
	}

}
