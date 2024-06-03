package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class loginExFinal {
	
	//page class or page library 
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By email = By.xpath("//input[@name='email']");
	private By password = By.xpath("//input[@name='password']");
	private By forget = By.linkText("Forgotten Password");
	private By loginbutton = By.xpath("//input[@value='Login']");
	
	
	public loginExFinal(WebDriver driver) {
		this.driver= driver;
		eleUtil = new ElementUtil(driver);
		
	}
	
	public String enterUsername() {
		
		eleUtil.waitForElementVisible(email, 5).sendKeys("dec2023@opencart.con");
		
		return driver.getTitle();
	}
	
	public void enterpassword() {
		eleUtil.waitForElementPresence(password, 5).sendKeys("Selenium@12345");
		eleUtil.doClick(loginbutton);
		
	}
	
	
	
	
	

}
