package com.vimeo.qa.testCases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vimeo.qa.base.TestBase;
import com.vimeo.qa.pages.HomePage;
import com.vimeo.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	public LoginPage loginPage;
	public HomePage homePage;
	
	public LoginPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setup() {
	
		initialization();
	    loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String titlePage = loginPage.validateLoginPageTitle();
		Assert.assertEquals(titlePage, "Vimeo | The world's only all-in-one video solution");
		
	}
	
	@Test(priority = 2)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
