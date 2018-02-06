package com.pet.petstore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.pet.dbcon.ConnectionHolder;
import com.pet.dbcon.DBConnectionException;
import com.pet.dbfw.DBFWException;
import com.pet.dbfw.DBHelper;
import com.pet.dbfw.ParamMapper;
import com.pet.dbfw.ResultMapper;
import com.pet.petstore.domain.Customer;
import com.pet.petstore.web.handlers.DisplayBasket;

public class UserDAO {
	public final static Logger LOG = Logger.getLogger(UserDAO.class);
	public UserDAO()
	{
		super();
	}
	private Connection establishConnection() throws ClassNotFoundException, SQLException, DBFWException
	{
		Connection con= null;
		final String url="jdbc:oracle:thin:@localhost:1521:xe";
		final String user="system";
		final String password="Nttdata@123";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, user, password);
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

	
	
	public Boolean validateUser(final String userId, final String password) throws PetStoreDAOException
	{
		Connection con =null;
		List data = new ArrayList();
		boolean result=false;
		ParamMapper mapParam= new ParamMapper()
		{

			@Override
			public void mapParams(PreparedStatement psmt) throws SQLException {
				// TODO Auto-generated method stub
				psmt.setString(1, userId);
				psmt.setString(2, password);
			}
			
		};
		try {
			con=establishConnection();
		
	try {
		data = DBHelper.executeSelect(con, SqlMapper.VALIDATE_USER, SqlMapper.MAP_USER, mapParam);
	} catch (DBFWException e) {
		throw new PetStoreDAOException(e);
	}
	if(data.isEmpty())
	result=false;
	else 
	result= true;
		} catch (ClassNotFoundException e) {
			
			throw new PetStoreDAOException(e);
		} catch (SQLException e) {
			
			throw new PetStoreDAOException(e);
		} catch (DBFWException e) {
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
	
	public String id;
	public Customer registerUser(final Customer customerObject) throws PetStoreDAOException, DBFWException, ClassNotFoundException
	{
		Connection con= null;
		Boolean result=false;
		List<String> data= new ArrayList<String>();
		
		try {
			con=establishConnection();
			customerObject.setCustId((DBHelper.executeSelect(con, SqlMapper.CUSTOMER_ID, SqlMapper.MAP_CUSTID ).get(0)).toString());
		} catch (ClassNotFoundException e1) {
			throw new PetStoreDAOException(e1);
		} catch (SQLException e1) {
			throw new PetStoreDAOException(e1);
		}
	
		ParamMapper mapParam2 = new ParamMapper()
		{
			@Override
			public void mapParams(PreparedStatement psmt) throws SQLException {
				psmt.setLong(1, customerObject.getCreditCardno());
				psmt.setString(2, customerObject.getCardType());
				java.sql.Date sqlDate= new Date(customerObject.getCardExpiryDate().getTime());
				psmt.setDate(3, sqlDate);
				
			}
		};
		int rows2=0;
		try {
			con=establishConnection();
			rows2=DBHelper.executeUpdate(con, SqlMapper.INSERT_CARDINFO, mapParam2);
		
		} catch (SQLException e) {
			throw new PetStoreDAOException();
		}
		
		ParamMapper mapParam= new ParamMapper()
		{

			@Override
			public void mapParams(PreparedStatement psmt) throws SQLException {
				// TODO Auto-generated method stub
				psmt.setString(1, customerObject.getCustId());
				psmt.setString(2, customerObject.getFirstName());
				psmt.setString(3,customerObject.getLastName());
				java.sql.Date sqlDate= new Date(customerObject.getDateOFBirth().getTime());
				psmt.setDate(4, sqlDate);
				psmt.setString(5, customerObject.getAddress());
				psmt.setLong(6, customerObject.getContactNumber());
				psmt.setLong(7, customerObject.getCreditCardno());
				
			}
			
		};
		
		ParamMapper  mapParam1= new ParamMapper()
		{
			@Override
			public void mapParams(PreparedStatement psmt) throws SQLException {
				
				psmt.setString(1, customerObject.getCustId());
				psmt.setString(2, customerObject.getPassword());
			}
		};
		
		int rows1=0;
		try {
			
			con=establishConnection();
			rows1=DBHelper.executeUpdate(con, SqlMapper.INSERT_USER, mapParam1);
		
		} catch (ClassNotFoundException e) {
			throw new PetStoreDAOException(e);
		} catch (SQLException e) {
			throw new PetStoreDAOException(e);
		}
		
		
		int rows=0;
		try {
			con=establishConnection();
			rows=DBHelper.executeUpdate(con, SqlMapper.INSERT_CUSTOMER, mapParam);
		
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
		
		
		if((rows>0 )&& (rows1>0) &&( rows2>0))
		{
			result=true;
	}
		
		
		return customerObject;
	
	}
}
