package com.vimeo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vimeo.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//h3[contains(text(),'Tina Patil')]")
	WebElement userNameLabel;
	
	/*@FindBy(xpath = "//*[contains(text(),'Search')]")
	WebElement searchClick;	*/
	
	@FindBy(id = "topnav-search")
	WebElement search;
	
	
	// Initializing the OR
		public HomePage() {
			PageFactory.initElements(driver, this);
			
		}
		
		
		
		 public boolean verifyCorrectUsername() {
				
			 return userNameLabel.isDisplayed();
			    
			}
		 
		 
		 
       public SearchPage clickOnSearchPage() {
			
    	   search.click();
    	   search.sendKeys("Sachin Tendulkar");
           search.submit();
   		
		   return new SearchPage();
		}

	

}
