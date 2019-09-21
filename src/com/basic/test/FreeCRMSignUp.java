package com.basic.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FreeCRMSignUp {
	
	WebDriver driver;
	
	@Test
	public void findElementsTest() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.freecrm.com/index.html");
		
		Thread.sleep(60000);
		
/*		driver.switchTo().frame("intercom-borderless-frame");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[contains(@class, 'intercom-block intercom-block-paragraph')]//span"))).build().perform();
		driver.findElement(By.xpath("//div[contains(@class, 'intercom-borderless-dismiss-button')]")).click();*/
		
		WebElement freeSignUp = driver.findElement(By.linkText(" free sign up"));
		freeSignUp.click();
		
		Thread.sleep(60000);
		
		WebElement signUp = driver.findElement(By.linkText("Sign Up"));
		signUp.click();		
		
		/*Select dropEdition = new Select(driver.findElement(By.id("payment_plan_id")));
		dropEdition.selectByVisibleText("Free Edition");
		
		WebElement firstName = driver.findElement(By.name("first_name"));
		WebElement lastName = driver.findElement(By.name("surname"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement confirmEmail = driver.findElement(By.name("email_confirm"));
		WebElement userName = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement confirmPassword = driver.findElement(By.name("passwordconfirm"));
		WebElement termNCondChk = driver.findElement(By.xpath("//input[@type='checkbox']"));
		WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		
		firstName.sendKeys("Sumit");
		lastName.sendKeys("Paliwal");
		email.sendKeys("sumitpaliwal08@gmail.com");
		confirmEmail.sendKeys("sumitpaliwal08@gmail.com");
		userName.sendKeys("SumitP");
		password.sendKeys("Welcome123#");
		confirmPassword.sendKeys("Welcome123#");
		
		if(!termNCondChk.isSelected())
			termNCondChk.click();*/
		
//		submitBtn.submit();
		
/*		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("intercom-borderless-frame")));*/
				
		
	}

}
