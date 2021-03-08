package com.vimeo.qa.testCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vimeo.qa.base.TestBase;
import com.vimeo.qa.pages.HomePage;
import com.vimeo.qa.pages.LoginPage;
import com.vimeo.qa.pages.OnDemand;
import com.vimeo.qa.pages.SearchPage;
import com.vimeo.qa.util.TestUtil;

public class SearchPageTest extends TestBase {

	public LoginPage loginPage;
	public HomePage homePage;
	public SearchPage searchPage;
	public OnDemand ondemandPage;
	Random r = new Random();
	
public SearchPageTest() {
		
		super();
	 }
     
     @BeforeMethod
 	public void setup() {
 	
 		initialization();
 	    loginPage = new LoginPage();
 	    homePage =  loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
 	    searchPage = homePage.clickOnSearchPage();
 	   // ondemandPage = searchPage.clickOn_OnDemandPage();
 	}
	
	/*@Test(priority = 1)
    public void verifyTotalData() {
		 
     Assert.assertEquals(searchPage.verifyTotalCount(),searchPage.verifyVideoCount(), "Results counter is not displaying the correct number of videos");
       
	}*/
	
	@Test(priority = 2)
	public void verifyVideosData() {
		
        String pageSourceData = driver.getPageSource();
		
		 String arr1[] =  pageSourceData.split("var data = ");
		 String arr2[] =  arr1[1].split("}};");
		 
		 JSONObject jsonArray = new JSONObject(arr2[0]+"}};");
		 JSONObject j = (JSONObject) jsonArray.get("filtered");
		

		 String total_string = j.get("total").toString();
		 int total  = Integer.parseInt(total_string);
		 System.out.println("###\n"+"Total :" +total);
		
		
		 String perPage_string = j.get("per_page").toString();
		 int perPage  = Integer.parseInt(perPage_string);
		 System.out.println("Per Page : " +perPage);
		
		
		 String page_string = j.get("page").toString();
		 int firstPage  = Integer.parseInt(page_string);
		 System.out.println("First Page : " +firstPage);
		 
		 int lastPage =  (int) Math.ceil((float) total/ (float) perPage);
		 System.out.println("Last page : " + lastPage + "\n" +"###");
		 
		
		 
		
		 JSONObject j1 = (JSONObject) j.get("paging");
		 System.out.println("next : " +j1.get("next").toString());
		 System.out.println("previous : " +j1.get("previous").toString());
		 System.out.println("last : " +j1.get("last").toString());
		 System.out.println("first : " +j1.get("first").toString());
		 
		List <WebElement> videosDisplayedOnPage = driver.findElements(By.xpath("//*[@class = 'iris_video-vital__overlay iris_link-box iris_annotation-box iris_chip-box']"));
		    int videosDisplayedPerPage = videosDisplayedOnPage.size();
		    
		    List <WebElement> notBrokenList = new ArrayList <WebElement>();
		    
		    for(int i = 0; i< videosDisplayedPerPage; i++)
		    
		    {
		    	if(videosDisplayedOnPage.get(i).getAttribute("href")!= null && (!videosDisplayedOnPage.get(i).getAttribute("href").contains("javascript"))) {
		    			
		    			notBrokenList.add(videosDisplayedOnPage.get(i));
		    		
		    	}
		    	
		    }
		    
		    int linksNotBroken = notBrokenList.size();
		    
		    Assert.assertEquals(perPage,videosDisplayedPerPage, "Videos on Per Page Displayed are not 18");
		    Assert.assertEquals(videosDisplayedPerPage,linksNotBroken, "Links on Visdeos displayed are not 18");
		    
		    	 
			 // check if pagination link exists 
		 
		 List <WebElement> pagination = driver.findElements(By.xpath("//div[@class='iris_pagination']//a")); 
			
			

			if(pagination.size()>0){ 
				
				System.out.println("pagination exists"); 
				
			}
		 
		 
		 if (lastPage == 1){
			 try {
				 
			 Assert.assertFalse(searchPage.verifyNextPage(),"Error 1 : Next : lastPage == 1");
			 Assert.assertFalse(searchPage.verifyPrevPage(),"Error 2 : Prev : lastPage == 1");
			 
			 }
			 catch(Exception e) {
				 
				 System.out.println("No Next button available");
				 System.out.println("No Previous button available");
				 
			 }
		 }
		 else if (firstPage == 1 && firstPage != lastPage) {
			 
			 try {
			 
		     Assert.assertTrue(searchPage.verifyNextPage(),"Error 3 : Next : firstPage == 1 && firstPage != lastPage");
			 Assert.assertFalse(searchPage.verifyPrevPage(),"Error 4 : Prev : firstPage == 1 && firstPage != lastPage");
			 
			 }
			 catch(Exception e) {
				 
				 System.out.println("No Previous button available");
			 }
			 
			 }
		  if (lastPage == 2) {
		        
			 searchPage.verifyNextButton();
			 
			 try {
			 
		     Assert.assertFalse(searchPage.verifyNextPage(),"Error 5 : Next : lastPage == 2");
			 Assert.assertTrue(searchPage.verifyPrevPage(),"Error 6 : Prev : lastPage == 2");
			
			 } 
			 catch(Exception e) {
			
				 System.out.println("No Next button available");
			 
			 }
			 }
		 
		 else if (lastPage > 2) {
        
		 searchPage.verifyNextButton();
		 Assert.assertTrue(searchPage.verifyNextPage(),"Error 7 : Next : lastPage > 2");
		 Assert.assertTrue(searchPage.verifyPrevPage(),"Error 8 : Prev : lastPage > 2");
		 
		
		 try {
		 while(searchPage.verifyNextPage()) {
			 
			 searchPage.verifyNextButton();
		 }
		 }
		 
		 catch(Exception e) {
		
		 
			 System.out.println("No Next button available");
		 //Assert.assertFalse(searchPage.verifyNextPage(),"Error 9 : Next : lastPage");
		 Assert.assertTrue(searchPage.verifyPrevPage(),"Error 10 : Prev : lastPage");
		 }
	}
		 
	} 
	    

	
	
	 @AfterMethod
	 	public void tearDown() {
	 		driver.quit();
	 	}
}
