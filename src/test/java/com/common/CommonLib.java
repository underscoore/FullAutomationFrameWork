package com.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonLib extends MainLogger {

	// Actions
	// Click Element
	public static void clickElement(WebDriver driver, WebElement locator) {

		if (locator.isDisplayed() && locator.isEnabled()) {
			try {
				locator.click();
				CommonUtil.captureScreenShot(driver);
				logger.info(String.format("Element Clicked: %s", locator));
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			logger.error(String.format("Element not FOUND : %s ", locator));
		}

	}

	// Send Keys
	public static void sendKeys(WebDriver driver, WebElement locator, String value) {

		if (locator.isDisplayed() && locator.isEnabled()) {
			try {
				locator.sendKeys(value);
				CommonUtil.captureScreenShot(driver);
				logger.info(String.format("Value Entered: %s", value));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			logger.error(String.format("Element not FOUND : %s ", locator));
		}

	}

	// Check-Box
	// Check the Check-box
	public static void selectCheckBox(WebDriver driver, WebElement locator) {

		if (locator.isDisplayed() && locator.isEnabled() && !locator.isSelected()) {
			logger.info(String.format("Checkbox is not checked"));
			try {

				locator.click();
				CommonUtil.captureScreenShot(driver);
				logger.info(String.format("Element Checked: %s", locator));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			logger.error(String.format("Element not FOUND : %s ", locator));
		}

	}

	// Un-check the check-box
	public static void deselectCheckBox(WebDriver driver, WebElement locator) {

		if (locator.isDisplayed() && locator.isEnabled() && locator.isSelected()) {
			logger.info(String.format("Checkbox is checked"));
			try {
				locator.click();
				CommonUtil.captureScreenShot(driver);
				logger.info(String.format("Element Unchecked: %s", locator));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			logger.error(String.format("Element not FOUND : %s ", locator));
		}

	}

	// Actual and Expected Text
	public static Boolean checkTwoTextStrings(WebDriver driver, WebElement locator, String expectedText) {
		try {
			String actualText = locator.getText();
			if (actualText.equals(expectedText)) {
				logger.info(String.format("Text [%s] matched with [%s]", actualText, expectedText));
				return true;
			} else {
				logger.error(String.format("Text [%s] does not matched with [%s]", actualText, expectedText));
				return false;
			}

		} catch (

		Exception e) {
			logger.error(String.format("There is some exception"));
			return false;
		}
	}

	// Page title
	// Get the active page title
	public static Boolean getPageTitle(WebDriver driver) {
		try {
			String pageTitle = driver.getTitle();
			CommonUtil.captureScreenShot(driver);
			logger.info(String.format("Page Title - [%s]", pageTitle));
			return true;
		} catch (Exception e) {
			logger.error(String.format("Page title could not be fetched"));
			return false;
		}
	}

	// comparing the actual page title with expected page title
	public static Boolean comparePageTitle(WebDriver driver, String expectedTitle) {
		try {
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedTitle)) {
				logger.info(String.format("Actual page Title [%s] matched with expected page title [%s]", actualTitle,
						expectedTitle));
				return true;
			} else {
				logger.error(String.format("Actual Page Title [%s] does not matched with Expected page title [%s]",
						actualTitle, expectedTitle));
				return false;
			}

		} catch (

		Exception e) {
			logger.error(String.format("There is some exception"));
			return false;
		}
	}

	// Navigation
	// Navigation Back
	public static Boolean navigateBack(WebDriver driver) {

		try {
			String pageTitle = driver.getTitle();
			driver.navigate().back();
			CommonUtil.captureScreenShot(driver);
			logger.error(String.format("Page is navigate back to [%s]", pageTitle));
			return true;
		} catch (Exception e) {
			logger.error(String.format("Page did not navigate back"));
			return false;
		}
	}

	// Navigation Forward
	public static Boolean navigateForward(WebDriver driver) {

		try {
			String pageTitle = driver.getTitle();
			driver.navigate().forward();
			CommonUtil.captureScreenShot(driver);
			logger.error(String.format("Page is navigate forward to [%s]", pageTitle));
			return true;
		} catch (Exception e) {
			logger.error(String.format("Page did not navigate forward"));
			return false;
		}
	}

}