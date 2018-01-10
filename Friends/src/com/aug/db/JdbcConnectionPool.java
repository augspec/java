package com.aug.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class JdbcConnectionPool {

	List<Connection> availableConnections = new ArrayList<Connection>();

	public JdbcConnectionPool() {
		initializeConnectionPool();
	}

	private void initializeConnectionPool() {
		while (!checkIfConnectionPoolIsFull()) {
			availableConnections.add(createNewConnectionForPool());
		}
	}

	private synchronized boolean checkIfConnectionPoolIsFull() {
		final int MAX_POOL_SIZE = Configuration.getInstance().maxConnections;

		if (availableConnections.size() < MAX_POOL_SIZE) {
			return false;
		}

		return true;
	}

	// Creating a connection
	private Connection createNewConnectionForPool() {
		Configuration config = Configuration.getInstance();
		try {
			Class.forName(config.dbDriver);
			Connection connection = DriverManager.getConnection(config.dbUrl);
			
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public synchronized Connection getConnectionFromPool() {
		Connection connection = null;
		if (availableConnections.size() > 0) {
			connection = (Connection) availableConnections.get(0);
			availableConnections.remove(0);
		}
		
		return connection;
	}

	public synchronized void returnConnectionToPool(Connection connection) {
		availableConnections.add(connection);
	}
}
