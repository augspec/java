package com.bkav.bkavcoreca.database;

import java.util.List;

public interface IConfigurationDAO {
	public void insert(Configuration config);
	public void update(Configuration config);
	public List<Configuration> getAllConfig();
	public void remove(String propertyKey);
	public void createDefaultConfig();
}
