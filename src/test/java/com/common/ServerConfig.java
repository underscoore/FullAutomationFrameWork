package com.common;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ServerConfig extends MainLogger {

	static DesiredCapabilities capabilites = new DesiredCapabilities();
	protected static WebDriver remoteDriver = null;

	static void runTestCasesUsingStandaloneServer(String browser) {
		try {

			if (browser.equals("chrome")) {
				capabilites.setBrowserName("chrome");
				remoteDriver = new RemoteWebDriver(new URL(CommonUtil.getProperyData("serverURL")), capabilites);
				logger.info(String.format("Server URL %s is launched on %s", CommonUtil.getProperyData("serverURL"),
						browser));
				remoteDriver.manage().window().maximize();
				logger.info(String.format("Maximized %s window", browser));
				remoteDriver.get(CommonUtil.getProperyData("baseURL"));
				logger.info(String.format("Launched application on %s URL", CommonUtil.getProperyData("baseURL")));
			} else if (browser.equals("firefox")) {
				capabilites.setBrowserName("firefox");
				remoteDriver = new RemoteWebDriver(new URL(CommonUtil.getProperyData("serverURL")), capabilites);
				logger.info(String.format("Server URL %s is launched on %s", CommonUtil.getProperyData("serverURL"),
						browser));
				remoteDriver.manage().window().maximize();
				logger.info(String.format("Maximized %s window", browser));
				remoteDriver.get(CommonUtil.getProperyData("baseURL"));
				logger.info(String.format("Launched application on %s URL", CommonUtil.getProperyData("baseURL")));
			} else if (browser.equals("edge")) {
				capabilites.setBrowserName("MicrosoftEdge");
				remoteDriver = new RemoteWebDriver(new URL(CommonUtil.getProperyData("serverURL")), capabilites);
				logger.info(String.format("Server URL %s is launched on %s", CommonUtil.getProperyData("serverURL"),
						browser));
				remoteDriver.manage().window().maximize();
				logger.info(String.format("Maximized %s window", browser));
				remoteDriver.get(CommonUtil.getProperyData("baseURL"));
				logger.info(String.format("Launched application on %s URL", CommonUtil.getProperyData("baseURL")));
			} else {

				// Handling if browser does not support or browser not found
				try {
					logger.error(String.format("Browser [%s] does not support", browser));
				} catch (NullPointerException e) {
					e.printStackTrace();
					remoteDriver.close();
				}

			}

			// Handling main exception
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static void runTestCasesUsingWebDriver() {

		System.out.println("TT");
	};
}
