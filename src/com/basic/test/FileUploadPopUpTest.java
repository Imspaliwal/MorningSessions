package com.basic.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class FileUploadPopUpTest {
	
	WebDriver driver;
	
	@Test(enabled=false)
	public void fileUploadPopUpTest1() throws InterruptedException {
		
		System.setProperty("webdriver.driver.chrome", "C:\\Python27\\Scripts\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.foxitsoftware.com/pdf-to-word-converter/");
		
		WebElement browseFile = driver.findElement(By.xpath("//div[@id='uploadifive-file_upload']//input[2]"));
		
//		Test failing because element is not loaded.
//		browseFile(driver, browseFile, 20).sendKeys("C:\\Users\\sumit.paliwal\\Desktop\\Sumit_LinkedIn.pdf");;
		
		Thread.sleep(5000);
		
		driver.close();
	}
	
	@Test
	public void fileUploadPopUpTest2() throws InterruptedException {
		
		System.setProperty("webdriver.driver.chrome", "C:\\Python27\\Scripts\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://html.com/input-type-file");
		
		WebElement browseFile = driver.findElement(By.id("fileupload"));
		
		browseFile(driver, browseFile, 10).sendKeys("C:\\Users\\sumit.paliwal\\Desktop\\Sumit_LinkedIn.pdf");
		
		Thread.sleep(10000);
		
		driver.close();
		
	}
	
	public static WebElement browseFile(WebDriver driver, WebElement browseFileBtn, int timeout) {
		new WebDriverWait(driver, timeout)
		.ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(browseFileBtn));
		
		return browseFileBtn;
	}

}
