package com.vimeo.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vimeo.qa.base.TestBase;
import com.vimeo.qa.util.TestUtil;

public class SearchPage extends TestBase {

	
	@FindBy(className = "results_count")
	WebElement totalCount;
	
	@FindBy(className = "iris_label_subcopy")
	WebElement videoNo;


	@FindBy(xpath = "//*[@id ='pagination']//a[@rel='next']")
	WebElement nextPage;
	
	@FindBy(xpath = "//*[@id ='pagination']//a[@rel='prev']")
	WebElement prevPage;
	
	@FindBy(xpath = "//*[@class = 'iris_label iris_label--selector']//a[@data-value = 'ondemand']")
	WebElement onDemand;
	

    public SearchPage() {
	   PageFactory.initElements(driver, this);
	
    }
    
   
    public String verifyTotalCount() {
    	
    	 String result = totalCount.getText();
		 String arr[] = result.split(" ", 2);
		 String firstWord = arr[0]; 
		 String result_total = "(" + firstWord + ")";
		 return result_total;
		}
    
  
    public String verifyVideoCount() {
    	
     String video_no = videoNo.getText();
	 return video_no;
    }
    
    
    public boolean verifyNextPage() {
		
		 return nextPage.isDisplayed();
		    
		}
    public boolean verifyPrevPage() {
	
    	return prevPage.isDisplayed();
		    
		}
	
    public String verifyNextButton()  {
    	
    	nextPage.click();
    	driver.navigate().refresh();
    	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver.getCurrentUrl();
       }
    
    public OnDemand clickOn_OnDemandPage() {
    	Assert.assertTrue(onDemand.isEnabled(),"On Demand is not enabled");
    	onDemand.click();
    	driver.navigate().refresh();
    	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
		
		   return new OnDemand();
		}
}