package com.graysonautomation.selenium.enums;

public enum FacebookLocales {

	GERMAN("locale", "de_DE", "Anmelden oder Registrieren"),
	SPANISH("locale", "es_LA", "Inicia sesión o regístrate"),
	FRENCH("locale", "fr_FR", "Connexion ou inscription");

	private String cookieName;
	private String cookieValue;
	private String keyword;

	private FacebookLocales(String cookieName, String cookieValue, String keyword) {
		this.cookieName = cookieName;
		this.cookieValue = cookieValue;
		this.keyword = keyword;
	}

	public String getCookieName() {
		return this.cookieName;
	}
	
	public String getCookieValue() {
		return this.cookieValue;
	}
	
	public String getKeyword() {
		return this.keyword;
	}
}
