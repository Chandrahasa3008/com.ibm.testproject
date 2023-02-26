package com.ibm.testproject.saucedemo.tests;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ibm.testproject.saucedemo.pageobjects.LoginPage;
import com.ibm.testproject.saucedemo.pageobjects.ProductsPage;
import com.ibm.testproject.saucedemo.pageobjects.YourCartPage;


public class Saucedemo extends BaseClass{
	
	   
	   @Test(priority = 1)
	   public void testSauceLab() throws Exception{
		   
		   LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	       ProductsPage productspage = PageFactory.initElements(driver, ProductsPage.class);
	       YourCartPage yourCartpage = PageFactory.initElements(driver, YourCartPage.class);
		   
	       System.out.println("//Verify the title as Swag Labs");
		   String ExpectedValue = "Swag Labs";
		   System.out.println("Page Title: " + loginpage.getTitle()); 
		   Assert.assertEquals(loginpage.getTitle(), ExpectedValue);
		   
		   System.out.println("//Verify the login button text is capitalized");
		   String loginInUpperCase = "LOGIN";
		   System.out.println("Login Button Value: " + loginpage.getLoginButtonText());
		   Assert.assertTrue(loginInUpperCase.equalsIgnoreCase(loginpage.getLoginButtonText()), "LOGIN is not Capitalized");
		   
		   System.out.println("//Login with standard_user & secret_sauce");
	       loginpage.setUserNaame(config.getAdminUser("userName"));
	       loginpage.setPassword(config.getAdminPass("password"));
	       loginpage.clickOnLoginButton();
	       System.out.println("Page Header: " + productspage.getPageHeader());
	       Assert.assertTrue(productspage.validatePageHeader("Products"), "Products page is not opened");
	       
	       System.out.println("//Verify default filter dropdown is A-Z");
	       String filterOption = "Name (A to Z)";
	       System.out.println("Default Filter Value: " + productspage.getDefaultFilterDropdownOptionValue());
	       Assert.assertTrue(filterOption.equalsIgnoreCase(productspage.getDefaultFilterDropdownOptionValue()), "Default filter value is "+ productspage.getDefaultFilterDropdownOptionValue());
	    
	       System.out.println("//Add the first product to the cart");
	       System.out.println("Add To cart count: " + productspage.AddToCartButtons.size());
	       Assert.assertTrue(productspage.AddToCartButtonIsDisplayed(), "Add to Cart Button is not displayed");
	       Thread.sleep(2000);
	       productspage.clickAddToCartButton(0);
	       
	       System.out.println("//Verify the cart badge has 1 product");
	       System.out.println("Shopping Cart count: " + productspage.shoppinfCartIcon.getText());
	       Assert.assertTrue("1".equalsIgnoreCase(productspage.shoppinfCartIcon.getText().toString()), "Shopping cart value is not 1");
	       
	       System.out.println("//Add the last product to the cart");
	       int totalSize = productspage.AddToCartButtons.size();
	       System.out.println("Add To Cart count: " + totalSize);
	       Assert.assertTrue(totalSize > 0, "Add to button is availabe");
	       Thread.sleep(2000);
	       String itemName = productspage.itemNames.get((totalSize)).getText();
	       System.out.println("Item Name: " + itemName);
	       productspage.clickAddToCartButton((totalSize-1));
	       
	       System.out.println("//Verify the cart badge value is increased");
	       System.out.println("Shopping Cart count: " + productspage.shoppinfCartIcon.getText());
	       Assert.assertTrue("2".equalsIgnoreCase(productspage.shoppinfCartIcon.getText().toString()), "Shopping cart value is not 2");
	       
	       System.out.println("//Remove the first product from the cart");
	       System.out.println("Remove Button count: " + productspage.RemoveButtons.size());
	       Assert.assertTrue(productspage.RemoveButton.isDisplayed(), "Remove Button is not displayed");
	       Thread.sleep(2000);
	       productspage.clickRemoveButton(0);
	       
	       System.out.println("//Verify the cart badge has 1 product");
	       System.out.println("Shopping Cart count: " + productspage.shoppinfCartIcon.getText());
	       Assert.assertTrue("1".equalsIgnoreCase(productspage.shoppinfCartIcon.getText().toString()), "Shopping cart value is not 1");
	       
	       System.out.println("//Click on the cart 🛒");
	       Thread.sleep(2000);
	       productspage.shoppinfCartIcon.click();
		   System.out.println("Page Title: " + yourCartpage.getPageHeader());
		   Thread.sleep(2000);
		   Assert.assertEquals(yourCartpage.getPageHeader(), "YOUR CART");
		   
	       System.out.println("//Verify the added product is available");
		   System.out.println("Your Cart - Item Name: " + yourCartpage.itemName.getText());
		   Assert.assertTrue(itemName.equalsIgnoreCase(yourCartpage.itemName.getText()), "Item Name is not matching");
		   
	       System.out.println("//Click on the continue shopping");
		   Assert.assertTrue(yourCartpage.continueShoppingButton.isDisplayed(), "Continue Shopping button is diaplyed");
		   Thread.sleep(2000);
		   yourCartpage.continueShoppingButton.click();
		   
	       //Change the price filter from low to high
		   Thread.sleep(2000);
		   productspage.selectTheDropDownValue("lohi");
	       System.out.println("Changed Filter Value: " + productspage.getDefaultFilterDropdownOptionValue());
	       Assert.assertTrue("Price (low to high)".equalsIgnoreCase(productspage.getDefaultFilterDropdownOptionValue()), "Changed filter value is "+ productspage.getDefaultFilterDropdownOptionValue());
	       
	       System.out.println("//Verify the price sorted properly");
	       System.out.println("List of sorted prices: " + productspage.storeTheItemPrice());

	    	   }
}

