package com.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.common.CommonBase;
import com.common.CommonLib;

public class BasicPage extends CommonBase {

	// Page title BASIC EXAMPLES TO START WITH SELENIUM
//Basic Icon : 
	@FindBy(xpath = "//a[@id='basic_example']/span")
	WebElement basicIcon;

	@FindBy(linkText = "Simple Form Demo")
	WebElement linkSimpleFormDemo;

//	@FindBy(xpath = "//div[@id='basic']/h3[@class = 'head text-center'][1]")
	WebElement basicHead = remoteDriver
			.findElement(By.partialLinkText("//div[@id='basic']/p[@class='narrow text-center'][1]"));
	// Assuming you have a basic understanding of HTML and CSS.

	public void clickBasic() {
		System.out.println(basicIcon.isDisplayed());
		assertTrue(CommonLib.clickElement(basicIcon));

	}

	public void validatePageTitle() {
		System.out.println("____________________________");
		System.out.println(linkSimpleFormDemo.getText());
		CommonLib.checkTwoTextStrings(basicHead, "AJAYk");
		Actions action = new Actions(remoteDriver);
		action.dragAndDropBy(basicIcon, 300, 1).build().perform();
		Assert.assertTrue(basicIcon.isDisplayed());

	}
}
