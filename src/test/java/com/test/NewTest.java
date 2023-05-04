package com.test;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.common.CommonBase;
import com.common.CommonUtil;

public class NewTest extends CommonBase {

	@Test
	public void standalone() throws MalformedURLException, InterruptedException {
		System.out.println(remoteDriver.getCurrentUrl());
		System.out.println(remoteDriver.getTitle());
		CommonUtil.threadSleep(20);
	}

	public void standalone2() throws MalformedURLException, InterruptedException {
		System.out.println(remoteDriver.getCurrentUrl());
		System.out.println(remoteDriver.getTitle());
		CommonUtil.threadSleep(20);
	}
}
