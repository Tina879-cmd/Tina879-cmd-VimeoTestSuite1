package com.vimeo.qa.testCases;


import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vimeo.qa.base.TestBase;
import com.vimeo.qa.pages.HomePage;
import com.vimeo.qa.pages.LoginPage;
import com.vimeo.qa.pages.SearchPage;

public class HomePageTest extends TestBase{
	
	public LoginPage loginPage;
	public HomePage homePage;
	public SearchPage searchPage;
	
     public HomePageTest() {
		
		super();
	 }
     
     @BeforeMethod
 	public void setup() {
 	
 		initialization();
 	    loginPage = new LoginPage();
 	    homePage =  loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
 	}

     
     
    @Test(priority = 1)
  	public void verifyUsername() {
  		
    	Assert.assertTrue(homePage.verifyCorrectUsername()); 
    	 
     }
     
    @Test(priority = 2)
   	public void clickOnSearchPageLink() {
   		
    	searchPage = homePage.clickOnSearchPage(); 
		
   	
		
     }
     
    @AfterMethod
 	public void tearDown() {
 		driver.quit();
 	}
}
