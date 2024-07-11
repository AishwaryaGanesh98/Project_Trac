package com.trello.admin;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {
	@Test
	public void validateElement() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		try {
			WebElement login = driver.findElement(By.name("login"));
			Assert.assertTrue(true, "Button is present");
			String button = login.getText();
			Assert.assertEquals("Log in", button, "Button text does not match");
		} catch (Exception e) {
			Assert.fail("Button is not present");
		}
		driver.quit();
	}

	@Test
	public void title() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		String login = driver.getTitle();
		Assert.assertEquals("Facebook – log in or sign up", login, "title does not match");
		driver.quit();
	}

	@Test
	public void url() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		String url = driver.getCurrentUrl();
		Assert.assertEquals("https://www.amazon.in/", url, "url does not match");
		driver.quit();
	}

	@Test
	public void button() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		List<WebElement> webElements = driver.findElements(By.tagName("<button>"));
		Boolean isPresent = webElements.isEmpty();
		Assert.assertTrue(isPresent, "button tag is not present"); 
		driver.quit();
	}

	@Test
	public void enabled() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		WebElement login = driver.findElement(By.name("login"));
		Boolean enable = login.isEnabled();
		Assert.assertTrue(enable, "Login button is not enabled");
		driver.quit();
	}

	@Test
	public void displayed() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		WebElement login = driver.findElement(By.name("login"));
		Boolean display = login.isDisplayed();
		Assert.assertTrue(display, "Login button is not displayed");
		driver.quit();
	}

	@Test
	public void listNumber() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("file:///C:/Users/prema/OneDrive/Desktop/sample.html");
		WebElement options = driver.findElement(By.name("Dropdown"));
		Select select = new Select(options);
		List<WebElement> actOptions = select.getOptions();
		int size = actOptions.size();
		Assert.assertTrue(size == 5, "Dropdown does not contain 5 states"); 
		/* (or)
		 List<WebElement> webElements = driver.findElements(By.tagName("option"));
		int size = webElements.size();
		Assert.assertTrue(size == 5, "Dropdown does not contain 5 states");  
		*/
		driver.quit();
	}

	@Test
	public void listName() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("file:///C:/Users/prema/OneDrive/Desktop/sample.html");
		List<String> expectedOptions = Arrays.asList("Karnataka", "Kerala", "Tamil Nadu", "Andhra Pradesh",
				"Telangana");
		WebElement options = driver.findElement(By.name("Dropdown"));
		Select select = new Select(options);
		List<WebElement> actOptions = select.getOptions();
		List<String> actualOptions = new ArrayList<String>(5);
		for (WebElement allOptions : actOptions) {
			actualOptions.add(allOptions.getText());
		}
		Assert.assertTrue(actualOptions.containsAll(expectedOptions), "The two lists are different");
		driver.quit();
	}

	@Test
	public void listSorted() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("file:///C:/Users/prema/OneDrive/Desktop/sample.html");
		WebElement options = driver.findElement(By.name("Dropdown"));
		Select select = new Select(options);
		List<WebElement> actOptions = select.getOptions();
		List<String> actualOptions = new ArrayList<String>(5);
		for (WebElement allOptions : actOptions) {
			actualOptions.add(allOptions.getText());
		}
		List<String> sortedOptions = new ArrayList<String>(actualOptions);
		Collections.sort(sortedOptions);
		Assert.assertEquals(actualOptions, sortedOptions, "List is not in sorted manner");
		driver.quit();
	}
}
