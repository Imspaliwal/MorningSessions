package com.basic.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class TakeScreenShotTest {
	
	WebDriver driver;
	
	@Test
	public void takeScreenShotTest() throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/index.html");
		
//		Take Screen Shot and store as a File Format.
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
//		Now copy the Screen Shot to desired location using copyFile method.
//		Has to import Ant utility --> http://commons.apache.org/proper/commons-io/download_io.cgi
//		FileUtils.copyFile(src, new File("C:\\eclipse-workspace\\MorningSessions\\TakeScreenShot\\freeCRMHome1.png"));
		
//		Now selenium supports following code:
		FileHandler.copy(src, new File("C:\\eclipse-workspace\\MorningSessions\\TakeScreenShot\\freeCRMHome.png"));
		
		WebElement userName = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		
		userName.sendKeys("test");
		userName.clear();
		password.sendKeys("test");
		loginBtn.submit();
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
