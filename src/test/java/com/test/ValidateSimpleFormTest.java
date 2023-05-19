package com.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.common.CommonBase;
import com.common.ExcelDataReader;
import com.pages.SimpleFormPage;

public class ValidateSimpleFormTest extends CommonBase {

	@Test(enabled = true)
	public void checkForMessage() throws Exception {

		String messageData = ExcelDataReader.data("MESSAGE");
		String number1 = ExcelDataReader.data("NUMBER1");
		String number2 = ExcelDataReader.data("NUMBER2");

		SimpleFormPage basicPage = PageFactory.initElements(driver, SimpleFormPage.class);

		basicPage.clickInputFormLink();
		basicPage.clickSimpleFormDemoLink();
		basicPage.enterMessage(messageData);
		basicPage.clickMessageButton();
		basicPage.enterValue1(number1);
		basicPage.enterValue2(number2);
		basicPage.getTotal();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
