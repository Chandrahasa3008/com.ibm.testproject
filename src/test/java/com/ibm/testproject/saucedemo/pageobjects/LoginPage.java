package com.ibm.testproject.saucedemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Using FindBy for locating elements
	@FindBy(how = How.ID, using = "user-name")
	WebElement userNameField;

	@FindBy(how = How.ID, using = "password")
	WebElement passwordField;

	@FindBy(how = How.ID, using = "login-button")
	WebElement loginButton;

	// Defining all the user actions (Methods)
	// that can be performed in the Saucelab login page

	// This method is to set Username in the Username text box
	public void setUserNaame(String strEmail) {
		userNameField.sendKeys(strEmail);
	}

	// This method is to set Password in the password text box
	public void setPassword(String strPassword) {
		passwordField.sendKeys(strPassword);
	}

	// This method is to click on Login Button
	public void clickOnLoginButton() {
		loginButton.click();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getLoginButtonText() {
		return loginButton.getAttribute("value");
	}
}
