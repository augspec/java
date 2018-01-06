package com.aug.axiom;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utilities function
 * 
 * @author AUG
 *
 */
public class Utils {

	private static Properties prop;
	
	private static InputStream inputStream;
	
	static {
		try {
			inputStream = Utils.class.getClassLoader().getResourceAsStream("axiom-config.properties");
			if (inputStream == null) {
				System.out.println("Cannot load axiom-config.properties file!");
			} else {
				prop = new Properties();
				prop.load(inputStream);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static Properties getProp() {
		return prop;
	}

	public static void setProp(Properties prop) {
		Utils.prop = prop;
	}
}
