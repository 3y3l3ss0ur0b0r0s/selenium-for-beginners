package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {
	
	/**
	 * For testing Form Authentication page (wrong username)
	 */
	@Test
	public void loginWrongUsernameTest() {
		System.out.println("Test started.");
		
		// 1. Create driver to send commands to browser
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser started.");
		
		// 2. Open test webpage
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		
		driver.manage().window().maximize();
		System.out.println("Page is opened.");
		sleep(1);
		
		// 3. Enter (wrong) username
		WebElement username = driver.findElement(By.id("username"));;
		username.sendKeys("WRONG_USERNAME");
		
		// 4. Enter password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");
		
		// 5. Click "Login" button
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();
		sleep(1);
		
		// 6. Verifications
		String expectedURL = "https://the-internet.herokuapp.com/login";
		String actualURL = driver.getCurrentUrl();
		// Compare expected and actual URL using TestNG
		Assert.assertEquals(actualURL, expectedURL, "Actual page URL is not the same as expected URL.");
		
		// Check for login failure message
		WebElement failureMessage = driver.findElement(By.xpath("//div[@id='flash']"));
		String expectedMessage = "Your username is invalid!";
		String actualMessage = failureMessage.getText();
		Assert.assertTrue(actualMessage.contains(expectedMessage), "Actual message does not contain the expected failure messsage.");
		
		// 7. Quit driver
		driver.quit();
		System.out.println("Test finished.");
	} // End loginWrongUsernameTest() method
	
	/**
	 * For testing Form Authentication page (wrong password)
	 */
	@Test
	public void loginWrongPasswordTest() {
		System.out.println("Test started.");
		
		// 1. Create driver to send commands to browser
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser started.");
		
		// 2. Open test webpage
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		
		driver.manage().window().maximize();
		System.out.println("Page is opened.");
		sleep(1);
		
		// 3. Enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		
		// 4. Enter (wrong) password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("WRONG_PASSWORD");
		
		// 5. Click "Login" button
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();
		sleep(1);
		
		// 6. Verifications
		String expectedURL = "https://the-internet.herokuapp.com/login";
		String actualURL = driver.getCurrentUrl();
		// Compare expected and actual URL using TestNG
		Assert.assertEquals(actualURL, expectedURL, "Actual page URL is not the same as expected URL.");
		
		// Check for login failure message
		WebElement failureMessage = driver.findElement(By.xpath("//div[@id='flash']"));
		String expectedMessage = "Your password is invalid!";
		String actualMessage = failureMessage.getText();
		Assert.assertTrue(actualMessage.contains(expectedMessage), "Actual message does not contain the expected failure messsage.");
		
		// 7. Quit driver
		driver.quit();
		System.out.println("Test finished.");
	} // End loginWrongPasswordTest() method
	
	/**
	 *  Stop execution for a given amount of time in seconds
	 * @param seconds
	 */
	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} // End sleep() method
}
