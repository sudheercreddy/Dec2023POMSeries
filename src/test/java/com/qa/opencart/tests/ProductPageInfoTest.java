package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class ProductPageInfoTest extends BaseTest {

	@BeforeClass
	public void infoPageSetup() {
		actPage1 = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] getProductSearchData() {
		return new Object[][] { { "MacBook Pro", "MacBook Pro" }, { "iMac", "iMac" },
				{ "samsung", "Samsung SyncMaster 941BW" }, { "samsung", "Samsung Galaxy Tab 10.1" },

		};
	}

	@Test(dataProvider = "getProductSearchData")
	public void productHeaderTest(String productName, String productSelect) {
		searchResultsPage = actPage1.doSearch(productName);
		ProductInfoPage = searchResultsPage.selectproduct(productSelect);

		Assert.assertEquals(ProductInfoPage.getHeadertest(), productSelect);
		// Assert.assertEquals(ProductInfoPage.getProductimageCount(), 4);
	}

	@DataProvider
	public Object[][] getProductCountdata() {

		return new Object[][] {

				{ "imac","iMac", "3" },
				{"MacBook Pro","MacBook Pro","4"}

		};

	}
	
	
	@DataProvider
	public Object[][] getProductCountdataFromExcel() {
		return  ExcelUtil.getTestData(AppConstants.PRODUCT_SHEET_NAME);
		

	}
	

	@Test(dataProvider = "getProductCountdata")
	public void productimageCountTest(String searchProd, String prodName, String imageCount) {
		searchResultsPage = actPage1.doSearch(searchProd);
		ProductInfoPage = searchResultsPage.selectproduct(prodName);

		Assert.assertEquals(ProductInfoPage.getProductimageCount(), Integer.parseInt(imageCount));
	}

	/*
	 * 
	 */
	/*
	 * @DataProvider public Object[][] productinfoData() { return new Object[][] { {
	 * "Brand", "Apple" }, { "Reward Points", "800" }, { "extTaxPrice", "$2,000.00"
	 * }
	 * 
	 * };
	 */
	// }

	@Test
	public void productInfoTest() {
		searchResultsPage = actPage1.doSearch("MacBook Pro");
		ProductInfoPage = searchResultsPage.selectproduct("MacBook Pro");
		Map<String, String> producActList = ProductInfoPage.getProductDetailsMap();
		System.out.println(producActList);
		// sft.assertEquals(producActList.get(keyName), valueName);

		sft.assertEquals(producActList.get("Reward Points"), "800"); //
		// Assert.assertEquals(producActList.get(keyName), valueName);

		Assert.assertEquals(producActList.get("Product Code"), "Product 18");

		Assert.assertEquals(producActList.get("Reward Points"), "800");
		Assert.assertEquals(producActList.get("productprice"), "$2,000.00");
		Assert.assertEquals(producActList.get("extTaxPrice"), "$2,000.00");

		sft.assertAll();
	}
}
