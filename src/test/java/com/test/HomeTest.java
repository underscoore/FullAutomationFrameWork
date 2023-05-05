package com.test;

import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.common.CommonBase;
import com.pages.BasicPage;

public class HomeTest extends CommonBase {

	@Test
	public void basicPageTest() throws MalformedURLException, InterruptedException {
		BasicPage basicPage = PageFactory.initElements(remoteDriver, BasicPage.class);
		basicPage.clickBasic();
	}

	@Test
	public void standalone2() throws MalformedURLException, InterruptedException {
		System.out.println(remoteDriver.getCurrentUrl());
		System.out.println(remoteDriver.getTitle());
	}
}
