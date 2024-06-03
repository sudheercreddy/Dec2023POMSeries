package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.CSVUtil;
import com.qa.opencart.utils.ExcelUtil;
import com.qa.opencart.utils.StringUtils;

import io.qameta.allure.Step;

public class RegistrationPageTest extends BaseTest{
	
	
	
	@BeforeClass
	public void registerSetup() {
		
		registrationPage=loginPage.navigateToRegister();
	}
	
	@DataProvider
	public Object[][] getRegistrationData() {
		return new Object[][] {
			{"Sudheer","red","6236235555","123456","123456"},
			{"myra","red","6236235555","123456","123456"},
			{"bindu","red","6236235555","123456","123456"},
			
			
		};
	}
	
	@DataProvider
	public Object[][] getRegistrationDataFromExcel() {
		return  ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
	}
	
	
	@DataProvider
	public Object[][] getRegistrationDataFromCSV() {
		return  CSVUtil.csvData(AppConstants.REGISTER_SHEET_NAME);
	}
	
	
	
	
	@Step("User registration with {1},{2},{3},{4},{5}")
	@Test(dataProvider="getRegistrationDataFromCSV")
	public void doRegistrationTest(String fname, String lname,String phone, String pwd,String confPwd) {
		
		registrationPage.createUser(fname, lname, StringUtils.getRandomEmailID(),phone, pwd, confPwd);
			
	}
	
	}
	
	
	/* using constants 
	 * @Test
	 * 
	 * public void doRegistrationTest() {
	 * registrationPage.createUser(AppConstants.FIRSTNAME, AppConstants.LASTNAME,
	 * AppConstants.TELEPHONE, StringUtils.getRandomEmailID(),
	 * AppConstants.PASSWORD, AppConstants.CONFIRMPASSWORD);
	 * System.out.println("emailId is "+ StringUtils.getRandomEmailID());
	 * 
	 * 
	 * }
	 */
	
	
	/*
	 * @Test public void accountCreatedTest() { registrationPage.accountCreated(); }
	 */
//}

