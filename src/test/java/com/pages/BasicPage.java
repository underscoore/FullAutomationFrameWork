package com.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.common.CommonBase;
import com.common.CommonLib;

public class BasicPage extends CommonBase {

	// Page title BASIC EXAMPLES TO START WITH SELENIUM
//Basic Icon : 
	@FindBy(xpath = "//a[@id='basic_example']/span")
	WebElement basicIcon;

	@FindBy(linkText = "Simple Form Demo")
	WebElement linkSimpleFormDemo;

	public void clickBasic() {
		assertTrue(CommonLib.clickElement(basicIcon));

	}

	// Simple Form Demo
//Check Box Demo
	// Radio Button Demo
	// Select Drop down List
//Java Script Alert
	// Windows Pop up modals
//Bootstrap alerts
//Bootstrap modals
}
