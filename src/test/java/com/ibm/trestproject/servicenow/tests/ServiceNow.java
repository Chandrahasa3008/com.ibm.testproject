package com.ibm.trestproject.servicenow.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ibm.testproject.servicenow.pageobjects.LoginPage;
import com.ibm.testproject.servicenow.pageobjects.ServiceNowHomePage;

public class ServiceNow extends BaseClass{
	
	   
	   @Test
	   public void testServiceNowLoginPositive() throws Exception{
		   
		   LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		   ServiceNowHomePage snowHomepage = PageFactory.initElements(driver, ServiceNowHomePage.class);
		   
		   
//		   1. Navigate to your service now instance
//	       2. Verify title is ServiceNow
	       System.out.println("//Verify title is ServiceNow");
		   String ExpectedValue = "Log in | ServiceNow";
		   System.out.println("Page Title: " + loginpage.getTitle()); 
		   Assert.assertEquals(loginpage.getTitle(), ExpectedValue);

//			   3. Verify username text field has label of User name
		   System.out.println("//Verify username text field has label of User name");
		   System.out.println("Username label: " + loginpage.usernameLabel.getText());
		   Assert.assertTrue("User name".equals(loginpage.usernameLabel.getText()), "Label in not displayed");
		   
//			   4. Enter username (admin)
		   System.out.println("//Enter username (admin)");  
		   Assert.assertTrue(loginpage.usernameFieldIsDisplayed(), "UserName field is not displayed");
		   Thread.sleep(2000);
		   loginpage.setUserNaame(config.getAdminUser("servicenow_userName"));
		   
//			   5. Verify passowrd text field has label of Password
		   System.out.println("//Verify passowrd text field has label of Password");
		   System.out.println("Password label: " + loginpage.passwordLabel.getText());
		   Assert.assertTrue("Password".equals(loginpage.passwordLabel.getText()), "Label in not displayed");
		   
//			   6. Enter password (instance password)
		   System.out.println("//Enter password (instance password)");  
		   Assert.assertTrue(loginpage.passwordFieldIsDisplayed(), "Password field is not displayed");
		   Thread.sleep(2000);
		   loginpage.setPassword(config.getAdminPass("servicenow_password"));
		   
//			   9. Verify forgot password is visible to the user
		   System.out.println("//Verify forgot password is visible to the user");
		   Assert.assertTrue(loginpage.forgotPasswordLink.isDisplayed(), "Forgot Password link is not displayed");
		   
//			   10. Verify user can see the login button
		   System.out.println("//Verify user can see the login button");
		   Assert.assertTrue(loginpage.loginButton.isDisplayed(), "Login button is not displayed");
		   
//			   11. As user clicks on the login button
//			   12. Verify the title as ServiceNow
		   System.out.println("//As user clicks on the login button, Verify the title as ServiceNow");
		   Thread.sleep(2000);
		   loginpage.clickOnLoginButton();
		   Thread.sleep(10000);
		   System.out.println("Home page title: " + snowHomepage.getPageTitle());
		   Assert.assertTrue(snowHomepage.getPageTitle().contains("ServiceNow"),"Service Now homepage is not displayed");
	   }

}
