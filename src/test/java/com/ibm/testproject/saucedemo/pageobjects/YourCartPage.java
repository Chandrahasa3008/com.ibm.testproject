package com.ibm.testproject.saucedemo.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class YourCartPage {

	   WebDriver driver;
	   
	    public YourCartPage(WebDriver driver) {
	        this.driver = driver;
	    }
	  
	    // Using FindBy for locating elements
	    @FindBy(how = How.CSS, using = ".title")
	    WebElement pageHeader;
	    
	    @FindBy(how = How.CSS, using = ".inventory_item_name")
		public WebElement itemName;
	    
	    @FindBy(how = How.ID, using = "continue-shopping")
		public WebElement continueShoppingButton;
	    
	    
	    
	    
	    
	    
	    public String getPageHeader() {
            return pageHeader.getText();
        }

}
