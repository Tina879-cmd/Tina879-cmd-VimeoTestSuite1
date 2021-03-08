package com.vimeo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vimeo.qa.base.TestBase;

public class Group extends TestBase {

	@FindBy(className = "results_count")
	WebElement totalCount5;

	
	@FindBy(xpath = "//*[@class = 'iris_label iris_label--selector']//*[@data-value = 'group']/span")
	WebElement groupNo;
	
	
	 public Group() {
		   PageFactory.initElements(driver, this);
		
	    }
	    
	   
	    public String verifyTotalCount4() {
	    	
	    	 String result = totalCount5.getText();
			 String arr[] = result.split(" ", 2);
			 String firstWord = arr[0]; 
			 String result_total5 = "(" + firstWord + ")";
			 return result_total5;
			}
	    
	    
	  
	    public String verifyGroupCount() {
	    	
	     String group_no = groupNo.getText();
		 return group_no;
	    }
}
