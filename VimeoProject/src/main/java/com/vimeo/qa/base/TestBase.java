package com.vimeo.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vimeo.qa.util.TestUtil;

public class TestBase {

	//public static final String secondHalf = prop.getProperty("user");
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
	
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/Users/ManishPatil/eclipse-workspace/VimeoTest/src/main/java/com/vimeo/qa/config/config.properties");
			prop.load(ip);
			
		}
		
		catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
catch(IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void initialization () {
		
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\ManishPatil\\Downloads\\selenium-java-3.141.59\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver","C:\\Users\\ManishPatil\\Downloads\\selenium-java-3.141.59\\chromedriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
}
