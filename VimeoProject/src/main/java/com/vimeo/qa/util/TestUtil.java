package com.vimeo.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.vimeo.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 100;
	public static long IMPLICIT_WAIT = 100;
	/*
	 * public static String TestData_Sheet_Path =
	 * "Give the path of the excel file in the com.vimeo.qa.testData";
	 * 
	 * 
	 * static Workbook book; static Sheet sheet;
	 * 
	 * public void switchToFrame() {
	 * 
	 * driver.switchTo().frame("mainpanel"); }
	 * 
	 * public static Object[][] getTestData(String sheetName) throws
	 * InvalidFormatException{
	 * 
	 * FileInputStream file = null; try { file = new
	 * FileInputStream(TestData_Sheet_Path); }
	 * 
	 * catch (IOException e) { e.printStackTrace(); } sheet =
	 * book.getSheet(sheetName); Object[][] data = new
	 * Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	 * 
	 * for(int i = 0; i < sheet.getLastRowNum(); i++ ) { for(int k = 0; k <
	 * sheet.getRow(0).getLastCellNum(); k++ ) { data[i][k] =
	 * sheet.getRow(i+1).getCell(k).toString();
	 * 
	 * }
	 * 
	 * } return data;
	 * 
	 * 
	 * }
	 */

	// take the screenshot whenever an exception is thrown
	/* public static void takeScreenShotAtEndOFTest() throws IOException {
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		//if(osName.startsWith("Windows")) {
			FileUtils.copyFile(scrFile, new File(currentDir + "\\screenshots\\" + System.currentTimeMillis() + ".png"));
			
		//} 
	//	else {
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	//	}
	}*/

}
