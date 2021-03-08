package com.vimeo.qa.testCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vimeo.qa.base.TestBase;
import com.vimeo.qa.pages.Channel;
import com.vimeo.qa.pages.Group;
import com.vimeo.qa.pages.HomePage;
import com.vimeo.qa.pages.LoginPage;
import com.vimeo.qa.pages.OnDemand;
import com.vimeo.qa.pages.People;
import com.vimeo.qa.pages.SearchPage;


public class GroupTest extends TestBase {
		
				public LoginPage loginPage;
				public HomePage homePage;
				public SearchPage searchPage; 
				public OnDemand ondemandPage;
				public People peoplePage;
				public Channel channelPage;
				public Group groupPage;
				
			public GroupTest() {
					
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
				    channelPage = peoplePage.clickOnChannelPage();
				    groupPage = channelPage.clickOnGroupPage();
				    
				}
			    
			    @Test(priority = 1)
			    public void verifyTotalData() {
				 
			    Assert.assertEquals(groupPage.verifyTotalCount4(),groupPage.verifyGroupCount(), "Results counter is not displaying the correct number of Group videos");
			    
			    }
			    
			    
			    @AfterMethod
			 	public void tearDown() {
			 		driver.quit();
			 	}

}
