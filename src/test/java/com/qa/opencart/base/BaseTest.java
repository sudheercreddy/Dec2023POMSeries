package com.qa.opencart.base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchResultsPage;
import com.qa.opencart.pages.loginExFinal;

import io.qameta.allure.Step;

public class BaseTest {

	WebDriver driver;
	DriverFactory df;
	protected Properties prop;
	protected LoginPage loginPage;
	protected AccPage actPage1;
	protected SearchResultsPage searchResultsPage;
	protected RegistrationPage registrationPage;
	protected ProductInfoPage ProductInfoPage;
	protected SoftAssert sft;

	// eg below line
	protected loginExFinal lefTest;

	@Step("Setup: Launching {0} browser and init the browser")
	// ElementUtil eleUtil;
	@Parameters("browser")
	@BeforeTest
	public void setUp(String browserName) throws IOException {
		df = new DriverFactory();
		prop = df.initProp();

		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}

		driver = df.initDriver(prop);

		loginPage = new LoginPage(driver);
		registrationPage = new RegistrationPage(driver);

		lefTest = new loginExFinal(driver);
		sft = new SoftAssert();
		// eleUtil = new ElementUtil(driver);

	}

	@Step("Setup: Closing  browser")

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
