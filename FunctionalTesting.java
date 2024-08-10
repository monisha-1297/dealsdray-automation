package com.automation.test.FunctionalTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class FunctionalTesting 
{

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demo.dealsdray.com/");
	     driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.findElement(By.xpath("//input[@name='username']")).sendKeys("prexo.mis@dealsdray.com");
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("prexo.mis@dealsdray.com");
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		 driver.findElement(By.xpath("(//button[@name='child'])[2]")).click();
		 driver.findElement(By.xpath("//button[contains(@class,'MuiButton-root MuiButton-contained')]")).click();
		 driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\jayab\\Downloads\\demo-data.xlsx");
		 driver.findElement(By.xpath("//button[text()='Import']")).click();
		 driver.findElement(By.xpath("//button[text()='Validate Data']")).click();
		 Thread.sleep(3000);
		Alert alert= driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		driver.close();
		
		 
		
    }
}
