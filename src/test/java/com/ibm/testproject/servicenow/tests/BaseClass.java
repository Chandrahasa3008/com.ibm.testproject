package com.ibm.testproject.servicenow.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ConfigRead;

public class BaseClass {
	
	public static WebDriver driver = null;
	public ConfigRead config;
	  
    @BeforeSuite
    public void initialize() throws Exception {
  
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		config = new ConfigRead();
		driver.manage().window().maximize();
		driver.get(config.getAppURL("servicenow_url"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
  
    @AfterSuite
    // Test cleanup
    public void TeardownTest() {
    	BaseClass.driver.quit();
    }

}
