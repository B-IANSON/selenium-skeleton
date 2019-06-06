package com.graysonautomation.selenium.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import com.graysonautomation.selenium.domain.ActiveData;
import com.graysonautomation.selenium.pages.GoogleHomePage;
import com.graysonautomation.selenium.pages.GoogleResultsPage;
import com.graysonautomation.selenium.world.World;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps {

	private World world;
	private GoogleHomePage googleHomePage;
	private GoogleResultsPage googleResultsPage;

	public GoogleSearchSteps(World world) {
		this.world = world;
	}

	@Before(order = 1)
	public void initPages() throws Throwable {
		googleHomePage = new GoogleHomePage(world.getWebDriver());
		googleResultsPage = new GoogleResultsPage(world.getWebDriver());
	}

	@When("^the term \"(.*)\" is submitted$")
	public void searchFor(String term) throws Throwable {
		world.activeData = new ActiveData();
		world.activeData.setActiveString(term);
		googleHomePage.searchForTerm(term);
	}

	@Then("^results for the term are displayed$")
	public void verifyResults() throws Throwable {
		assertThat(googleResultsPage.getResultLinks().get(0).getText().contains(world.activeData.getActiveString()));
	}
}
