package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class RegistrationPage {
	WebDriver driver;
	ElementUtil eleUtil;

// 1- by locators 
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By agree = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit']");
	private By linkcountinue = By.linkText("Continue");
	private By sucMsg = By.cssSelector("#content h1");
	private By linkLogout = By.linkText("Logout");
	private By linkRegister = By.linkText("Register");

//2-contrsutors
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	// 3- test methods

	public boolean createUser(String Fname, String lName, String emailID, String tPhone, String psword,
			String gconfirmPaswrd) {
		eleUtil.doSendKeys(this.firstName, Fname, 5);
		eleUtil.doSendKeys(this.lastName, lName, 5);
		eleUtil.doSendKeys(this.email, emailID, 5);
		eleUtil.doSendKeys(this.telephone, tPhone, 5);
		eleUtil.doSendKeys(this.password, psword, 5);
		eleUtil.doSendKeys(this.confirmPassword, gconfirmPaswrd, 5);
		eleUtil.doClick(this.agree);
		eleUtil.doClick(this.continueButton);
		boolean sucmessage = eleUtil.doGetElementText(sucMsg).contains("Your Account Has Been Created!");

		if (sucmessage) {
			eleUtil.doClick(linkLogout);
			eleUtil.doClick(linkRegister);

		}
		return false;

	}

	public AccPage accountCreated() {
		eleUtil.doClick(linkcountinue, 5);
		return new AccPage(driver);
	}

}
