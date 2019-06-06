package com.graysonautomation.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.graysonautomation.selenium.enums.FacebookLocales;
import com.graysonautomation.selenium.framework.BasePage;
import com.graysonautomation.selenium.utils.CookieManager;

public class FacebookHomePage extends BasePage {

	public FacebookHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TOLERANCE), this);
	}

	public void setLocale(String language) {
		CookieManager cookieManager = new CookieManager();
		cookieManager.addBasicCookie(getDriver(), FacebookLocales.valueOf(language).getCookieName(),
				FacebookLocales.valueOf(language).getCookieValue());
		getDriver().navigate().refresh();
		waitForTitle(FacebookLocales.valueOf(language).getKeyword());
	}
	
	public boolean refreshWithLocaleCookie(String language) {
		getDriver().navigate().refresh();		
		return waitForTitle(FacebookLocales.valueOf(language).getKeyword());
	}

}
