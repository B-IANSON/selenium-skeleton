package com.graysonautomation.selenium.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.graysonautomation.selenium.framework.BasePage;

public class GoogleResultsPage extends BasePage {

	public GoogleResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TOLERANCE), this);
	}
	
	@FindBy(css = "a > h3")
	private List<WebElement> resultLinks;
	
	public List<WebElement> getResultLinks() {
		return resultLinks;
	}
}
