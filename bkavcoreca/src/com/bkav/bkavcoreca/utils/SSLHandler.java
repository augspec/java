package com.bkav.bkavcoreca.utils;

import java.io.IOException;
import java.util.Properties;

import com.bkav.bkavcoreca.filter.AuthenticationFilter;

public class SSLHandler {
	static final String KEYSTORE_TYPE = "KEYSTORE_TYPE";
	static final String KEYSTORE_PATH_WIN = "KEYSTORE_PATH_WIN";
	static final String KEYSTORE_PATH_LINUX = "KEYSTORE_PATH_LINUX";
	static final String KEYSTORE_PASSWORD = "KEYSTORE_PASSWORD";
	static final String TRUSTSTORE_TYPE = "TRUSTSTORE_TYPE";
	static final String TRUSTSTORE_PATH_WIN = "TRUSTSTORE_PATH_WIN";
	static final String TRUSTSTORE_PATH_LINUX = "TRUSTSTORE_PATH_LINUX";
	static final String TRUSTSTORE_PASSWORD = "TRUSTSTORE_PASSWORD";

	private static final String PROP_TRUSTSTORE_TYPE = "javax.net.ssl.trustStoreType";
	private static final String PROP_TRUSTSTORE = "javax.net.ssl.trustStore";
	private static final String PROP_TRUSTSTORE_PASS = "javax.net.ssl.trustStorePassword";
	private static final String PROP_KEYSTORE_TYPE = "javax.net.ssl.keyStoreType";
	private static final String PROP_KEYSTORE = "javax.net.ssl.keyStore";
	private static final String PROP_KEYSTORE_PASS = "javax.net.ssl.keyStorePassword";
	private static final String PROP_SSL_PACKAGE = "java.protocol.handler.pkgs";

	private Properties props;

	public SSLHandler() throws IOException {
		this.props = GlobalConfig.getConfig();
	}

	/**
	 * Set client ssl with keystore and truststore
	 */
	public void setSSL() {
//		System.setProperty(PROP_TRUSTSTORE_TYPE,
//				props.getProperty(GlobalConfig.TRUSTSTORE_TYPE));
//		System.setProperty(PROP_TRUSTSTORE,
//				props.getProperty(GlobalConfig.TRUSTSTORE_PATH));
//		System.setProperty(PROP_TRUSTSTORE_PASS,
//				props.getProperty(GlobalConfig.TRUSTSTORE_PASS));

		System.setProperty(PROP_TRUSTSTORE_TYPE, "JKS");
		System.setProperty(PROP_TRUSTSTORE, AuthenticationFilter.pathProject +
				"WEB-INF/classes/myTrustStore.jks");
		System.setProperty(PROP_TRUSTSTORE_PASS, "123456a@A"); //12345678
		
		System.setProperty(PROP_KEYSTORE_TYPE,
				"JKS");
		System.setProperty(PROP_KEYSTORE, AuthenticationFilter.pathProject +
				"WEB-INF/classes/SSL_eHoadon.jks");
		System.setProperty(PROP_KEYSTORE_PASS,
				 "123456"); ///12345678

		System.setProperty(PROP_SSL_PACKAGE,
				"com.sun.net.ssl.internal.www.protocol");
	}

	public void resetSSL() {
		// System.setProperty(PROP_TRUSTSTORE_TYPE, null);
		// System.setProperty(PROP_TRUSTSTORE, null);
		// System.setProperty(PROP_TRUSTSTORE_PASS, null);
		// System.setProperty(PROP_KEYSTORE_TYPE, null);
		// System.setProperty(PROP_KEYSTORE, null);
		// System.setProperty(PROP_KEYSTORE_PASS, null);
		System.clearProperty(PROP_TRUSTSTORE_TYPE);
		System.clearProperty(PROP_TRUSTSTORE);
		System.clearProperty(PROP_TRUSTSTORE_PASS);
		System.clearProperty(PROP_KEYSTORE_TYPE);
		System.clearProperty(PROP_KEYSTORE);
		System.clearProperty(PROP_KEYSTORE_PASS);
		System.clearProperty(PROP_SSL_PACKAGE);
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}
}
