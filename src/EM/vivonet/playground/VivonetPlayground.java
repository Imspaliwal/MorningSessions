package EM.vivonet.playground;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class VivonetPlayground {
	
	@Test
	public static void getCompanyandStore() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		// Login
		driver.get("https://emv301-lane02.qa.vivonet.com");
		
		driver.findElement(By.id("IDToken1")).sendKeys("SPaliwal");
		driver.findElement(By.id("IDToken2")).sendKeys("Infor2019!");
		driver.findElement(By.id("IDToken3")).sendKeys("Red Dragon");
		driver.findElement(By.id("buLogin")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'Log Out')]"))));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn-changeselection']")));
		driver.findElement(By.xpath("//a[@class='btn-changeselection']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[@class='modal-title']"))));
		
		
	}

}
