package com.aug.db;

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
		dbUrl = "jdbc:sqlite:friends.sqlite";
		dbDriver = "org.sqlite.JDBC";
		maxConnections = 5;
	}
}
