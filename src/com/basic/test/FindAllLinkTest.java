package com.basic.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindAllLinkTest {
	
	WebDriver driver;
	
	@Test
	public void findPageAllLink() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		
		driver.get("http://w2k2-app-pbart.ams.com:8080/PB01SERVER/Controller");
		
		WebElement userName = driver.findElement(By.id("j_username"));
		WebElement password = driver.findElement(By.id("j_password"));
		WebElement signIn = driver.findElement(By.className("ui-button-text"));
		
		userName.sendKeys("admin");
		password.sendKeys("adminadmin");
		signIn.click();
		
		Thread.sleep(3000);
		
		List<WebElement>allLinkList = driver.findElements(By.tagName("a"));
		//Total Links
		System.out.println(allLinkList.size());
		//for each loop
		for(WebElement a : allLinkList) {
			String linkName = a.getText();
			System.out.println(linkName);
		}
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
