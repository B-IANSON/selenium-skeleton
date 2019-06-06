package com.graysonautomation.selenium.enums;

public enum Urls {

	GOOGLE_HOME("https://www.google.com/", "Google"),
	SELENIUM_HOME("https://www.seleniumhq.org/", "Selenium"),
	FACEBOOK_HOME("https://www.facebook.com/", "Facebook");

	private String url;
	private String keyword;

	private Urls(String url, String keyword) {
		this.url = url;
		this.keyword = keyword;
	}

	public String getUrl() {
		return this.url;
	}
	
	public String getKeyword() {
		return this.keyword;
	}
}
