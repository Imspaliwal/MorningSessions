package com.basic.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Navigations {
	
//	http://makeseleniumeasy.com/2019/02/03/selenium-interview-question-3-difference-between-get-and-navigate-methods-of-selenium-webdriver/

	@Test(enabled=true)
	public static void navigations1()throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.google.com");

		/*Move to some other external url*/

		driver.navigate().to("https://www.amazon.com");

		/*How to simulate back & forward buttons of browser */

		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);

		driver.findElement(By.name("q")).sendKeys("testing");
		System.out.println(driver.findElement(By.name("q")).getAttribute("value"));

		Thread.sleep(3000);

		driver.close();
	}
	
	@Test
	public static void navigations2()throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.google.com");

		/*Move to some other external url using get()*/

		driver.get("https://www.amazon.com");

		/*How to simulate back & forward buttons of browser */

		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);

		driver.findElement(By.name("q")).sendKeys("testing");
		System.out.println(driver.findElement(By.name("q")).getAttribute("value"));

		Thread.sleep(3000);

		driver.close();
	}

}
