package com.common;

import org.openqa.selenium.WebElement;

public class CommonLib extends MainLogger {

	// Click Element
	public static void clickElement(WebElement locator) {

		if (locator.isDisplayed() && locator.isEnabled()) {
			try {
				locator.click();
				logger.info(String.format("Element Clicked: %s", locator));
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			logger.error(String.format("Element not FOUND : %s ", locator));
		}

	}

	// Send Keys
	public static void sendKeys(WebElement locator, String value) {

		if (locator.isDisplayed() && locator.isEnabled()) {
			try {
				locator.sendKeys(value);
				logger.info(String.format("Value Entered: %s", value));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			logger.error(String.format("Element not FOUND : %s ", locator));
		}

	}

	// Check the checkbox
	public static void selectCheckBox(WebElement locator) {

		if (locator.isDisplayed() && locator.isEnabled() && !locator.isSelected()) {
			logger.info(String.format("Checkbox is not checked"));
			try {
				locator.click();
				logger.info(String.format("Element Checked: %s", locator));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			logger.error(String.format("Element not FOUND : %s ", locator));
		}

	}

	// Uncheck the checkbox
	public static void deselectCheckBox(WebElement locator) {

		if (locator.isDisplayed() && locator.isEnabled() && locator.isSelected()) {
			logger.info(String.format("Checkbox is checked"));
			try {
				locator.click();
				logger.info(String.format("Element Unchecked: %s", locator));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			logger.error(String.format("Element not FOUND : %s ", locator));
		}

	}

	// This function is used to compare the Actual and Expected Text
	public static Boolean checkTwoTextStrings(WebElement locator, String expectedText) {
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
}