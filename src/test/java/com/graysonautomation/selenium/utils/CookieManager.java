package com.graysonautomation.selenium.utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookieManager {
	
	public void addBasicCookie(WebDriver driver, String name, String value) {
		driver.manage().addCookie(new Cookie(name, value));
	}

}
