package com.ibm.testproject.servicenow.pageobjects;

import org.openqa.selenium.WebDriver;

public class ServiceNowHomePage {
	WebDriver driver;

	public ServiceNowHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
}
