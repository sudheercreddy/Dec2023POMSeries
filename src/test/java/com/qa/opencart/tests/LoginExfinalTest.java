package com.qa.opencart.tests;

import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginExfinalTest extends BaseTest {
	
	
	@Test
	public void login() {
		lefTest.enterUsername();
		lefTest.enterpassword();
		
	}

}
