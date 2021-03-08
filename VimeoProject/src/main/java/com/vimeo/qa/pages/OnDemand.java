package com.vimeo.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vimeo.qa.base.TestBase;
import com.vimeo.qa.util.TestUtil;

public class OnDemand extends TestBase {
	
	@FindBy(className = "results_count")
	WebElement totalCount2;

	
	@FindBy(xpath = "//*[@class = 'iris_label iris_label--selector']//*[@data-value = 'ondemand']/span")
	WebElement onDemandNo;
	
	@FindBy(xpath = "//*[@class = 'iris_label iris_label--selector']//*[@data-value = 'people']")
	WebElement people;
	
	
	 public OnDemand() {
		   PageFactory.initElements(driver, this);
		
	    }
	    
	 public String verifyOnDemandCount() {
	    	
	     String onDemand_no = onDemandNo.getText();
		 return onDemand_no;
	    }
	    
	   
	    public String verifyTotalCount2()  {
	    	
	    	 String result = totalCount2.getText();
			 String arr[] = result.split(" ", 2);
			 String firstWord = arr[0]; 
			 String result_total2 = "(" + firstWord + ")";
			 return result_total2;
			}
	    
	    
	  
	    
	    public People clickOnPeoplePage() {
	    	Assert.assertTrue(people.isEnabled(),"People is not enabled");
				people.click();
				driver.navigate().refresh();
		    	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			   return new People();
			}
	    
}
