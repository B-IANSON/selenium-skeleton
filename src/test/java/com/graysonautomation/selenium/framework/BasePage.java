package com.graysonautomation.selenium.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.graysonautomation.selenium.enums.Urls;

public abstract class BasePage {

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, WAIT_TOLERANCE);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TOLERANCE), this);
	}

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected static final int WAIT_TOLERANCE = 10;

	protected WebDriver getDriver() {
		return driver;
	}

	protected boolean getPage(String target) {
		getDriver().navigate().to(Urls.valueOf(target).getUrl());
		wait.until(ExpectedConditions.titleContains(Urls.valueOf(target).getKeyword()));
		return true;
	}

	protected void keyAndSubmit(WebElement element, String keys) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(keys);
		element.submit();
	}
	
	protected boolean waitForTitle(String expectedTitle) {
		wait.until(ExpectedConditions.titleContains(expectedTitle));
		return true;
	}
}
