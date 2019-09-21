package com.basic.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DropdownOtherThanAlreadySelected {
	
	@Test(description = "Dropdown Other Than Already Selected", enabled = false)
	public void DropdownOtherThanAlreadySelected() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Login to POS
		driver.get("https://demo.dealpos.com");
		
		// Enter Login Credentials
		driver.findElement(By.xpath("//input[contains(@id, 'txtUsername')]")).sendKeys("demo");
		driver.findElement(By.xpath("//input[contains(@id, 'txtPassword')]")).sendKeys("1234");
		driver.findElement(By.xpath("//input[contains(@id, 'btnSubmit')]")).submit();
		
		// wait Main screen to load
		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='Embed']//span[text()='Help']"))));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class=' container-fluid d-block ']//h1[contains(text(), 'Dashboard')]"))));
		
		
		// Click in Product
		driver.findElement(By.xpath("//div[@class='sidebar-wrapper']//ul[@class='nav']//li//a//p[contains(text(), 'Products')]")).click();
		
		// wait Product screen to load
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='d-sm-block mt-2']//ul//li//a[contains(text(), 'Last')]"))));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class=' container-fluid d-block ']//h1[contains(text(), 'Products')]"))));
		
		
		// Click on Add
		driver.findElement(By.xpath("//a[contains(text(), 'Add')]")).click();
		
		// wait Add Product screen to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='action-button']//button[contains(text(), 'Submit')]")));
		
		// Working on Category drop down
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@ng-model='ctrl.Model.Product.CategoryID']")));
		
		// using getOptions()
		// Returned all options
		List<WebElement> optionsElement = dropdown.getOptions();
		List<String> allOptions = new ArrayList<>();
		for(int i=0; i<optionsElement.size(); i++) {
			String option = optionsElement.get(i).getText();
			System.out.println(option);
			allOptions.add(option);
		}
		System.out.println(allOptions);

		// Generating Random number with Drop down options range
		int randomDropdownIndex = ThreadLocalRandom.current().nextInt(1, allOptions.size());
		// Select random value in Drop down using index
		dropdown.selectByIndex(randomDropdownIndex);
		
		// Select random value in Drop down using index
		String valueToSelect = allOptions.get(randomDropdownIndex);
		dropdown.selectByVisibleText(valueToSelect);
		
		// using getAllSelectedOptions()
		// Returned currently selected option
		List<WebElement> optionsAllSelectedElement = dropdown.getAllSelectedOptions();
		List<String> allSelectedOptions = new ArrayList<>();
		for(int i=0; i<optionsAllSelectedElement.size(); i++) {
			String option = optionsAllSelectedElement.get(i).getText();
			System.out.println(option);
			allSelectedOptions.add(option);
		}
		System.out.println(allSelectedOptions);		
		
		// Select value in Drop down other than selected
		// First remove selected option from options
		allOptions.removeAll(allSelectedOptions);
		// now select random option from remaining options
		System.out.println("Latest size of all option: "+allOptions.size());
		System.out.println("Latest Items of all option: "+allOptions);
		valueToSelect = allOptions.get(randomDropdownIndex);
		dropdown.selectByVisibleText(valueToSelect);
		
		//select[@ng-model='ctrl.Model.Product.CategoryID']/option
		//span[@id='select2-ddCategory-container']
		//span[@class='select2-results']/ul/li
		

		
		
	}
	
	public void selectRandomDropdown(WebElement dropdownElement) {
		// Working on Category drop down
		Select dropdown = new Select(dropdownElement);
		
		// using getOptions()
		// Returned all options
		List<WebElement> optionsElement = dropdown.getOptions();
		List<String> allOptions = new ArrayList<>();
		for(int i=0; i<optionsElement.size(); i++) {
			String option = optionsElement.get(i).getText();
			System.out.println(option);
			allOptions.add(option);
		}
		System.out.println(allOptions);

		// Generating Random number with Drop down options range
		int randomDropdownIndex = ThreadLocalRandom.current().nextInt(1, allOptions.size());
		
		// Select random value in Drop down using index
		dropdown.selectByIndex(randomDropdownIndex);
		
		// Select random value in Drop down using index
		String valueToSelect = allOptions.get(randomDropdownIndex);
		dropdown.selectByVisibleText(valueToSelect);
	}
	
	public void selectDropdownOtherThanSelected(WebElement dropdownElement) {
		// Working on Category drop down
		Select dropdown = new Select(dropdownElement);
		
		List<WebElement> optionsElement = dropdown.getOptions();
		List<String> allOptions = new ArrayList<>();
		for(int i=0; i<optionsElement.size(); i++) {
			String option = optionsElement.get(i).getText();
			System.out.println(option);
			allOptions.add(option);
		}
		System.out.println(allOptions);
		
		// using getAllSelectedOptions()
		// Returned currently selected option
		List<WebElement> optionsAllSelectedElement = dropdown.getAllSelectedOptions();
		List<String> allSelectedOptions = new ArrayList<>();
		for(int i=0; i<optionsAllSelectedElement.size(); i++) {
			String option = optionsAllSelectedElement.get(i).getText();
			System.out.println(option);
			allSelectedOptions.add(option);
		}
		System.out.println(allSelectedOptions);		
		
		// Select value in Drop down other than selected
		// First remove selected option from options
		allOptions.removeAll(allSelectedOptions);
		
		// Generating Random number with Drop down options range
		int randomDropdownIndex = ThreadLocalRandom.current().nextInt(0, allOptions.size());
		
		// now select random option from remaining options
		System.out.println("Latest size of all option: "+allOptions.size());
		System.out.println("Latest Items of all option: "+allOptions);
		String valueToSelect = allOptions.get(randomDropdownIndex);
		dropdown.selectByVisibleText(valueToSelect);
	}
	
	@Test(description = "Dropdown Other Than Already Selected with Utility Methods", enabled = true)
	public void DropdownOtherThanAlreadySelectedWithUtilityMethods() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Login to POS
		driver.get("https://demo.dealpos.com");
		
		// Enter Login Credentials
		driver.findElement(By.xpath("//input[contains(@id, 'txtUsername')]")).sendKeys("demo");
		driver.findElement(By.xpath("//input[contains(@id, 'txtPassword')]")).sendKeys("1234");
		driver.findElement(By.xpath("//input[contains(@id, 'btnSubmit')]")).submit();
		
		// wait Main screen to load
		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='Embed']//span[text()='Help']"))));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class=' container-fluid d-block ']//h1[contains(text(), 'Dashboard')]"))));
		
		
		// Click in Product
		driver.findElement(By.xpath("//div[@class='sidebar-wrapper']//ul[@class='nav']//li//a//p[contains(text(), 'Products')]")).click();
		
		// wait Product screen to load
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='d-sm-block mt-2']//ul//li//a[contains(text(), 'Last')]"))));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class=' container-fluid d-block ']//h1[contains(text(), 'Products')]"))));
		
		
		// Click on Add
		driver.findElement(By.xpath("//a[contains(text(), 'Add')]")).click();
		
		// wait Add Product screen to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='action-button']//button[contains(text(), 'Submit')]")));
		
		// Working on Category drop down
		WebElement categoryDropdown = driver.findElement(By.xpath("//select[@ng-model='ctrl.Model.Product.CategoryID']"));
		
		selectRandomDropdown(categoryDropdown);
		
		selectDropdownOtherThanSelected(categoryDropdown);

		
		//select[@ng-model='ctrl.Model.Product.CategoryID']/option
		//span[@id='select2-ddCategory-container']
		//span[@class='select2-results']/ul/li
		

		
		
	}	

}
