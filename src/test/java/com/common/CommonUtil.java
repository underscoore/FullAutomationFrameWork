package com.common;

import java.io.FileReader;
import java.util.Properties;

public class CommonUtil {

	// Reading Property File and Getting theProp value
	// Property file is located at: /FullFrameWork/src/test/resources
	public static String getProperyData(String propValue) throws Exception {
		FileReader reader = new FileReader("./src/test/resources/initial.properties");
		Properties props = new Properties();
		props.load(reader);
		return props.getProperty(propValue);
	}

	public static void threadSleep(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
