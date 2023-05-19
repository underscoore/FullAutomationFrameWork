package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.common.CommonBase;

public class CheckBoxDemoPage extends CommonBase {
	// Link Input Form
	@FindBy(partialLinkText = "Input Forms")
	WebElement inputFormLink;

	// Link Check-box Demo
	@FindBy(partialLinkText = "Checkbox Demo")
	WebElement checkBoxDemoLink;

	@FindBy(id = "isAgeSelected")
	WebElement checkBox;

	public void clickInputFormLink() {
		inputFormLink.click();
	}

	// enterPassword
	public void clickCheckBoxDemoLink() {
		checkBoxDemoLink.click();
	}

	// submit
	public void selectCheckBox() {
		checkBox.click();
	}
}
