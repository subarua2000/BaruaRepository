package com.codebury.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestStep {

	
	static WebDriver driver;
	
	@Given("^User opens browser to google$")
	public static void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Shubra/automation-workspace/test-automation/drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
	}
	
	@When("^User navigates to gmail$")
	public static void clickGmail(){
		driver.findElement(By.linkText("Gmail")).click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@data-g-label='Sign in']")).click();
		
	}
	
	@And("^User enters email \"([^\"]*)\"$")
	public static void entersEmail(String email){
		driver.findElement(By.id("Email")).sendKeys(email);
	}
	
	@And("^Clicks next$")
	public static void clickNext(){
		driver.findElement(By.id("next")).click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("Passwd")));
		
	
	}
	@And("^User enters password \"([^\"]*)\"$")
	public static void entersPassword(String password){
		driver.findElement(By.id("Passwd")).sendKeys(password);	
	}
	
	@And("^Clicks sign in$")
	public static void clickSignIn(){
		driver.findElement(By.id("signIn")).click();
	}
	
	@Then("^User is logged into gmail application$")
	public static void assertUserLoggedIn(){
	
		WebElement composeBtn = driver.findElement(By.xpath("//div[@gh='cm']"));
		Assert.assertTrue(composeBtn.isDisplayed());
		driver.close();
	}
	
	@Then("^User is not logged into gmail application$")
	public static void assertUserNotLoggedIn(){
	
		WebElement signInBtn = driver.findElement(By.id("signIn"));
		Assert.assertTrue(signInBtn.isDisplayed());
		driver.close();
	}

	


	
	
}




