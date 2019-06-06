package com.graysonautomation.selenium.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"json:target/cucumber-report/cucumber.json"},
        features = "src/test/resources/com/graysonautomation.selenium/features",
        glue = {"com.graysonautomation.selenium.stepdefs", "com.graysonautomation.selenium.world"},
        junit ={ "--step-notifications"},
        monochrome = true)
public class CucumberIT {
}