package com.vimeo.qa.pages;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vimeo.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory
	
	 @FindBy(xpath = "//*[contains(text(),'Log in')]")
    WebElement loginName;   
	
	@FindBy(name = "email")
	//@CacheLookup
    WebElement username;
	
	@FindBy(name = "password")
    WebElement password;
	
/*	@FindBy(xpath = "//input[contains(text(),'Log in with email')]")
    WebElement loginbtn; */
	
	// Initializing the OR
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) {
		
		loginName.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		password.submit();
		return new HomePage();
	}
}
