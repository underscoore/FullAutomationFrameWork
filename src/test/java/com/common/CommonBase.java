package com.common;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class CommonBase {
	protected WebDriver remoteDriver = null;

	@BeforeTest
	@Parameters("browser")
	public void tearUp(@Optional("firefox") String browser) {
		DesiredCapabilities capabilites = new DesiredCapabilities();

		try {
			if (browser.equals("chrome")) {
				capabilites.setBrowserName("chrome");
				remoteDriver = new RemoteWebDriver(new URL(CommonUtil.getProperyData("serverURL")), capabilites);
				remoteDriver.manage().window().maximize();
				remoteDriver.get(CommonUtil.getProperyData("baseURL"));
			} else if (browser.equals("firefox")) {
				capabilites.setBrowserName("firefox");
				remoteDriver = new RemoteWebDriver(new URL(CommonUtil.getProperyData("serverURL")), capabilites);
				remoteDriver.manage().window().maximize();
				remoteDriver.get(CommonUtil.getProperyData("baseURL"));
			} else if (browser.equals("edge")) {
				capabilites.setBrowserName("MicrosoftEdge");
				remoteDriver = new RemoteWebDriver(new URL(CommonUtil.getProperyData("serverURL")), capabilites);
				remoteDriver.manage().window().maximize();
				remoteDriver.get(CommonUtil.getProperyData("baseURL"));
			} else {

				// Handling if browser does not support or browser not found
				try {
					System.out.println(String.format("Browser [%s] does not support", browser));
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

	@AfterTest
	public void tearDown() {
		remoteDriver.close();

	}
}

//C:\Users\Nut Shell\.m2\repository\org\testng\testng\6.14.3\testng-6.14.3.jar