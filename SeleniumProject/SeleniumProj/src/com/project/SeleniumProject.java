package com.project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class SeleniumProject {
	public WebDriver webDriver;
	FirefoxOptions fo;
	public String driverPath = "C:\\Users\\Aditya\\Desktop\\BNP Training\\Phase 5\\geckodriver.exe";
	
	@BeforeTest
	public void setupDriver() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		fo = new FirefoxOptions();
		fo.setCapability("marionette", true);
		webDriver = new FirefoxDriver(fo);
	}
	
	@Test(enabled = false)
	public void gotoWebsite() {
		webDriver.get("http://automationpractice.com/index.php");
		String title = "My Store";
		Assert.assertEquals(webDriver.getTitle(), title);
		//webDriver.close();
	}
	
	@Test
	public void register() {
		webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		webDriver.findElement(By.id("email_create")).sendKeys("bovide8542@djemail.net");
		webDriver.findElement(By.id("SubmitCreate")).click();
		WebDriverWait wait = new WebDriverWait(webDriver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));
		 WebElement gender = webDriver.findElement(By.id("id_gender1"));
		 gender.click();
		webDriver.findElement(By.id("customer_firstname")).sendKeys("MyFirstName");
		webDriver.findElement(By.id("customer_lastname")).sendKeys("MyLastName");
		webDriver.findElement(By.id("passwd")).sendKeys("abcd12345");
		JavascriptExecutor js1 = (JavascriptExecutor) webDriver;  
		js1.executeScript("window.scrollBy(0,500)");
		Select days = new Select(webDriver.findElement(By.name("days")));
		days.selectByValue("14");
		Select months = new Select(webDriver.findElement(By.name("months")));
		months.selectByIndex(4);
		Select years = new Select(webDriver.findElement(By.name("years")));
		years.selectByValue("1970");
		webDriver.findElement(By.id("address1")).sendKeys("My Address Goes Here For The Website");
		webDriver.findElement(By.id("city")).sendKeys("Manhattan");
		JavascriptExecutor js = (JavascriptExecutor) webDriver;  
		js.executeScript("window.scrollBy(0,250)");
		Select state = new Select(webDriver.findElement(By.name("id_state")));
		state.selectByVisibleText("New York");
		webDriver.findElement(By.id("phone_mobile")).sendKeys("9999999999");
		//webDriver.findElement(By.id("submitAccount")).click();
	}
	
	@Test
	public void login() {
		
	}
}
