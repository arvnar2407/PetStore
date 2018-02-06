package com.pet.petstore.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	
	private int orderId;
	private String custId;
	private List<CartItem> itemDetails= new  ArrayList<CartItem>();

	public Cart()
	{
		
	}
	
	public CartItem addCartItem(Item obj, int qty){
		CartItem cait= new CartItem();
		cait.setItem(obj);
		cait.setQuantity(qty);
		itemDetails.add(cait);
		return cait;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	public List<CartItem> getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(List<CartItem> tails) {
		this.itemDetails = tails;
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(orderId);
		builder.append(custId);
		builder.append(itemDetails);
		return builder.toString();
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		result = prime * result
				+ ((itemDetails == null) ? 0 : itemDetails.hashCode());
		result = prime * result + orderId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final Cart other = (Cart) obj;
		if (custId == null) {
			if (other.custId != null)
			{
				return false;
			}
		} else if (!custId.equals(other.custId))
			return false;
		if (itemDetails == null) {
			if (other.itemDetails != null)
			{
				return false;
			}
		} else if (!itemDetails.equals(other.itemDetails))
			{
			return false;
			}
		if (orderId != other.orderId)
			{
			return false;
			}
		return true;
	}
	
	

}
