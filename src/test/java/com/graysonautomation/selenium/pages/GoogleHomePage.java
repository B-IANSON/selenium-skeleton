package com.graysonautomation.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.graysonautomation.selenium.framework.BasePage;

public class GoogleHomePage extends BasePage {

	public GoogleHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TOLERANCE), this);
	}

	@FindBy(name = "q")
	private WebElement searchField;

	public void searchForTerm(String keys) {
		keyAndSubmit(searchField, keys);
	}

}
