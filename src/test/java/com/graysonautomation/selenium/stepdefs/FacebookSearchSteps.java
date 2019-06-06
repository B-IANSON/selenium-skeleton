package com.graysonautomation.selenium.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import com.graysonautomation.selenium.domain.ActiveData;
import com.graysonautomation.selenium.enums.FacebookLocales;
import com.graysonautomation.selenium.pages.FacebookHomePage;
import com.graysonautomation.selenium.world.World;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FacebookSearchSteps {

	private World world;
	private FacebookHomePage facebookHomePage;

	public FacebookSearchSteps(World world) {
		this.world = world;
	}

	@Before(order = 1)
	public void initPages() throws Throwable {
		facebookHomePage = new FacebookHomePage(world.getWebDriver());
	}

	@When("^the cookie for \"(.*)\" is added$")
	public void searchFor(String langauge) throws Throwable {
		world.activeData = new ActiveData();
		world.activeData.setActiveString(langauge);
		facebookHomePage.setLocale(langauge);
	}

	@Then("^the home page is translated$")
	public void verifyResults() throws Throwable {
		assertThat(world.getWebDriver().getTitle())
				.contains(FacebookLocales.valueOf(world.activeData.getActiveString()).getKeyword());
	}
}
