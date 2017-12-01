package com.aug.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class SSLOneWayHandler {
	static final String TRUSTSTORE_TYPE = "truststore.type";
	static final String TRUSTSTORE_FILE = "truststore.file";
	static final String TRUSTSTORE_PASSWORD = "truststore.passwd";

	private static final String PROP_TRUSTSTORE_TYPE = "javax.net.ssl.trustStoreType";
	private static final String PROP_TRUSTSTORE = "javax.net.ssl.trustStore";
	private static final String PROP_TRUSTSTORE_PASS = "javax.net.ssl.trustStorePassword";
	private static final String PROP_SSL_PACKAGE = "java.protocol.handler.pkgs";

	private Properties props;

	public SSLOneWayHandler() {
		this.props = new Properties();
		try {
			props.load(SSLOneWayHandler.class.getClassLoader().getResourceAsStream("admin.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Set client ssl with keystore and truststore
	 * @throws URISyntaxException 
	 */
	public void setSSL() throws URISyntaxException {
		URL url = this.getClass().getClassLoader().getResource(props.getProperty(TRUSTSTORE_FILE));
		String filePath = url.toURI().getPath();
		
		String osName = System.getProperty("os.name");
		if (osName.contains("Windows")) {
			filePath = filePath.replaceFirst("/", "");
		}
		
		System.setProperty(PROP_TRUSTSTORE_TYPE, props.getProperty(TRUSTSTORE_TYPE));
		System.setProperty(PROP_TRUSTSTORE, filePath);
		System.setProperty(PROP_TRUSTSTORE_PASS, props.getProperty(TRUSTSTORE_PASSWORD));
		System.setProperty(PROP_SSL_PACKAGE, "com.sun.net.ssl.internal.www.protocol");
	}

	public void resetSSL() {
		System.clearProperty(PROP_TRUSTSTORE_TYPE);
		System.clearProperty(PROP_TRUSTSTORE);
		System.clearProperty(PROP_TRUSTSTORE_PASS);
		System.clearProperty(PROP_SSL_PACKAGE);
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

}
