package com.graysonautomation.selenium.stepdefs;

import com.graysonautomation.selenium.pages.GlobalPage;
import com.graysonautomation.selenium.world.World;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import static org.assertj.core.api.Assertions.assertThat;

public class GlobalSteps {

	private World world;
	private GlobalPage globalPage;

	public GlobalSteps(World world) {
		this.world = world;
	}

	@Before(order = 1)
	public void initPages() throws Throwable {
		globalPage = new GlobalPage(world.getWebDriver());
	}

	@Given("^a web browser is on the \"(.*)\" page$")
	public void navigateToHomePage(String target) throws Throwable {		
		assertThat(globalPage.navigateToHomePage(target)).isTrue();
	}
}
