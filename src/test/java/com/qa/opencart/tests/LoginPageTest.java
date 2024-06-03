package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("Epic 100: Design opencart LoginPage")
@Story("Design login page features for up application")
@Feature("Login feature")
public class LoginPageTest extends BaseTest {

	@Description("Login to the application")
	@Severity(SeverityLevel.BLOCKER)

	@Test(priority = 1)
	public void loginPagetitleTest() {
		String titleAct = loginPage.getloginPageTitle();
		Assert.assertEquals(titleAct, AppConstants.LOGIN_PAGE_TITLE, AppError.TITLE_NOT_FOUND);

	}

	@Description("Login to the application")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 2)
	public void loginPageURLTest() {
		String actURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
	}

	@Description("Login to the application")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 4)
	public void loginTest() throws InterruptedException {

		actPage1 = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(actPage1.getAccPageTitle(), AppConstants.ACCOUNT_PAGE_TITLE, AppError.TITLE_NOT_FOUND);

		// loginPage.doLogin("dec2023@opencart.con", "Selenium@12345");

	}

	@Test(priority = 3)
	public void isForgetLinkExistTest() {
		Assert.assertTrue(loginPage.isForgetPasswordLinkExist());
	}

}
