package com.graysonautomation.selenium.world;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.graysonautomation.selenium.domain.ActiveData;
import com.graysonautomation.selenium.framework.DriverFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class World {

	private WebDriver driver;
	public ActiveData activeData;

	@Before(order = 0)
	public void setUp() throws Throwable {
		DriverFactory driverFactory = new DriverFactory();
		driver = driverFactory.getWebDriver();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown(Scenario scenario) throws Throwable {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		driver.quit();
	}

	public WebDriver getWebDriver() {
		return driver;
	}
}
