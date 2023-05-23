package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.common.CommonBase;
import com.common.CommonLib;

public class SimpleFormPage extends CommonBase {

	// Link Input Form
	@FindBy(partialLinkText = "Input Forms") // Simple Form Demo
	WebElement inputFormLink;

	// Link Simple From Demo
	@FindBy(partialLinkText = "Simple Form Demo")
	WebElement simpleFormDemoLink;

	// Input Message
	@FindBy(id = "user-message")
	WebElement inputMessage;

	@FindBy(xpath = "//button[@onclick='showInput();']")
	WebElement showMessageButton;

	@FindBy(id = "value1")
	WebElement value1;

	@FindBy(id = "value2")
	WebElement value2;

	@FindBy(xpath = "//button[@onclick='return total()']")
	WebElement getTotal;

	public void clickInputFormLink() {
		CommonLib.clickElement(driver, inputFormLink);

	}

	// Click Simple Form Demo
	public void clickSimpleFormDemoLink() {
		CommonLib.clickElement(driver, simpleFormDemoLink);
	}

	// submit
	public void enterMessage(String message) {

		CommonLib.sendKeys(driver, inputMessage, message);
	}

	public void clickMessageButton() {
		CommonLib.clickElement(driver, showMessageButton);
	}

	public void enterValue1(String value) {
		CommonLib.sendKeys(driver, value1, value);
	}

	public void enterValue2(String value) {
		CommonLib.sendKeys(driver, value2, value);
	}

	public void getTotal() {
		CommonLib.clickElement(driver, getTotal);
	}
}
