package com.bkav.bkavcoreca.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.bkav.bkavcoreca.database.Configuration;
import com.bkav.bkavcoreca.database.ConfigurationDAO;
import com.bkav.bkavcoreca.filter.AuthenticationFilter;

public class GlobalConfig {
	private static final Logger LOG = Logger.getLogger(GlobalConfig.class);
	public static Properties config = null;

	public static final String SIGNER_CLASSPATH = "SIGNER_CLASSPATH";
	public static final String PKCS12_PATH = "PKCS12_PATH";
	public static final String PKCS12_PASS = "PKCS12_PASS";

	public static final String KEYSTORE_PATH = "KEYSTORE_PATH";
	public static final String KEYSTORE_TYPE = "KEYSTORE_TYPE";
	public static final String KEYSTORE_PASS = "KEYSTORE_PASS";

	public static final String TRUSTSTORE_PATH = "TRUSTSTORE_PATH";
	public static final String TRUSTSTORE_TYPE = "TRUSTSTORE_TYPE";
	public static final String TRUSTSTORE_PASS = "TRUSTSTORE_PASS";

	public static final String SIGNSERVER_ENPOINT = "SIGNSERVER_ENPOINT";
	public static final String EXE_SIGNER = "EXE_SIGNER";
	public static final String JAR_SIGNER = "JAR_SIGNER";

	public static void reloadConfig() throws IOException {
		config = new Properties();
		
		InputStream input = new FileInputStream(AuthenticationFilter.pathProject + 
				"WEB-INF/classes/config.properties");
		
		config.load(input);
	}

	public static boolean isLocalSignMethod() throws IOException {
		if (config == null) {
			reloadConfig();
		}
//		if (LocalCodeSigner.class.getName()
//				.equals(config.get(SIGNER_CLASSPATH))) {
//			return true;
//		}
		return false;
	}

	public static String getProperty(String key) throws IOException {
		if (config == null) {
			reloadConfig();
		}
		
		String value = config.getProperty(key);
		if (value == null || "".equals(value)) {
			LOG.error("Property " + key + " not set.");
		}
		return value;
	}

	public static void setProperty(String key, String value) {
		if (value.equals(config.getProperty(key))) {
			return;
		}
		config.setProperty(key, value);
		ConfigurationDAO dao = new ConfigurationDAO();
		Configuration config = new Configuration("", key, value);
		dao.update(config);
	}

	public static String getSignServerEnpoint() {
/*		return "https://" + getProperty(SIGNSERVER_ENPOINT)
				+ ":443/signserver/ClientWSService/ClientWS?wsdl";*/
		return "https://:83/signserver/ClientWSService/ClientWS?wsdl";
	}

	public static Properties getConfig() throws IOException {
		reloadConfig();
		return config;
	}

	public static List<Configuration> getSSLConfigs() throws IOException {
		List<Configuration> result = new ArrayList<>();
		if (config == null) {
			reloadConfig();
		}
		result.add(new Configuration("Truststore Type", TRUSTSTORE_TYPE,
				config.getProperty(TRUSTSTORE_TYPE)));
		result.add(new Configuration("Truststore Path", TRUSTSTORE_PATH,
				config.getProperty(TRUSTSTORE_PATH)));
		result.add(new Configuration("Truststore Password", TRUSTSTORE_PASS,
				config.getProperty(TRUSTSTORE_PASS)));

		result.add(new Configuration("Keystore Type", KEYSTORE_TYPE,
				config.getProperty(KEYSTORE_TYPE)));
		result.add(new Configuration("Keystore Path", KEYSTORE_PATH,
				config.getProperty(KEYSTORE_PATH)));
		result.add(new Configuration("Keystore Password", KEYSTORE_PASS,
				config.getProperty(KEYSTORE_PASS)));

		return result;
	}

	public static List<Configuration> getRemoteSigerConfigs() throws IOException {
		List<Configuration> result = new ArrayList<>();
		if (config == null) {
			reloadConfig();
		}
//		result.add(new Configuration("SignServer IP Address",
//				SIGNSERVER_ENPOINT, config.getProperty(SIGNSERVER_ENPOINT)));
		result.add(new Configuration("SignServer IP Address",
				SIGNSERVER_ENPOINT, "https://:83/signserver/ClientWSService/ClientWS?wsdl"));
		result.add(new Configuration("Authenticode Signer Name", EXE_SIGNER,
				config.getProperty(EXE_SIGNER)));
		result.add(new Configuration("Jar Signer Name", JAR_SIGNER,
				config.getProperty(JAR_SIGNER)));
		return result;
	}

	public static List<Configuration> getLocalSigerConfigs() throws IOException {
		List<Configuration> result = new ArrayList<>();
		if (config == null) {
			reloadConfig();
		}
		result.add(new Configuration("Pkcs#12 Keystore Path", PKCS12_PATH,
				config.getProperty(PKCS12_PATH)));
		result.add(new Configuration("Pkcs#12 Keystore Password", PKCS12_PASS,
				config.getProperty(PKCS12_PASS)));
		return result;
	}
}
