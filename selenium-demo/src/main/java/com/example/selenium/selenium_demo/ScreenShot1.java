package com.example.selenium.selenium_demo;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenShot1 {

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
		driver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS);

		driver.get("https://www.baidu.com");

		Thread.sleep(1000);

		// 调用截图方法
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// 拷贝截图文件到我们项目./Screenshots
		FileUtils.copyFile(src, new File(".\\Screenshots\\screen.png"));

		Thread.sleep(2000);
		driver.quit();

	}

}
