package com.basic.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class FindElementsTest {
	
	WebDriver driver;
	
	@Test
	public void findElementsTest(){
		
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
		//dropEdition.selectByIndex(1);
		
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
		
		WebElement termNCondChk = driver.findElement(By.xpath("//input[@type='checkbox']"));
		WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		

	}

}
