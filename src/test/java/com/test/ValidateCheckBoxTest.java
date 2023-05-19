package com.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.common.CommonBase;
import com.pages.CheckBoxDemoPage;

public class ValidateCheckBoxTest extends CommonBase {

	@Test(enabled = false)
	public void checkBox() {
		CheckBoxDemoPage checkBox = PageFactory.initElements(driver, CheckBoxDemoPage.class);

		checkBox.clickInputFormLink();
		checkBox.clickCheckBoxDemoLink();
		checkBox.selectCheckBox();
		checkBox.deselectCheckBox();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
