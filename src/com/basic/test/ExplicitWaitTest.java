package com.basic.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaitTest {
	
WebDriver driver;
	
	@Test
	public void explicitWaitTest() throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.hackerearth.com");
		
		//Take Screen Shot and store as a File Format.
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\eclipse-workspace\\MorningSessions\\TakeScreenShot\\hackerEarthLogin.png"));
		
		WebElement liveEvent = driver.findElement(By.xpath("//div[@id='live-events-placeholder']//span"));
		
		clickOn(driver, liveEvent, 1);
		
		src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\eclipse-workspace\\MorningSessions\\TakeScreenShot\\liveEvent.png"));
		
		Thread.sleep(3000);
		
		driver.close();
	}
	
	
/*	Method to click on any web element with until some expected condition meet (Explicit wait)*/
	
	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout)
		.ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
	}

}
