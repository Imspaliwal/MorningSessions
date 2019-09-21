package com.basic.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadProperties {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Properties prop = new Properties();
		
		FileInputStream ip = new FileInputStream("C:\\eclipse-workspace\\MorningSessions\\src\\com\\basic\\test\\config.properties");
		
		prop.load(ip);
		
/*//		Using Properties we are printing keys
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("name1"));
		System.out.println(prop.getProperty("age"));
		System.out.println(prop.getProperty("Age"));*/
		
		String url = prop.getProperty("URL");
		System.out.println(url);
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.driver.chrome", "C:\\Python27\\Scripts\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.driver.chrome", "C:\\Python27\\Scripts\\geckodriver.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(url);
		
		WebElement userName = driver.findElement(By.id(prop.getProperty("userName_Id")));
		WebElement password = driver.findElement(By.id(prop.getProperty("password_Id")));
		WebElement signIn = driver.findElement(By.className(prop.getProperty("signIn_ClassName")));
		
		userName.sendKeys(prop.getProperty("userName"));
		password.sendKeys(prop.getProperty("passwrod"));
		signIn.click();
		
		Thread.sleep(3000);
	}

}
