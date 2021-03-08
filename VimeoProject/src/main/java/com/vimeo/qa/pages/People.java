package com.vimeo.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vimeo.qa.base.TestBase;
import com.vimeo.qa.util.TestUtil;

public class People extends TestBase {
	
	@FindBy(className = "results_count")
	WebElement totalCount3;

	
	@FindBy(xpath = "//*[@class = 'iris_label iris_label--selector']//*[@data-value = 'people']/span")
	WebElement peopleNo;
	
	@FindBy(xpath = "//*[@class = 'iris_label iris_label--selector']//*[@data-value = 'channel']")
	WebElement channel;
	
	 public People() {
		   PageFactory.initElements(driver, this);
		
	    }
	    
	   
	    public String verifyTotalCount3() {
	    	
	    	 String result = totalCount3.getText();
			 String arr[] = result.split(" ", 2);
			 String firstWord = arr[0]; 
			 String result_total3 = "(" + firstWord + ")";
			 return result_total3;
			}
	    
	    
	  
	    public String verifyPeopleCount() {
	    	
	     String people_no = peopleNo.getText();
		 return people_no;
	    }
	    
	    public Channel clickOnChannelPage() {
			Assert.assertTrue(channel.isEnabled(),"Channel is not enabled");
			channel.click();
			driver.navigate().refresh();
	    	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			return new Channel();
			}

}
