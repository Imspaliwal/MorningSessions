package com.basic.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class JavaScriptExecutorConcepts {
	
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://w2k2-app-pbart.ams.com:8080/PB01SERVER/Controller");
		
		driver.findElement(By.id("j_username")).sendKeys("admin");
		driver.findElement(By.id("j_password")).sendKeys("adminadmin");
		//driver.findElement(By.className("ui-button-text")).submit();
		
		WebElement signInBtn = driver.findElement(By.className("ui-button-text"));	//Sign Button
		
		flash(signInBtn, driver);
		
		drawBorder(signInBtn, driver);
		
		//Take Screenshot of border (or bug in system)
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\eclipse-workspace\\MorningSessions\\TakeScreenShot\\border1.png"));
		
		//Generate alert
		//generateAlert(driver, "There is an issue with Sign Up Button");
		
		//clickElementByJS(driver, signInBtn);
		
		String pageTitle = getTitleByJS(driver);
		System.out.println(pageTitle);
		
		String pageText = getPageInnerText(driver);
		System.out.println(pageText);
		
		driver.navigate().to("https://www.adecco.com/");
		
		//scrollPageDown(driver);
		
		WebElement scrollView = driver.findElement(By.linkText("Brazil"));
		
		scrollIntoView(scrollView, driver);
		
		
		
	}
	
	
	/*
	 * 
	 * These all are the Java Script Executor Utilities
	 * 
	 * */
	
	//1. To flash the element you can use below utilities
	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgcolor, element, driver);
		}
	}
	
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

	//2. To border the element you can use below utilities	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border = '3px solid red'", element);
	}
	
	//3. To populate alert you can use below utilities
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
	}
	
	//4. To click on the element you can use below utilities
	public static void clickElementByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	//5. To refresh browser you can use below utilities
	public static void refereshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}
	
	//6. To get title of the page you can use below utilities
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageTitle = js.executeScript("return document.title;").toString();
		return pageTitle;
	}
	
	//7. To get all text of the page you can use below utilities
	// Selenium do not have any method to do this, you can get page souce
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	//8. To scroll down to the page you can use below utilities
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	//9. To scroll down to the particular element to view you can use below utilities
	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
