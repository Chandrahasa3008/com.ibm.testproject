package com.ibm.testproject.saucedemo.pageobjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {
	   WebDriver driver;
	   
	    public ProductsPage(WebDriver driver) {
	        this.driver = driver;
	    }
	  
	    // Using FindBy for locating elements
	    @FindBy(how = How.XPATH, using = "//span[text()='Products']")
	    WebElement pageHeader;
	    
	    @FindBy(how = How.CSS, using = ".select_container span.active_option")
	    WebElement filterDropDown;
	    
	    @FindBy(how = How.CSS, using = ".btn.btn_primary.btn_small.btn_inventory")
	    public List<WebElement> AddToCartButtons;
	    
	    @FindBy(how = How.CSS, using = ".btn.btn_primary.btn_small.btn_inventory")
	    WebElement AddToCartButton;
	    
	    @FindBy(how = How.CSS, using = ".inventory_item_name")
		public List<WebElement> itemNames;
	    
	    @FindBy(how = How.CSS, using = "a.shopping_cart_link span")
	    public WebElement shoppinfCartIcon;
	    
	    @FindBy(how = How.CSS, using = ".btn.btn_secondary.btn_small.btn_inventory")
	    public List<WebElement> RemoveButtons;
	    
	    @FindBy(how = How.CSS, using = ".btn.btn_secondary.btn_small.btn_inventory")
		public WebElement RemoveButton;
	    
	    @FindBy(how = How.CSS, using = ".product_sort_container")
	    WebElement selectFilerDropDown;
	    
	    @FindBy(how = How.CSS, using = ".inventory_item_price")
	    public List<WebElement> itemPrices;
	    
	    
	    
	    
	    
	    public Boolean validatePageHeader(String products) {
            return pageHeader.isDisplayed();
        }
	    
	    public String getPageHeader() {
            return pageHeader.getText();
        }
	    
	    public String getDefaultFilterDropdownOptionValue() {
	    	return filterDropDown.getText();
        }
	    
	    public Boolean AddToCartButtonIsDisplayed() {
	    	return AddToCartButton.isDisplayed();
	    }

	    public void clickAddToCartButton(int value) {
	    	AddToCartButtons.get(value).click();
	    }
	    
	    public void clickRemoveButton(int value) {
	    	RemoveButtons.get(value).click();
	    }

	    public void selectTheDropDownValue(String value) {
	    	Select sel= new Select(selectFilerDropDown);
	    	sel.selectByValue(value);
	    }
	    
	    public ArrayList<String> storeTheItemPrice() {
	    	ArrayList<String> arrlist = new ArrayList<String>();
	    	java.util.Iterator<WebElement> i = itemPrices.iterator();
	    	while(i.hasNext()) {
	    	    WebElement row = i.next();
	    	    arrlist.add(row.getText());
	    	} 
			return arrlist;
	    }
}
