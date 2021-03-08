package com.vimeo.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vimeo.qa.base.TestBase;
import com.vimeo.qa.util.TestUtil;

public class Channel extends TestBase {


	@FindBy(className = "results_count")
	WebElement totalCount4;

	
	@FindBy(xpath = "//*[@class = 'iris_label iris_label--selector']//*[@data-value = 'channel']/span")
	WebElement channelNo;
	
	@FindBy(xpath = "//*[@class = 'iris_label iris_label--selector']//*[@data-value = 'group']")
	WebElement group;
	
	 public Channel() {
		   PageFactory.initElements(driver, this);
		
	    }
	    
	   
	    public String verifyTotalCount3() {
	    	
	    	 String result = totalCount4.getText();
			 String arr[] = result.split(" ", 2);
			 String firstWord = arr[0]; 
			 String result_total4 = "(" + firstWord + ")";
			 return result_total4;
			}
	    
	    
	  
	    public String verifyChannelCount() {
	    	
	     String channel_no = channelNo.getText();
		 return channel_no;
	    }
	    
	    public Group clickOnGroupPage() {
	    	Assert.assertTrue(group.isEnabled(),"Group is not enabled");
	    	group.click();
			driver.navigate().refresh();
	    	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);		
								
			return new Group();
			   
			}

}
