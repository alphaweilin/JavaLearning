package com.example.selenium.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDepend {
	WebDriver driver;

	@BeforeClass
	public void setuo() {

		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void openBaidu() throws InterruptedException {

		driver.get("https://www.baidu.com");
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		// assertTrue(driver.getTitle() == "百度一下，你就知道");
	}

	@Test(dependsOnMethods = { "openBaidu" })
	public void testSearch() throws InterruptedException {
		driver.findElement(By.id("kw")).sendKeys("Selenium");
		driver.findElement(By.id("su")).click();
		Thread.sleep(1000);
	}

	@Test(enabled = false)
	public void testSearch2() {
		driver.findElement(By.id("kw")).clear();
		driver.findElement(By.id("kw")).sendKeys("Selenium+Java");
		driver.findElement(By.id("su")).click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
