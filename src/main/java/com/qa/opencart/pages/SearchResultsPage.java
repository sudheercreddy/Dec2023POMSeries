package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class SearchResultsPage {
	WebDriver driver;
	ElementUtil eleUtil;

	private By searchproduct = By.cssSelector("div.product-thumb");

	public SearchResultsPage(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}
	
	public int getSearchProductcount() {
		return eleUtil.waitForElementsVisible(searchproduct, 10).size();
	}
	
	public ProductInfoPage selectproduct(String productName) {
		System.out.println("searching for the product" + productName);
		eleUtil.waitForElementVisible(By.linkText(productName),10).click();
		return new ProductInfoPage(driver);
	}
	
	

}
