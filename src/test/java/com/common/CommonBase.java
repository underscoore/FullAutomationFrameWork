package com.common;

import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonBase extends MainLogger {
	protected WebDriver driver = null;
	static DesiredCapabilities capabilites = new DesiredCapabilities();

	@BeforeMethod
	@Parameters("browser")
	public void tearUp(@Optional("firefox") String browser) {

		// Check if Selenium Standalone Server is running
		boolean isStandaloneServerUp = isServerRunning("localhost", 4444);

		if (isStandaloneServerUp) {
			// Run tests using the Selenium Standalone Server
			try {
				if (browser.equals("chrome")) {
					capabilites.setBrowserName("chrome");
					driver = new RemoteWebDriver(new URL(CommonUtil.getProperyData("serverURL")), capabilites);
					logger.info(String.format("Server URL %s is launched on %s", CommonUtil.getProperyData("serverURL"),
							browser));
					driver.manage().window().maximize();
					logger.info(String.format("Maximized %s window", browser));
					driver.get(CommonUtil.getProperyData("baseURL"));
					logger.info(String.format("Launched application on %s URL", CommonUtil.getProperyData("baseURL")));
				} else if (browser.equals("firefox")) {
					capabilites.setBrowserName("firefox");
					driver = new RemoteWebDriver(new URL(CommonUtil.getProperyData("serverURL")), capabilites);
					logger.info(String.format("Server URL %s is launched on %s", CommonUtil.getProperyData("serverURL"),
							browser));
					driver.manage().window().maximize();
					logger.info(String.format("Maximized %s window", browser));
					driver.get(CommonUtil.getProperyData("baseURL"));
					logger.info(String.format("Launched application on %s URL", CommonUtil.getProperyData("baseURL")));
				} else if (browser.equals("edge")) {
					capabilites.setBrowserName("MicrosoftEdge");
					driver = new RemoteWebDriver(new URL(CommonUtil.getProperyData("serverURL")), capabilites);
					logger.info(String.format("Server URL %s is launched on %s", CommonUtil.getProperyData("serverURL"),
							browser));
					driver.manage().window().maximize();
					logger.info(String.format("Maximized %s window", browser));
					driver.get(CommonUtil.getProperyData("baseURL"));
					logger.info(String.format("Launched application on %s URL", CommonUtil.getProperyData("baseURL")));
				} else {

					// Handling if browser does not support or browser not found
					try {
						logger.error(String.format("Browser [%s] does not support", browser));
					} catch (NullPointerException e) {
						e.printStackTrace();
						driver.close();
					}

				}

				// Handling main exception
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// Run tests using WebDriver directly

			try {
				if (browser.equals("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					driver.manage().window().maximize();
					logger.info(String.format("Maximized %s window", browser));
					driver.get(CommonUtil.getProperyData("baseURL"));
					logger.info(String.format("Launched application on %s URL", CommonUtil.getProperyData("baseURL")));
				} else if (browser.equals("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
					logger.info(String.format("Maximized %s window", browser));
					driver.get(CommonUtil.getProperyData("baseURL"));
					logger.info(String.format("Launched application on %s URL", CommonUtil.getProperyData("baseURL")));
				} else if (browser.equals("edge")) {
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					driver.manage().window().maximize();
					logger.info(String.format("Maximized %s window", browser));
					driver.get(CommonUtil.getProperyData("baseURL"));
					logger.info(String.format("Launched application on %s URL", CommonUtil.getProperyData("baseURL")));
				} else {

					// Handling if browser does not support or browser not found
					try {
						logger.error(String.format("Browser [%s] does not support", browser));
					} catch (NullPointerException e) {
						e.printStackTrace();
						driver.close();
					}

				}

				// Handling main exception
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				driver.get(CommonUtil.getProperyData("baseURL"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

	static boolean isServerRunning(String host, int port) {
		try (Socket socket = new Socket(host, port)) {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
