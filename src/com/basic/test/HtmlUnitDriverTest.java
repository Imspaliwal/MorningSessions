package com.basic.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class HtmlUnitDriverTest {
	
	
	@Test
	public void headlessHtmlUnitDriverTest() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		WebDriver driver= new HtmlUnitDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		
		String googleTitile = driver.getTitle();
		
		System.out.println(googleTitile);
		
		driver.navigate().to("https://www/amazon.com");
		
		String amazonTitle = driver.getTitle();
		
		System.out.println(amazonTitle);
		
		Thread.sleep(3000);
		
	}


}
