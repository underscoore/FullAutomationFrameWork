package com.common;

import org.openqa.selenium.WebElement;

public class CommonLib extends MainLogger {

	// Click Element
	public static Boolean clickElement(WebElement locator) {

		try {
			locator.click();
			logger.info(String.format("Element Clicked: %s", locator));
			return true;
		} catch (Exception e) {
			logger.error(String.format("Element not FOUND : %s ", locator));
			return false;
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