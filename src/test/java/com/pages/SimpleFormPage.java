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

	public void clickInputFormLink() {

		CommonLib.clickElement(inputFormLink);

	}

	// Click Simple Form Demo
	public void clickSimpleFormDemoLink() {
		CommonLib.clickElement(simpleFormDemoLink);
	}

	// submit
	public void enterMessage(String message) {

		CommonLib.sendKeys(inputMessage, message);
	}

	public void clickMessageButton() {
		CommonLib.clickElement(showMessageButton);
	}
}
