package com.pet.petstore.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ProductDAOTest {
ProductDAO pd= new ProductDAO();
List sample= new ArrayList();
int nsize=0;
	@Test
	public void testGetCategories() throws PetStoreDAOException {
		
		
		try {
			sample=pd.getCategories();
		} catch (PetStoreDAOException e) {
			
			throw new PetStoreDAOException(e);
		}
		nsize=sample.size();
		assertEquals(nsize, 4);
		
	}

	@Test
	public void testGetcatById() throws PetStoreDAOException {
		try {
			sample=pd.getcatById(1);
		} catch (PetStoreDAOException e) {
			// TODO Auto-generated catch block
			throw new PetStoreDAOException(e);
		}
		nsize=sample.size();
		assertEquals(nsize, 1);
	}

	@Test
	public void testGetProductList() throws PetStoreDAOException {
		try {
			sample=pd.getProductList(1);
		} catch (PetStoreDAOException e) {
			// TODO Auto-generated catch block
			throw new PetStoreDAOException(e);
		}
		
		nsize=sample.size();
		assertEquals(nsize, 4);
	}

	@Test
	public void testGetProduct() throws PetStoreDAOException {
		try {
			sample=pd.getProduct(1, 10001);
		} catch (PetStoreDAOException e) {
			// TODO Auto-generated catch block
			throw new PetStoreDAOException(e);
		}
		nsize=sample.size();
		assertEquals(nsize, 1);
		
	}

	@Test
	public void testGetItemList() throws PetStoreDAOException {
		try {
			sample=pd.getItemList(1);
		} catch (PetStoreDAOException e) {
			// TODO Auto-generated catch block
			throw new PetStoreDAOException(e);
		}
		nsize=sample.size();
		assertEquals(nsize, 6);
	}

	

}
