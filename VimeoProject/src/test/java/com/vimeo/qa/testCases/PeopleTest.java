package com.vimeo.qa.testCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vimeo.qa.base.TestBase;
import com.vimeo.qa.pages.Channel;
import com.vimeo.qa.pages.HomePage;
import com.vimeo.qa.pages.LoginPage;
import com.vimeo.qa.pages.OnDemand;
import com.vimeo.qa.pages.People;
import com.vimeo.qa.pages.SearchPage;

public class PeopleTest  extends TestBase {

		public LoginPage loginPage;
		public HomePage homePage;
		public SearchPage searchPage; 
		public OnDemand ondemandPage;
		public People peoplePage;
		public Channel channelPage;
		
	public PeopleTest() {
			
			super();
		 }
	
	    @BeforeMethod
		public void setup() {
		
			initialization();
		    loginPage = new LoginPage();
		    homePage =  loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		    searchPage = homePage.clickOnSearchPage();
		    ondemandPage = searchPage.clickOn_OnDemandPage();
		    peoplePage = ondemandPage.clickOnPeoplePage();
		   
		    
		}
	    
	    @Test(priority = 1)
	    public void verifyTotalData() {
		 
	    Assert.assertEquals(peoplePage.verifyTotalCount3(),peoplePage.verifyPeopleCount(), "Results counter is not displaying the correct number of People videos");
	    
	    }
	    
	    @AfterMethod
	 	public void tearDown() {
	 		driver.quit();
	 	}


}
