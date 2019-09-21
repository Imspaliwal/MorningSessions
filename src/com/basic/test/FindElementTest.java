package com.basic.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindElementTest {
	
	WebDriver driver;
	
	@Test
	public void findElementTest() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.freecrm.com/index.html");
		
		WebElement userName = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		
		userName.sendKeys("test");
		Thread.sleep(3000);
		userName.clear();
		password.sendKeys("test");
		loginBtn.submit();
		
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
