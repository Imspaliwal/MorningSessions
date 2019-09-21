package com.parameterization.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestNGXMLMultipleTest {
	
//	Created two @Test to execute with TestNG.xml
	
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
	
	@Test
	public void findElementsTest() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.freecrm.com/register/");
		
		Select dropEdition = new Select(driver.findElement(By.id("payment_plan_id")));
		
		List<WebElement> editionOptions = dropEdition.getOptions();
		System.out.println(editionOptions.size());
		for(int i=0; i<editionOptions.size(); i++) {
			if(!editionOptions.get(i).getText().equals("Select"));
			String allOptions = editionOptions.get(i).getText();
			System.out.println(allOptions);
		}
		
		dropEdition.selectByValue("5");
		dropEdition.selectByVisibleText("Free Edition");
		
		List<WebElement> textFields = driver.findElements(By.xpath("//input[@type='text']"));
		System.out.println(textFields.size());
		for(int i=0; i<textFields.size(); i++) {
			String textFieldValue = textFields.get(i).getAttribute("placeholder");
			System.out.println(textFieldValue);
		}
		
		List<WebElement> passwords = driver.findElements(By.xpath("//input[@type='password']"));
		System.out.println(passwords.size());
		for(int i=0; i<passwords.size(); i++) {
			String passFieldValue = passwords.get(i).getAttribute("placeholder");
			System.out.println(passFieldValue);
		}
		
		WebElement termNCond = driver.findElement(By.xpath("//input[@type='checkbox']"));
		WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		
		Thread.sleep(3000);
		
		driver.close();
		

	}

}
