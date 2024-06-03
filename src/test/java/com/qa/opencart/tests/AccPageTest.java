package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccPageTest extends BaseTest {

	@BeforeClass
	public void accsetUP() {
		actPage1 = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		//actPage1 = loginPage.doLogin("dec2023@opencart.con","Selenium@12345");
	}

	@Test
	public void titleTest() {
		String acttitle = actPage1.getAccPageTitle();
		Assert.assertEquals(acttitle, AppConstants.ACCOUNT_PAGE_TITLE);
	}

	@Test
	public void titleURLTest() {
		String actualurl = actPage1.getPageURL();
		System.out.println(actualurl);
		Assert.assertTrue(actualurl.contains(AppConstants.ACC_PAGE_URL_FRACTION));
	}

	@Test
	public void logoutLinkExistTest() {
		Assert.assertTrue(actPage1.logoutLinkExist());
	}

	@Test
	public void myAccountLinkExistTest() {
		Assert.assertTrue(actPage1.myAccountLinkExist());
	}

	@Test
	public void accPageHeaderTest() {
		List<String> actHeaderList = actPage1.getAccountPageheaders();
		System.out.println(actHeaderList);
	}

	@Test(priority=1)
	public void searchTest() {
		actPage1.doSearch("Mac Book");
	}

}
