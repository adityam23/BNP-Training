package com.project;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
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
		Scanner s = new Scanner(System.in);
		System.out.print("Enter new email to register with : ");
		email = s.nextLine();
		System.out.print("Enter new password : ");
		passwd = s.nextLine();
	}

	@AfterSuite
	public void cleanupDriver() {
		webDriver.close();
	}
	@Test()
	public void gotoWebsite() {
		webDriver.get("http://automationpractice.com/index.php");
		String title = "My Store";
		Assert.assertEquals(webDriver.getTitle(), title);
		// webDriver.close();
	}

	@Test(priority = 1)
	public void register() {
		webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		webDriver.findElement(By.id("email_create")).sendKeys(email);
		webDriver.findElement(By.id("SubmitCreate")).click();
		WebDriverWait wait = new WebDriverWait(webDriver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));
		WebElement gender = webDriver.findElement(By.id("id_gender1"));
		gender.click();
		webDriver.findElement(By.id("customer_firstname")).sendKeys("MyFirstName");
		webDriver.findElement(By.id("customer_lastname")).sendKeys("MyLastName");
		webDriver.findElement(By.id("passwd")).sendKeys(passwd);
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

	@Test(priority = 3)
	public void login() {
		if (!webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account"))
			webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		webDriver.findElement(By.id("email")).sendKeys(email);
		webDriver.findElement(By.id("passwd")).sendKeys(passwd);
		webDriver.findElement(By.id("SubmitLogin")).click();
		Assert.assertEquals(webDriver.getTitle(), "My account - My Store");
		webDriver.findElement(By.className("logout")).click();
	}

	@Test(priority = 2)
	public void failedLogin() {
		if (!webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account"))
			webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		System.out.println("-----------------------");
		System.out.println("Sending wrong email : ");
		webDriver.findElement(By.id("email")).sendKeys("---");
		webDriver.findElement(By.id("passwd")).sendKeys("---");
		webDriver.findElement(By.id("SubmitLogin")).click();
		String error = webDriver.findElement(By.className("alert")).getText();
		System.out.println("---------Error---------");
		System.out.println(error);
		System.out.println("-----------------------");
		webDriver.findElement(By.id("email")).clear();
		webDriver.findElement(By.id("email")).sendKeys(email);
//		webDriver.findElement(By.id("SubmitLogin")).click();
//		Assert.assertEquals(webDriver.getTitle(), "My account - My Store");
//		webDriver.findElement(By.className("logout")).click();

		System.out.println("-----------------------");
		System.out.println("Sending wrong password : ");
//		webDriver.findElement(By.id("email")).sendKeys("bovide8542@djemail.net");
		webDriver.findElement(By.id("passwd")).sendKeys("---");
		webDriver.findElement(By.id("SubmitLogin")).click();
		String error2 = webDriver.findElement(By.className("alert")).getText();
		System.out.println("---------Error---------");
		System.out.println(error2);
		System.out.println("-----------------------");
		webDriver.findElement(By.id("passwd")).clear();
		webDriver.findElement(By.id("passwd")).sendKeys(passwd);
		webDriver.findElement(By.id("SubmitLogin")).click();
		Assert.assertEquals(webDriver.getTitle(), "My account - My Store");
		webDriver.findElement(By.className("logout")).click();

	}
	
	@Test(priority = 4)
	public void searchFail() {
		webDriver.findElement(By.id("search_query_top")).clear();
		webDriver.findElement(By.id("search_query_top")).sendKeys("no such item");
		webDriver.findElement(By.name("submit_search")).click();
		String error = webDriver.findElement(By.className("alert")).getText();
		System.out.println(error);
	}
	
	@Test(priority = 5)
	public void searchAndAddToCart() {
		webDriver.findElement(By.id("search_query_top")).clear();
		webDriver.findElement(By.id("search_query_top")).sendKeys("dress");
		webDriver.findElement(By.name("submit_search")).click();
		List<WebElement> results = webDriver.findElements(By.className("ajax_block_product"));
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,500)"); // visibility
		Actions hover = new Actions(webDriver);
		hover.moveToElement(results.get(3)).perform(); //add 4th dress
		webDriver.findElement(By.xpath("//a[@data-id-product='7']")).click();
		WebDriverWait wait = new WebDriverWait(webDriver, 7);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("continue"))); //continue shopping 
		webDriver.findElement(By.className("continue")).click();
		js.executeScript("window.scrollBy(0,-200)");
		hover.moveToElement(results.get(1)).perform(); //goto 2nd product
		webDriver.findElement(By.id("color_43")).click();
		webDriver.findElement(By.name("Submit")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Proceed to checkout"))); //goto cart
		webDriver.findElement(By.linkText("Proceed to checkout")).click();
	}
}
