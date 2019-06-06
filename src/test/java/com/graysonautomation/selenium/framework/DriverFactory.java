package com.graysonautomation.selenium.framework;

import static java.lang.System.getProperty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.graysonautomation.selenium.enums.Urls;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private String desiredDriver;

	public DriverFactory() {

		try {
			desiredDriver = getProperty("browser").toLowerCase();
		} catch (NullPointerException e) {
			desiredDriver = "empty";
		}
	}

	public WebDriver getWebDriver() {

		switch (desiredDriver) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();

		case "headless-chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setHeadless(true);
			chromeOptions.addArguments("--window-size=1920,1080");
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver(chromeOptions);

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();

		case "headless-firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setHeadless(true);
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver(firefoxOptions);

		case "edge":
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();

		case "ie":
			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
			ieOptions.introduceFlakinessByIgnoringSecurityDomains();
			ieOptions.setCapability("initialBrowserUrl", Urls.SELENIUM_HOME.getUrl());
			WebDriverManager.iedriver().arch32().setup();
			return new InternetExplorerDriver(ieOptions);

		default:
			System.err.println("***************************************************" + "\n"
					+ "You have requested an invalid browser type " + "\n" + "Your request was " + "\"" + desiredDriver
					+ "\"" + " - Options are:" + "\n" + "\n" + "chrome" + "\n" + "headless-chrome" + "\n" + "firefox"
					+ "\n" + "headless-firefox" + "\n" + "edge" + "\n" + "ie" + "\n" + "\n" + "Build aborted..." + "\n"
					+ "***************************************************");
			System.exit(1);
			return null;
		}
	}
}