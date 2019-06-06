package com.graysonautomation.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.graysonautomation.selenium.framework.BasePage;

public class GlobalPage extends BasePage {

	public GlobalPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TOLERANCE), this);
	}

	public boolean navigateToHomePage(String target) {
		return getPage(target);
	}
}
