package com.ibm.testproject.servicenow.pageobjects;

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
	    @FindBy(how = How.ID, using = "user_name")
	    WebElement userNameField;
	  
	    @FindBy(how = How.ID, using = "user_password")
	    WebElement passwordField;
	    
	    @FindBy(how = How.ID, using = "sysverb_login")
	    public WebElement loginButton;
	    
	    @FindBy(how = How.XPATH, using = "//form[@id='loginPage']//input[@id='user_name']/preceding::label")
	    public WebElement usernameLabel;
	    
	    @FindBy(how = How.XPATH, using = "//form[@id='loginPage']//input[@id='user_password']/preceding::label[@for='user_password']")
	    public WebElement passwordLabel;
	    
	    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Forgot Password')]")
	    public WebElement forgotPasswordLink;
	    
	  
	    // Defining all the user actions (Methods)
	    //that can be performed in the ServiceNow login page
	  
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
	    
	    public  String getTitle() {
	    	return driver.getTitle();	
		}
	    
	    public  boolean usernameFieldIsDisplayed() {
	    	return userNameField.isDisplayed();
		}
	    
	    public  boolean passwordFieldIsDisplayed() {
	    	return passwordField.isDisplayed();
		}
	    

}
