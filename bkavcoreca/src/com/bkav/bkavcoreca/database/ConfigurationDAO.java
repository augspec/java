package com.bkav.bkavcoreca.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;

import com.bkav.bkavcoreca.utils.GlobalConfig;

public class ConfigurationDAO implements IConfigurationDAO {
	private static final Logger LOG = Logger.getLogger(Configuration.class);
	private static final String STM_INSERT_CONFIG = "INSERT INTO globalconfig(name, propertykey, propertyvalue) values(?, ?, ?)";
	private static final String STM_UPDATE_CONFIG = "UPDATE globalconfig SET propertyvalue=? WHERE propertykey=?";
	private static final String STM_GET_ALL_CONFIG = "SELECT name, propertykey, propertyvalue FROM globalconfig";
	private static final String STM_REMOVE_CONFIG = "DELETE FROM globalconfig WHERE propertykey=?";

	@Override
	public void insert(Configuration config) {
		Connection connection = MySQLConnector.popConnection();
		if (connection != null) {
			PreparedStatement statement = null;
			try {
				statement = connection.prepareStatement(STM_INSERT_CONFIG);
				statement.setString(1, config.getName());
				statement.setString(2, config.getConfigKey());
				statement.setString(3, config.getConfigValue());

				int result = statement.executeUpdate();
				LOG.info("Insert globalconfig result: " + (result != 0));
			} catch (SQLException e) {
				LOG.error("SQLException", e);
			} finally {
				MySQLConnector.closeStatement(statement);
				MySQLConnector.putConnection(connection);
			}
		}
	}

	@Override
	public void update(Configuration config) {
		Connection connection = MySQLConnector.popConnection();
		if (connection != null) {
			PreparedStatement statement = null;
			try {
				statement = connection.prepareStatement(STM_UPDATE_CONFIG);
				statement.setString(1, config.getConfigValue());
				statement.setString(2, config.getConfigKey());

				int result = statement.executeUpdate();
				LOG.info("Update globalconfig result: " + (result != 0));
			} catch (SQLException e) {
				LOG.error("SQLException", e);
			} finally {
				MySQLConnector.closeStatement(statement);
				MySQLConnector.putConnection(connection);
			}
		}
	}

	@Override
	public List<Configuration> getAllConfig() {
		List<Configuration> result = new ArrayList<Configuration>();
		Connection connection = MySQLConnector.popConnection();
		if (connection != null) {
			PreparedStatement statement = null;
			try {
				statement = connection.prepareStatement(STM_GET_ALL_CONFIG);
				ResultSet rs = statement.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						String name = rs.getString("name");
						String key = rs.getString("propertykey");
						String value = rs.getString("propertyvalue");
						result.add(new Configuration(name, key, value));
					}
				}
			} catch (SQLException e) {
				LOG.error("SQLException", e);
			} finally {
				MySQLConnector.closeStatement(statement);
				MySQLConnector.putConnection(connection);
			}
		}
		return result;
	}

	@Override
	public void remove(String propertyKey) {
		Connection connection = MySQLConnector.popConnection();
		if (connection != null) {
			PreparedStatement statement = null;
			try {
				statement = connection.prepareStatement(STM_REMOVE_CONFIG);
				statement.setString(1, propertyKey);

				int result = statement.executeUpdate();
				LOG.info("Delete globalconfig result: " + (result == 0));
			} catch (SQLException e) {
				LOG.error("SQLException", e);
			} finally {
				MySQLConnector.closeStatement(statement);
				MySQLConnector.putConnection(connection);
			}
		}
	}

	@Override
	public void createDefaultConfig() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Signer Type", GlobalConfig.SIGNER_CLASSPATH);
		map.put("Pkcs#12 keystore path", GlobalConfig.PKCS12_PATH);
		map.put("Pkcs#12 keystore password", GlobalConfig.PKCS12_PASS);
		map.put("Keystore Password", GlobalConfig.KEYSTORE_PASS);
		map.put("Keystore Type", GlobalConfig.KEYSTORE_TYPE);
		map.put("Keystore Path", GlobalConfig.KEYSTORE_PATH);
		map.put("Truststore Password", GlobalConfig.TRUSTSTORE_PASS);
		map.put("Truststore Type", GlobalConfig.TRUSTSTORE_TYPE);
		map.put("Truststore Path", GlobalConfig.TRUSTSTORE_PATH);
		map.put("SignServer IP Address", GlobalConfig.SIGNSERVER_ENPOINT);
		map.put("Jar Signer Name", GlobalConfig.JAR_SIGNER);
		map.put("Authenticode Signer Name", GlobalConfig.EXE_SIGNER);
		Set<Entry<String,String>> entrySet = map.entrySet();
		Iterator<Entry<String, String>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Entry<String, String> next = iterator.next();
			Configuration config = new Configuration(next.getKey(), next.getValue(), "");
			insert(config);
		}
	}

}
