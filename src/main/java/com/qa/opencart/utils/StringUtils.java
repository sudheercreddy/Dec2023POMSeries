package com.qa.opencart.utils;

public class StringUtils {
	
	
	public static String getRandomEmailID() {
		String emailID= "testautomation"+ System.currentTimeMillis()+"@gmail.com";
		return emailID;
	}

}
