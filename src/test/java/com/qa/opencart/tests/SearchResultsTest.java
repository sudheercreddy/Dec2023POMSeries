package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class SearchResultsTest extends BaseTest {

	@BeforeClass
	public void SearchResultssetup() {

		actPage1 = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] getProductcountData() {
		return new Object[][] {
			{ "macbook", 3 },
			{ "imac", 1 },
			{ "samsung", 2 },

		};
	}

	@Test(dataProvider = "getProductcountData")
	public void searchResultsTest(String productName, int prodCount) {
		searchResultsPage = actPage1.doSearch(productName);
		Assert.assertEquals(searchResultsPage.getSearchProductcount(), prodCount);

	}

}
