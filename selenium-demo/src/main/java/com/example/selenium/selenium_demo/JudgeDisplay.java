package com.example.selenium.selenium_demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JudgeDisplay {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.firefox.marionette",
		// ".\\Tools\\geckodriver.exe"); //firefox版本低于48时使用
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		// 初始化一个火狐浏览器实例，实例名称叫driver
		WebDriver driver = new FirefoxDriver();
		// 最大化窗口
		driver.manage().window().maximize();
		// 设置页面加载完成等待时间
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

//		method1(driver);
		method2(driver);
		
		driver.quit();

	}

	public static void method1(WebDriver driver) throws Exception {
		driver.get("https://www.jd.com/");

		Thread.sleep(1000);

		// 点击登录
		driver.findElement(By.xpath("//*[@id='ttbar-login']/a[1]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[3]/a")).click();
		// 登录中输入用户名和密码
		driver.findElement(By.id("loginname")).sendKeys("abc");
		driver.findElement(By.id("nloginpwd")).sendKeys("123456");
		driver.findElement(By.id("loginsubmit")).click();
		Thread.sleep(2000);
		// 方法一
		WebElement error_message = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[4]/div[2]/div"));
		assert error_message.isDisplayed();
		System.out.println("success");
	}

	public static void method2(WebDriver driver) throws Exception {
		driver.get("https://www.jd.com/");

		Thread.sleep(1000);

		// 点击登录
		driver.findElement(By.xpath("//*[@id='ttbar-login']/a[1]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[3]/a")).click();
		// 登录中输入用户名和密码
		driver.findElement(By.id("loginname")).sendKeys("abc");
		driver.findElement(By.id("nloginpwd")).sendKeys("123456");
		driver.findElement(By.id("loginsubmit")).click();
		Thread.sleep(2000);
		// 方法二
		String error_message = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[4]/div[2]/div")).getText();
		System.out.println("errorMsg:"+error_message);
		assert("请输入验证码".equals(error_message)); 
		System.out.println("success");

	}

}
