package com.basic.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class AlertPopUpHandleTest {

	WebDriver driver;

/*	@Test(enabled=false)
	public void alertPopUpHandleTest1() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.name("proceed")).submit();

		Thread.sleep(5000);

		Alert alert = driver.switchTo().alert();

		String alertText = alert.getText();
		System.out.println(alertText);

		if (alertText.equals("Please enter a valid user name")) {
			System.out.println("Correct Alert Message");
		} else {
			System.out.println("Correct Alert Message");
		}

		alert.accept(); // To click on Ok\Accept button

		// alert.dismiss(); //To click in Cancel button

		Thread.sleep(3000);

		driver.close();
	}*/

	@Test(enabled = true)
	public void alertPopUpHandleTest2() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		cap.merge(DesiredCapabilities.chrome());
		
		System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.ixigo.com/trains");

		Thread.sleep(5000);

		Alert alert = driver.switchTo().alert();

		String alertText = alert.getText();
		System.out.println(alertText);

		if (alertText.equals("Please enter a valid user name")) {
			System.out.println("Correct Alert Message");
		} else {
			System.out.println("Correct Alert Message");
		}

		// alert.accept(); //To click on Ok\Accept button

		// alert.dismiss(); //To click in Cancel button

		Thread.sleep(3000);

		// driver.close();
	}

}
