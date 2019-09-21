package com.parameterization.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WithoutParameter {
	
	WebDriver driver;
	
	@Test
	public void testNoParameter() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://w2k2-app-pbart.ams.com:8080/PB01SERVER/Controller");
		
		WebElement userName = driver.findElement(By.id("j_username"));
		WebElement password = driver.findElement(By.id("j_password"));
		WebElement signIn = driver.findElement(By.className("ui-button-text"));
		
		userName.sendKeys("admin");
		password.sendKeys("adminadmin");
		signIn.click();
		
		Thread.sleep(3000);
		
	}
	

}
