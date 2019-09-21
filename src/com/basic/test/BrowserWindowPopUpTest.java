package com.basic.test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserWindowPopUpTest {
	
	WebDriver driver;
	
	@Test
	public void browserWindowPopUpTest() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://w2k2-app-pbart.ams.com:8080/PB01SERVER/Controller");
		
		driver.findElement(By.name("j_username")).sendKeys("admin");
		driver.findElement(By.name("j_password")).sendKeys("adminadmin");
		driver.findElement(By.className("ui-button-text")).submit();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//img[@alt='Home page in a new window']")).click();
		
		Thread.sleep(5000);
		
		/*Below code will handle Window Pop Up*/
		
//		Set object doesn't store value based on indexes. 
		Set<String> handler = driver.getWindowHandles();
		
		System.out.println(handler);
		
//		Use iterator to iterate object
		Iterator<String> it = handler.iterator();
		
		String parentWindowId = it.next();	// Giving you first value after Top of the stack. That is Parent Window ID. 
		System.out.println("Parent Window ID from Set: "+parentWindowId);
		
		String childWindowID = it.next();	//This will give you child window ID. 
		System.out.println("Child Window ID from Set: "+childWindowID);
		
		driver.switchTo().window(childWindowID);
		
		System.out.println("Child Window Titile: "+driver.getTitle());
		
		driver.close();		//do not quite()
		
		driver.switchTo().window(parentWindowId);
		
		System.out.println("Parent Window Title: "+driver.getTitle());
		
		driver.close();
		
	}

}
