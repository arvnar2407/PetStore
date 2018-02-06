package com.pet.petstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pet.dbfw.ResultMapper;
import com.pet.petstore.domain.Cart;
import com.pet.petstore.domain.CartItem;
import com.pet.petstore.domain.Category;
import com.pet.petstore.domain.Customer;
import com.pet.petstore.domain.Item;
import com.pet.petstore.domain.Product;
import com.pet.petstore.domain.User;

public class SqlMapper {
	
	public static final String VALIDATE_USER="select * from users where custId=? and password=? " ;
	public static final String CUSTOMER_ID="select cust_seq.nextval from dual";
	public static final String ORDER_ID="select order_seq.nextval from dual";
	public static final String INSERT_CUSTOMER="insert into customer values(?,?,?,?,?,?,?)";
	public static final String INSERT_USER="insert into users values(?,?)";
	public static final String INSERT_CARDINFO="insert into creditcard_info values(?,?,?)";
	public static final String PROJECT_CATEGORY="select * from categories";
	public static final String PROJECT_PARTICULAR_CATEGORY="select * from categories where categid=?";
	public static final String PROJECT_PRODUCT_LIST_PCATEGORY="select * from category_products where categid=?";
	public static final String POJECT_PARTICULAR_PRODUCT="select * from category_products where categid=? and prodid=?";
	public static final String PROJECT_ITEM_LIST="select * from product_line_items where categid=?";
	public static final String PROJECT_SINGLE_ITEM="select * from product_line_items where categid=? and prodid=?";
	public static final String PROJECT_ITEM_THREE_ID="select * from product_line_items where categid=? and prodid=? and itemid=?";
	public static final String PROJECT_SINGLE_ITEM_ITID="select * from product_line_items where itemid=?"; 
	public static final String INSERT_INTO_PURCHASE_DETAIL="insert into purchase_detail values(?,?,?,?,?,?)";
	public static final String PROJECT_PURCHASEDETAIL="select * from purchase_detail where orderid=?";
	
	public static final ResultMapper MAP_CUSTOMER  = new ResultMapper(){
	@Override
	public Object mapRows(ResultSet resultSet) throws SQLException {
		Customer customer= new Customer();
		customer.setCustId(resultSet.getString("custId"));
		customer.setPassword(resultSet.getString("password"));
		customer.setFirstName(resultSet.getString("firstName"));
		customer.setLastName(resultSet.getString("lastName"));
		customer.setDateOFBirth(resultSet.getDate("dateOFBirth"));
		customer.setAddress(resultSet.getString("address"));
		customer.setContactNumber(resultSet.getLong("contactNumber"));
		customer.setCreditCardno(resultSet.getLong("creditCardno"));
		customer.setCardType(resultSet.getString("cardType"));
		customer.setCiryDate(resultSet.getDate("cardExpiryDate"));
		return customer;
	}
};

public static final ResultMapper MAP_PURCHASE_DETAILS= new ResultMapper()
{
	@Override
	public Object mapRows(ResultSet resultSet) throws SQLException {
		Item i= new Item();
		 Cart mapCart = new Cart();
		mapCart.setOrderId(resultSet.getInt("orderId"));
		mapCart.setCustId(resultSet.getString("custId"));
		i.setItemId(resultSet.getInt("ITEMID"));
		i.setProductId(resultSet.getInt("PRODID"));
		i.setCategoryId(resultSet.getInt("CATEGID"));	
		mapCart.addCartItem(i, resultSet.getInt("quantity"));
		return mapCart;
	}
};

public static final ResultMapper MAP_USER= new ResultMapper()
{

	@Override
	public Object mapRows(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setCustId(resultSet.getString("custId"));
		user.setPwd(resultSet.getString("password"));
		return user;
	}
	
};

public static final ResultMapper MAP_CATEGORY= new ResultMapper()
{

	@Override
	public Object mapRows(ResultSet resultSet) throws SQLException {

		Category category = new Category();
		category.setCategoryId(resultSet.getInt(1));
		category.setCategoryName(resultSet.getString(2));
		category.setCategoryDescription(resultSet.getString(3));
		return category;
	}
	
};


public static final ResultMapper MAP_CUSTID=  new ResultMapper()
{
	public Object mapRows(ResultSet resultSet) throws SQLException {
	
		String i=resultSet.getString(1);
		return i;
		
	}
};

public static final ResultMapper MAP_ORDID=  new ResultMapper()
{
	public Object mapRows(ResultSet resultSet) throws SQLException {
		Integer result=0;
		result=resultSet.getInt(1);
		return result;
		
	}
};

public static final ResultMapper MAP_CUSTOMERTABLE = new ResultMapper()
{
	public Object mapRows(final ResultSet resultSet) throws SQLException {
		Customer customer= new Customer();
		customer.setCustId(resultSet.getString("custId"));
		customer.setFirstName(resultSet.getString("firstName"));
		customer.setLastName(resultSet.getString("lastName"));
		customer.setDateOFBirth(resultSet.getDate("dateOFBirth"));
		customer.setAddress(resultSet.getString("address"));
		customer.setContactNumber(resultSet.getLong("contactNumber"));
		customer.setCreditCardno(resultSet.getLong("creditCardno"));
		return customer;
		
	}
};

public static final ResultMapper MAP_PRODUCT_FPCATEGORY= new ResultMapper()
{
	@Override
	public Object mapRows(ResultSet resultSet) throws SQLException {
		Product product = new Product();
		product.setCategoryId(resultSet.getInt(2));
		product.setProductId(resultSet.getInt(1));
		product.setProductDescription(resultSet.getString(3));
		product.setProductName(resultSet.getString(4));
		
		return product;
	}
};

public static final ResultMapper MAP_ITEMS= new ResultMapper()
{
	@Override
	public Object mapRows(ResultSet resultSet) throws SQLException {
		Item item= new Item();
		item.setItemId(resultSet.getInt(1));
		item.setProductId(resultSet.getInt(2));
		item.setCategoryId(resultSet.getInt(3));
		item.setItemName(resultSet.getString(4));
		item.setItemDescription(resultSet.getString(5));
		item.setItemPrice(resultSet.getInt(6));
		return item;
	}
};
}
