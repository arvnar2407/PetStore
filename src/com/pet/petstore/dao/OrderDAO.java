package com.pet.petstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.pet.dbcon.ConnectionHolder;
import com.pet.dbcon.DBConnectionException;
import com.pet.dbfw.DBFWException;
import com.pet.dbfw.DBHelper;
import com.pet.dbfw.ParamMapper;
import com.pet.dbfw.ResultMapper;
import com.pet.petstore.domain.Cart;
import com.pet.petstore.domain.CartItem;
import com.pet.petstore.domain.Item;

public class OrderDAO {
	public final static Logger LOG = Logger.getLogger(OrderDAO.class);
	private Connection establishConnection() throws DBFWException,
	ClassNotFoundException, SQLException, PetStoreDAOException  
	{
		Connection con= null;
		final String url="jdbc:oracle:thin:@localhost:1521:xe";
		final String user="system";
		final String password="Nttdata@123";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			
		throw new PetStoreDAOException(e);
		} catch (SQLException e) {
			
			throw new PetStoreDAOException(e);
		}
		
		return con;
	}
	
	/*private Connection establishConnection() throws DBFWException,
	ClassNotFoundException, SQLException, PetStoreDAOException {
		Connection con=null;
		ConnectionHolder ch = null;
	
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
		} catch (DBConnectionException e) {
			log.error(e.getMessage());
			throw new PetStoreDAOException("Unable to fetch data for user validation",e);
		}

			return con;
	}*/
	
	int generateOrderId() throws PetStoreDAOException
	{
		Connection con= null;
		int res=0;
	try {
		
		con=establishConnection();
		res=(Integer)(DBHelper.executeSelect(con, SqlMapper.ORDER_ID, SqlMapper.MAP_ORDID).get(0));
		
				} 
	catch (DBFWException e) {
		throw new PetStoreDAOException(e);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		throw new PetStoreDAOException(e);
	} catch (SQLException e) {
		throw new PetStoreDAOException(e);
	}
	return res;
	}
	
	
	
	public int placeOrder(final Cart shoppingCart) throws PetStoreDAOException
	{
		Connection con= null;
		int rows=0;
		int id;
		shoppingCart.setOrderId(generateOrderId());
		id=shoppingCart.getOrderId();
		List<CartItem> itemids= shoppingCart.getItemDetails();
		final Iterator it =itemids.iterator();
		while(it.hasNext())
		{
		try {
			con=establishConnection();
			ParamMapper mapParam= new ParamMapper(){
				@Override
				public void mapParams(PreparedStatement psmt)
						throws SQLException {
					psmt.setInt(1, shoppingCart.getOrderId());
					psmt.setString(2,shoppingCart.getCustId());
					CartItem temp=(CartItem) it.next();
					psmt.setInt(3, temp.getItem().getItemId());
					psmt.setInt(4, temp.getItem().getProductId());
					psmt.setInt(5, temp.getItem().getCategoryId());
					psmt.setInt(6, temp.getQuantity());
					
					
				}
			};
			
			rows=DBHelper.executeUpdate(con, SqlMapper.INSERT_INTO_PURCHASE_DETAIL, mapParam);
		} catch (DBFWException e) {
			throw new PetStoreDAOException(e);
		} catch (ClassNotFoundException e) {
			throw new PetStoreDAOException(e);
		} catch (SQLException e) {
			throw new PetStoreDAOException(e);
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new PetStoreDAOException(e);
			}
		}
		}
		if(rows>0)
		{
		return id;
	}
		return id;
	
	}
	
	
	public  List<Cart> getPurchaseDetails(final int orderId) throws PetStoreDAOException
	{
		Connection con=null;
		List<Cart>result= new ArrayList<Cart>();
		try {
			con=establishConnection();
			ParamMapper mapParam= new ParamMapper()
			{
				@Override
				public void mapParams(PreparedStatement psmt)
						throws SQLException {
					psmt.setInt(1, orderId);					
				}
			};
			result=DBHelper.executeSelect(con, SqlMapper.PROJECT_PURCHASEDETAIL, SqlMapper.MAP_PURCHASE_DETAILS, mapParam);
		} catch (DBFWException e) {
			throw new PetStoreDAOException(e);
		} catch (ClassNotFoundException e) {
			throw new PetStoreDAOException(e);
			
		} catch (SQLException e) {
			throw new PetStoreDAOException(e);
			
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new PetStoreDAOException(e);
			}
		}
		
		return result;
	}
}
