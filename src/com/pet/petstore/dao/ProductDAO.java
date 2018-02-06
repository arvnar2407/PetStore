package com.pet.petstore.dao;

import java.sql.Connection;
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
import com.pet.petstore.domain.Category;
import com.pet.petstore.domain.Item;

public class ProductDAO {
	public final static Logger LOG = Logger.getLogger(ProductDAO.class);
	private Connection establishConnection() throws ClassNotFoundException, SQLException, DBFWException
	{
		Connection con= null;
		final String url="jdbc:oracle:thin:@localhost:3306:xe";
		final String user="root";
		final String password="arvind";
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
	
	public List getCategories() throws PetStoreDAOException
	{
		List<Category> data= new ArrayList<Category>(); 
		Connection con= null;
		try {
			con=establishConnection();
			data=DBHelper.executeSelect(con, SqlMapper.PROJECT_CATEGORY, SqlMapper.MAP_CATEGORY);
			
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
	
		return data;
	}
	
	public List<Category> getcatById( final int categId) throws PetStoreDAOException
	{
		List<Category> data= new ArrayList<Category>(); 
		Connection con= null;
		try {
			con=establishConnection();
			ParamMapper mapParam= new ParamMapper()
			{
				@Override
				public void mapParams(PreparedStatement psmt)
						throws SQLException {
					psmt.setInt(1, categId);
				}
			};
		
			data = DBHelper.executeSelect(con, SqlMapper.PROJECT_PARTICULAR_CATEGORY, SqlMapper.MAP_CATEGORY, mapParam);
			
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
		return data;
	}
	
	public List getProductList(final int categId) throws PetStoreDAOException
	{
		List data= new ArrayList();
		Connection con =null;
		try {
			try {
				con=establishConnection();
			} catch (DBFWException e1) {
				// TODO Auto-generated catch block
				throw new PetStoreDAOException(e1);
			}
			ParamMapper mapParam= new ParamMapper()
			{
				@Override
				public void mapParams(PreparedStatement psmt)
						throws SQLException {
					psmt.setInt(1, categId);
					
				}
				
			};
			try {
				data=DBHelper.executeSelect(con, SqlMapper.PROJECT_PRODUCT_LIST_PCATEGORY, SqlMapper.MAP_PRODUCT_FPCATEGORY, mapParam);
				
			} catch (DBFWException e) {
				throw new PetStoreDAOException();
			}
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			throw new PetStoreDAOException(e);
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				throw new PetStoreDAOException(e);
			}
		}
		return data;
	}
	
	public List getProduct(final int categId,final  int productId) throws PetStoreDAOException
	{
		List data= new ArrayList();
		Connection con =null;
		try {
			con=establishConnection();
			ParamMapper mapParam= new ParamMapper()
			{
				@Override
				public void mapParams(PreparedStatement psmt)
						throws SQLException {
					psmt.setInt(1, categId);
					psmt.setInt(2, productId);
					
				}
				
			};
			try {
				data=DBHelper.executeSelect(con, SqlMapper.POJECT_PARTICULAR_PRODUCT, SqlMapper.MAP_PRODUCT_FPCATEGORY, mapParam);
				
			} catch (DBFWException e) {
				// TODO Auto-generated catch block
				throw new PetStoreDAOException(e);
			}
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
		return data;
	}
	
	public List<Item> getItemList(final int categId) throws PetStoreDAOException
	{
		List<Item> data= new ArrayList();
		Connection con =null;
		try {
			con=establishConnection();
			ParamMapper mapParam= new ParamMapper()
			{
				@Override
				public void mapParams(PreparedStatement psmt)
						throws SQLException {
					psmt.setInt(1, categId);
					
					
				}
				
			};
			try {
				data=DBHelper.executeSelect(con, SqlMapper.PROJECT_ITEM_LIST, SqlMapper.MAP_ITEMS, mapParam);
				
			} catch (DBFWException e) {
				throw new PetStoreDAOException(e);
			}
		} catch (ClassNotFoundException e) {
			throw new PetStoreDAOException(e);
		} catch (SQLException e) {
			throw new PetStoreDAOException(e);
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
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
		return data;
	}

	public List<Item> getItem(final int categId, final int productId) throws PetStoreDAOException
	{
		List<Item> data= new ArrayList();
		Connection con =null;
		try {
			try {
				con=establishConnection();
			} catch (DBFWException e1) {
				// TODO Auto-generated catch block
			throw new PetStoreDAOException(e1);
			}
			ParamMapper mapParam= new ParamMapper()
			{
				@Override
				public void mapParams(PreparedStatement psmt)
						throws SQLException {
					psmt.setInt(1, categId);
					psmt.setInt(2, productId);
					
				}
				
			};
			try {
				data=DBHelper.executeSelect(con, SqlMapper.PROJECT_SINGLE_ITEM, SqlMapper.MAP_ITEMS, mapParam);
				
			} catch (DBFWException e) {
				throw new PetStoreDAOException(e);
			}
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
		return data;
	}
	
	public List getItem(final int categId, final int productId,final  int itemId) throws PetStoreDAOException
	{
		List data= new ArrayList();
		Connection con =null;
		try {
			con=establishConnection();
			ParamMapper mapParam= new ParamMapper()
			{
				@Override
				public void mapParams(PreparedStatement psmt)
						throws SQLException {
					psmt.setInt(1, categId);
					psmt.setInt(2, productId);
					psmt.setInt(3, itemId);
					
				}
				
			};
			try {
				data=DBHelper.executeSelect(con, SqlMapper.PROJECT_ITEM_THREE_ID, SqlMapper.MAP_ITEMS, mapParam);
				
			} catch (DBFWException e) {
				throw new PetStoreDAOException();
			}
		} catch (ClassNotFoundException e) {
			throw new PetStoreDAOException(e);
		} catch (SQLException e) {
			throw new PetStoreDAOException(e);
		} catch (DBFWException e) {
			throw new PetStoreDAOException();
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
		return data;
	}
}
