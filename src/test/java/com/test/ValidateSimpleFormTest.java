package com.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.common.CommonBase;
import com.pages.SimpleFormPage;

public class ValidateSimpleFormTest extends CommonBase {

	@Test(enabled = false)
	public void checkBox() {

		SimpleFormPage basicPage = PageFactory.initElements(driver, SimpleFormPage.class);

		basicPage.clickInputFormLink();
		basicPage.clickSimpleFormDemoLink();
		basicPage.enterMessage("This is simple Message");
		basicPage.clickMessageButton();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
