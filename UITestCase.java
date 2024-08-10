package com.automation.test.UITesting;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UITestCase {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		RemoteWebDriver driver = null;
		
		// Define the list of browsers to run the test cases
		String[] browsers = {"Chrome", "Edge"};
		
		//Iterate to run in different browsers
		for ( String browser : browsers) {
		if(browser.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
			
		 }else if(browser.equalsIgnoreCase("edge")) {
			 driver = new EdgeDriver();
		 }
		driver.get("https://www.getcalley.com/page-sitemap.xml");
		
	    //Declare the Desktop resolutions
	    int[][] DesktopRes = {
	    		{1920, 1080},
	    		{1536, 864},
	    		{1366, 768}
	    };
	    
	    //Declare the Mobile resolutions
	    int[][] MobileRes = {
	    		{414, 896},
	    		{375, 667},
	    		{360, 640}
	    };
	    
	    //Iterate through the Desktop resolutions
	    for (int[] desk : DesktopRes) {
	    	int width = desk[0];
	    	int height = desk[1];
	    	
	    	//To select first 5 links from the sitemap.xml
	    	int[] numbers = {1, 2, 3, 4, 5};
	    	
	    	//Iterate and take screenshot for first 5 links
	    	for (int num : numbers) {
	    	driver.findElement(By.xpath("//table[@id='sitemap']/tbody[1]/tr[" + num + "]/td[1]/a[1]")).click();
	    	driver.manage().window().setSize(new Dimension(width,height));
            File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyy_HHmmss");
			String formattedDate = sdf.format(date);
			FileUtils.copyFile(screenshotAs, new File("./ScreenShots/" + browser + "/Desktop/" + width + "x" + height + "/" + num + "_" + formattedDate + ".png"));
	        driver.navigate().back();
	    	}
	    
	}
	   //Iterate through the Mobile resolutions
	    for (int[] mob : MobileRes) {
	    	int width = mob[0];
	    	int height = mob[1];
	    	
	    	int[] numbers = {1, 2, 3, 4, 5};
	    	for (int num : numbers) {
	    	driver.findElement(By.xpath("//table[@id='sitemap']/tbody[1]/tr[" + num + "]/td[1]/a[1]")).click();
	    	driver.manage().window().setSize(new Dimension(width,height));
            File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
            Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyy_HHmmss");
			String formattedDate = sdf.format(date);
			FileUtils.copyFile(screenshotAs, new File("./ScreenShots/" + browser + "/Mobile/" + width + "x" + height + "/" + num + "_" + formattedDate + ".png"));
	        driver.navigate().back();
	    	}
	    
	}
	    driver.close();	  
}
	}
}
