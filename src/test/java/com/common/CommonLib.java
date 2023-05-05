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
}
