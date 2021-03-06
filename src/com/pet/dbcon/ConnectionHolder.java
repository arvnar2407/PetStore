package com.pet.dbcon;


import java.sql.Connection;	
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class ConnectionHolder {

	public static ConnectionHolder instance = null;
	private DataSource ds = null;

	private ConnectionHolder() {

	}

	public static ConnectionHolder getInstance() throws DBConnectionException {
		synchronized (ConnectionHolder.class) {
			if (instance == null) {
				instance = new ConnectionHolder();
				instance.initAppDataSource();
			}
		}
		return instance;
	}

	public Connection getConnection() throws DBConnectionException {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new DBConnectionException("Unable to obtain connection", e);
		}
	}

	public void dispose() throws DBConnectionException {
		BasicDataSource bds = (BasicDataSource) ds;
		try {
			bds.close();
		} catch (SQLException e) {
			throw new DBConnectionException("Unable to close the connection", e);
		}
	}

	private void initAppDataSource() throws DBConnectionException {
		Context initContext;

		try {
			initContext = new InitialContext();
			Context envContext = (Context) 
					initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/MyDB");

		} catch (NamingException e) {
			throw new DBConnectionException
			("Unable to get datasource", e);
		}
	}

	// private void initAppDataSource() throws DBConnectionException {
	//
	// BasicDataSource dataSource = new BasicDataSource();
	// Properties props = new Properties();
	// String uid;
	// String password;
	// String url;
	// String driver;
	// try {
	// props.load(new FileInputStream("jdbcds.properties"));
	// uid = props.getProperty("uid");
	// password = props.getProperty("pwd");
	// url = props.getProperty("url");
	// driver = props.getProperty("driver");
	// dataSource.setDriverClassName(driver);
	// dataSource.setUrl(url);
	// dataSource.setUsername(uid);
	// dataSource.setPassword(password);
	// this.ds = dataSource;
	// } catch (FileNotFoundException e) {
	// throw new DBConnectionException(
	// "Unable to get connection Data to the database", e);
	//
	// } catch (IOException e) {
	// throw new DBConnectionException(
	// "Unable to get connection Data to the database", e);
	//
	// }
	// }
}
