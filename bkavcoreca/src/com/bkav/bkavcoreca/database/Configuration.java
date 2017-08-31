package com.bkav.bkavcoreca.database;

public class Configuration {
	private String name;
	private String configKey;
	private String configValue;

	public Configuration() {
	}

	public Configuration(String name, String key, String value) {
		this.setName(name);
		this.setConfigKey(key);
		this.setConfigValue(value);
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
