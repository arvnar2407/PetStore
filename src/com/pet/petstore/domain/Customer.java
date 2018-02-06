package com.pet.petstore.domain;

import java.util.Date;

public class Customer {

	
	private String custId;
	private String password;
	private String firstName;
	private String lastName;
	private Date dateOFBirth;
	private String address;
	private long contactNumber;
	private long creditCardno;
	private String cardType;
	private Date cardExpiryDate;
	public String getCustId() {
		return custId;
	}
	public void setCustId(final String custId) {
		this.custId = custId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(final String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}
	
	public Date getDateOFBirth() {
		return dateOFBirth;
	}
	public void setDateOFBirth(Date dateOFBirth) {
		this.dateOFBirth = dateOFBirth;
	}
	public void setCardExpiryDate(Date cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(final String address) {
		this.address = address;
	}

	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public long getCreditCardno() {
		return creditCardno;
	}
	public void setCreditCardno(long creditCardno) {
		this.creditCardno = creditCardno;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(final String cardType) {
		this.cardType = cardType;
	}
	public Date getCardExpiryDate() {
		return cardExpiryDate;
	}
	public void setCiryDate(final Date cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((cardExpiryDate == null) ? 0 : cardExpiryDate.hashCode());
		result = prime * result
				+ ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result
				+ (int) (contactNumber ^ (contactNumber >>> 32));
		result = prime * result + (int) (creditCardno ^ (creditCardno >>> 32));
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		result = prime * result
				+ ((dateOFBirth == null) ? 0 : dateOFBirth.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cardExpiryDate == null) {
			if (other.cardExpiryDate != null)
				return false;
		} else if (!cardExpiryDate.equals(other.cardExpiryDate))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		} else if (!cardType.equals(other.cardType))
			return false;
		if (contactNumber != other.contactNumber)
			return false;
		if (creditCardno != other.creditCardno)
			return false;
		if (custId == null) {
			if (other.custId != null)
				return false;
		} else if (!custId.equals(other.custId))
			return false;
		if (dateOFBirth == null) {
			if (other.dateOFBirth != null)
				return false;
		} else if (!dateOFBirth.equals(other.dateOFBirth))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	

}
