package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class AccPage {

	// Page objects
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1 - private By locators

	private By logoutLink = By.linkText("Logout");
	private By myAccountLink = By.linkText("My Account");
	private By headers = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By buttonSearch = By.cssSelector("div#search button");

	// 2 -contructor

	public AccPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3 - page class methods

	public String getAccPageTitle() {
		String title = eleUtil.waitForTitleIs("My Account", 5);
		System.out.println("Account title is :" + title);
		return title;
	}

	public String getPageURL() {
		String url = eleUtil.waitForURLContains("route=account/account", 5);
		System.out.println("Page URL is " + url);
		return url;
	}

	public boolean logoutLinkExist() {

		return eleUtil.waitForElementVisible(logoutLink, 5).isDisplayed();

	}

	public boolean myAccountLinkExist() {
		return eleUtil.waitForElementVisible(myAccountLink, 5).isDisplayed();
	}

	public SearchResultsPage doSearch(String productName) {
		System.out.println("Searching for " + productName);

		eleUtil.doSendKeys(search, productName);
		eleUtil.doClick(buttonSearch);
		return new SearchResultsPage(driver);
	}

	public List<String> getAccountPageheaders() {
		List<WebElement> headersEleList = eleUtil.getElements(headers);

		List<String> headerList = new ArrayList<String>();

		for (WebElement e : headersEleList) {
			String header = e.getText();
			headerList.add(header);
		}
		return headerList;
	}

}
