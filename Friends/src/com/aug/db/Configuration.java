package com.aug.db;

import java.io.File;

public class Configuration {

	public String dbUrl;
	public String dbDriver;
	public int maxConnections;
	
	private Configuration() {
		init();
	}
	
	private static Configuration configuration = new Configuration();
	
	public static Configuration getInstance() {
		return configuration;
	}
	
	private void init() {
		File f = new File(getClass().getClassLoader().getResource("friends.sqlite").getFile());
		String path = f.getAbsolutePath().replaceAll("%20", " ");
		dbUrl = "jdbc:sqlite:" + path;
		dbDriver = "org.sqlite.JDBC";
		maxConnections = 5;
	}
}
