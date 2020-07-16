package com.project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Test;

public class SeleniumProject {
	public WebDriver webDriver;
	FirefoxOptions fo;
	public String driverPath = "C:\\Users\\Aditya\\Desktop\\BNP Training\\Phase 5\\geckodriver.exe";
	public String email,passwd;
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		fo = new FirefoxOptions();
		fo.setCapability("marionette", true);
		webDriver = new FirefoxDriver(fo);
	}

	@Test()
	public void gotoWebsite() {
		webDriver.get("http://automationpractice.com/index.php");
		String title = "My Store";
		//Assert.assertEquals(webDriver.getTitle(), title);
		// webDriver.close();
	}

	@Test(enabled = false)
	public void register() {
		webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		// TODO : get new emailid from tempmail
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
		js1.executeScript("window.scrollBy(0,500)"); // visibility
		Select days = new Select(webDriver.findElement(By.name("days")));
		days.selectByValue("14");
		Select months = new Select(webDriver.findElement(By.name("months")));
		months.selectByIndex(4);
		Select years = new Select(webDriver.findElement(By.name("years")));
		years.selectByValue("1970");
		webDriver.findElement(By.id("address1")).sendKeys("My Address Goes Here For The Website");
		webDriver.findElement(By.id("city")).sendKeys("Manhattan");
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,250)"); // visibility
		Select state = new Select(webDriver.findElement(By.name("id_state")));
		state.selectByVisibleText("New York");
		webDriver.findElement(By.id("postcode")).sendKeys("00000");
		webDriver.findElement(By.id("phone_mobile")).sendKeys("9999999999");
		webDriver.findElement(By.id("submitAccount")).click();
		webDriver.findElement(By.className("logout")).click();
	}

	@Test(enabled = false)
	public void login() {
		if (!webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account"))
			webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		webDriver.findElement(By.id("email")).sendKeys("bovide8542@djemail.net");
		webDriver.findElement(By.id("passwd")).sendKeys("abcd12345");
		webDriver.findElement(By.id("SubmitLogin")).click();
		Assert.assertEquals(webDriver.getTitle(), "My account - My Store");
		webDriver.findElement(By.className("logout")).click();
	}

	@Test(enabled = false)
	public void failedLogin() {
		if (!webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account"))
			webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		System.out.println("-----------------------");
		System.out.println("Sending wrong email : ");
		webDriver.findElement(By.id("email")).sendKeys("---");
		webDriver.findElement(By.id("passwd")).sendKeys("abcd12345");
		webDriver.findElement(By.id("SubmitLogin")).click();
		String error = webDriver.findElement(By.className("alert")).getText();
		System.out.println("---------Error---------");
		System.out.println(error);
		System.out.println("-----------------------");
		webDriver.findElement(By.id("email")).clear();
		webDriver.findElement(By.id("email")).sendKeys("bovide8542@djemail.net");
		webDriver.findElement(By.id("SubmitLogin")).click();
		Assert.assertEquals(webDriver.getTitle(), "My account - My Store");
		webDriver.findElement(By.className("logout")).click();

		System.out.println("-----------------------");
		System.out.println("Sending wrong password : ");
		webDriver.findElement(By.id("email")).sendKeys("bovide8542@djemail.net");
		webDriver.findElement(By.id("passwd")).sendKeys("---");
		webDriver.findElement(By.id("SubmitLogin")).click();
		String error2 = webDriver.findElement(By.className("alert")).getText();
		System.out.println("---------Error---------");
		System.out.println(error2);
		System.out.println("-----------------------");
		webDriver.findElement(By.id("passwd")).clear();
		webDriver.findElement(By.id("passwd")).sendKeys("abcd12345");
		webDriver.findElement(By.id("SubmitLogin")).click();
		Assert.assertEquals(webDriver.getTitle(), "My account - My Store");
		webDriver.findElement(By.className("logout")).click();

	}
	
	@Test(enabled = false)
	public void searchFail() {
		webDriver.findElement(By.id("search_query_top")).sendKeys("no such item");
		webDriver.findElement(By.name("submit_search")).click();
		String error = webDriver.findElement(By.className("alert")).getText();
		System.out.println(error);
	}
	
	@Test(priority = 4)
	public void search() {
		webDriver.findElement(By.id("search_query_top")).sendKeys("dress");
		webDriver.findElement(By.name("submit_search")).click();
		webDriver.findElement(By.)
		webDriver.findElement(By.xpath("//a[@data-id-product='4']")).click();
		String error = webDriver.findElement(By.className("alert")).getText();
		System.out.println(error);
	}
}
