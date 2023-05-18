package com.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class CommonBase extends MainLogger {
	protected static WebDriver remoteDriver = null;

	@BeforeTest
	@Parameters("browser")
	public void tearUp(@Optional("firefox") String browser) {
		boolean isStandaloneServerUp = CommonUtil.isServerRunning("localhost", 4444);

		if (isStandaloneServerUp) {

			if (isStandaloneServerUp) {
				// Run tests using the Selenium Standalone Server
				ServerConfig.runTestCasesUsingStandaloneServer(browser);
			} else {
				// Run tests using WebDriver directly
				ServerConfig.runTestCasesUsingWebDriver();
			}
		}

	}

	@AfterTest
	public void tearDown() {
		remoteDriver.close();

	}

}
