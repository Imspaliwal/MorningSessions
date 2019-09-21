package com.basic.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ChromeHeadlessTest {
	
	WebDriver driver;
	
	@Test
	public void findElementsTest() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
		
		/*Headless chrome driver
		 * 
		 * Mandatory Options Requested:--
		 * 1. Chrome version should be greater than 59 on mac and greater than 60 on windows
		 * 2. window-size=1400,800
		 * */
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,600");
		options.addArguments("headless");
		options.addArguments("--disable-gpu");
		
		driver = new ChromeDriver(options);
		
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("testing");
        System.out.println(driver.findElement(By.name("q")).getAttribute("value"));
		
		driver.close();
	}

}
