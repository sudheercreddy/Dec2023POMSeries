package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.logger.Log;
import com.qa.opencart.utils.ElementUtil;


import io.qameta.allure.Step;

public class LoginPage {

	// page class or page Libary or page Object

	private WebDriver driver;

	private ElementUtil eleUtil;
	// 1.private By locators - private By locators will be accesed by public
	// methods- Encapsulation
	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");
	private By forgetPwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	//private By registerLink = By.linkText("Register");
	//private By registerLink = By.linkText("Register");

	// 2. page class constructor

	/***
	 * Whenever we create Object of LoginPage give me the driver to the private
	 * WebDriver
	 * 
	 * @param driver
	 */

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3 . page actions or page methods.
	@Step("waiting for page title")
	public String getloginPageTitle() {
		// eleUtil.waitfortitle()

		String title = driver.getTitle();
		Log.info("The login page title is : " + title);
		// System.out.println("The login page title is : " + title);
		return title;
	}

	@Step("getLoginPageURL")
	public String getLoginPageURL() {
		String url = driver.getCurrentUrl();
		Log.info("The login page URL is : " + url);
		// System.out.println("The login page URL is : " + url);
		return url;
	}

	@Step("verifying the page title")
	public boolean isForgetPasswordLinkExist() {
		return eleUtil.isElementDisplayed(forgetPwdLink);
		// return driver.findElement(forgetPwdLink).isDisplayed();
	}

	@Step("navigate To Register")
	public RegistrationPage navigateToRegister() {
		eleUtil.doClick(registerLink);
		return new RegistrationPage(driver);

	}

	@Step("Login into the Application")
	public AccPage doLogin(String userName, String pwd) {
		// accesing the private variables in public methods is called Encapsulation

		// System.out.println("Login with the " + userName + " & " + pwd);
		Log.info("Login with the " + userName + " & " + pwd);
		eleUtil.waitForElementVisible(email, 10).sendKeys(userName);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginButton);

		// return new AccountsPage(driver);
		return new AccPage(driver);

	}
}
