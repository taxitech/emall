package com.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	private static InputStream in;

	private static Properties properties;

	private static String propertyname = "config.properties";

	static {
		try {
			in = getFileInputStream();
			properties = new Properties();
			properties.load(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static InputStream getFileInputStream()
			throws FileNotFoundException {
		return Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(propertyname);
	}

	/**
	 * @Description: 获取属性值
	 * @param name
	 */
	public static String getProperty(String name) {
		return properties.getProperty(name);
	}

}