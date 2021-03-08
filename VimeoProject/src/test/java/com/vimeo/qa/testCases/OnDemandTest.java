package com.vimeo.qa.testCases;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vimeo.qa.base.TestBase;
import com.vimeo.qa.pages.HomePage;
import com.vimeo.qa.pages.LoginPage;
import com.vimeo.qa.pages.OnDemand;
import com.vimeo.qa.pages.People;
import com.vimeo.qa.pages.SearchPage;

public class OnDemandTest extends TestBase {

	public LoginPage loginPage;
	public HomePage homePage;
	public SearchPage searchPage; 
	public OnDemand ondemandPage;
	public People peoplePage;
	
public OnDemandTest() {
		
		super();
	 }

    @BeforeMethod
	public void setup() {
	
		initialization();
	    loginPage = new LoginPage();
	    homePage =  loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	    searchPage = homePage.clickOnSearchPage();
	    ondemandPage = searchPage.clickOn_OnDemandPage();
	  
	    
	}
    
    @Test(priority = 1)
    public void verifyTotalData()  {
    	
    	
		 
    Assert.assertEquals(ondemandPage.verifyTotalCount2(),ondemandPage.verifyOnDemandCount(), "Results counter is not displaying the correct number of OnDemand videos");
    
    }
    
    @AfterMethod
 	public void tearDown() {
 		driver.quit();
 	}
}
