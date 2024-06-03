package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private Map<String, String> productMap = new HashMap<String, String>();

	// 1 - private By locators

	private By productHeader = By.tagName("h1");
	private By images = By.cssSelector(".thumbnail img");
	private By productMetadata = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By productMetaPrice = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");

	// 2 -contructor

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// page methods

	public String getHeadertest() {
		String header = eleUtil.doGetElementText(productHeader);
		System.out.println("Product Header is : "+ header);
		return header;
	}

	public int getProductimageCount() {
		System.out.println();
		int totalImages = eleUtil.waitForElementsVisible(images, 5).size();
		System.out.println("totalImages: " + totalImages);
		return totalImages;
	}

	private void getProductMetaData() {
		List<WebElement> pMetaList = eleUtil.getElements(productMetadata);
		for (WebElement e : pMetaList) {
			String txt = e.getText();
			String metaKey = txt.split(":")[0].trim();
			String metaValue = txt.split(":")[1].trim();
			productMap.put(metaKey, metaValue);
		}
	}

	private void getProductPriceData() {
		List<WebElement> priceList = eleUtil.getElements(productMetaPrice);
		String price = priceList.get(0).getText();
		System.out.println("price"+price);
		String extTaxPrice = priceList.get(1).getText().split(":")[1].trim();
		System.out.println("extTaxPrice"+extTaxPrice);
		productMap.put("productprice", price);
		productMap.put("extTaxPrice", extTaxPrice);
	}

	public Map<String, String> getProductDetailsMap() {
		productMap.put("header", getHeadertest());
		getProductMetaData();
		getProductPriceData();
		productMap.put("productImageCount", String.valueOf(getProductimageCount()));
		return productMap;
	}

}
