package com.test;

import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.common.CommonBase;
import com.common.CommonUtil;
import com.pages.BasicPage;

public class ValidateBasePageTitle extends CommonBase {

	@Test
	@Ignore

	public void basicPageValidationTest() throws MalformedURLException, InterruptedException {
		BasicPage basicPage = PageFactory.initElements(remoteDriver, BasicPage.class);
		basicPage.clickBasic();

		basicPage.validatePageTitle();
//		basicPage.clickLinkSimpleFormDemo();
		CommonUtil.threadSleep(5);
	}

//	@Test
//	public void standalone2() throws MalformedURLException, InterruptedException {
//		System.out.println(remoteDriver.getCurrentUrl());
//		System.out.println(remoteDriver.getTitle());
//	}
}
