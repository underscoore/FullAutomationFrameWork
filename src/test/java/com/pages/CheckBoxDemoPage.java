package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.common.CommonBase;
import com.common.CommonLib;

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
		CommonLib.clickElement(inputFormLink);
	}

	public void clickCheckBoxDemoLink() {
		CommonLib.clickElement(checkBoxDemoLink);
	}

	public void selectCheckBox() {
		CommonLib.selectCheckBox(checkBox);
	}

	public void deselectCheckBox() {
		CommonLib.deselectCheckBox(checkBox);
	}
}
