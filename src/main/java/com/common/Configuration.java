package com.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	
	public static final String CHROME_WEBDRIVER = getProp().getProperty("webdriver.chrome.driver");
	public static final BrowserTypes BROWSER = BrowserTypes.valueOf(getProp().getProperty("selenium.browser"));
	public static final String TESTER_TYPE = getProp().getProperty("tester.type");
	private static Properties prop;

	private static Properties getProp() {
		if (prop == null) {
			prop = new Properties();
			InputStream input = null;
			try {
				input = new FileInputStream(new File(System.getProperty("user.dir") +"//src//main//resources-filtered//" +"system.properties"));
				prop.load(input);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return prop;
	}
}
