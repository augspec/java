/**
 * 
 */
package com.aug.jdbc.util;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author AUG
 *
 */
public class ConnectionPool {

	public static String jdbcDriver = "";
	public static String jdbcDbUrl = "";
	public static String jdbcUser = "";
	public static String jdbcPassword = "";
	
	private static GenericObjectPool gPool = null;
	private static DataSource dataSource = null;
			
	public ConnectionPool() throws Exception {
		super();
		dataSource = setUpPool();
	}

	public DataSource setUpPool() throws Exception {
		Class.forName(jdbcDriver);
		
		gPool = new GenericObjectPool();
		gPool.setMaxActive(5);
		
		ConnectionFactory cf = new DriverManagerConnectionFactory(jdbcDbUrl, jdbcUser, jdbcPassword);
		
		new PoolableConnectionFactory(cf, gPool, null, null, false, true);
		
		return new PoolingDataSource(gPool);
	}
	
	public GenericObjectPool getConnectionPool() {
		return gPool;
	}
	
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	private void printDbStatus() {
		System.out.println("Max.: " + getConnectionPool().getMaxActive() + "; Active: " + getConnectionPool().getNumActive() + "; Idle: " + getConnectionPool().getNumIdle());
	}
}
