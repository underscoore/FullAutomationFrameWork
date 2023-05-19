package com.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.common.CommonBase;
import com.pages.CheckBoxDemoPage;

public class ValidateCheckBoxTest extends CommonBase {

	@Test
	public void checkForMassage() {
		CheckBoxDemoPage checkBox = PageFactory.initElements(driver, CheckBoxDemoPage.class);

		checkBox.clickInputFormLink();
		checkBox.clickCheckBoxDemoLink();
		checkBox.selectCheckBox();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
