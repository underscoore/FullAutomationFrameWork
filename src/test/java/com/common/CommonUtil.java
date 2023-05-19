package com.common;

import java.io.FileReader;
import java.net.Socket;
import java.util.Properties;

public class CommonUtil extends MainLogger {

	// Reading Property File and Getting theProp value
	// Property file is located at: /FullFrameWork/src/test/resources
	public static String getProperyData(String propValue) throws Exception {
		FileReader reader = new FileReader("./src/test/resources/initial.properties");
		logger.info(String.format("Reading Data from property file for [KEY] -  %s", propValue));
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

	// Checking the Selenium stand-alone server is up or !up
	// Logging in both the cases if server or !server
	public static boolean isServerRunning(String host, int port) {
		try (Socket socket = new Socket(host, port)) {
			logger.info("Selenium Stand Alone server is UP and Running");
			return true;
		} catch (Exception e) {
			logger.info("Does not found Selenium stand-alone server");
			return false;
		}
	}
}
