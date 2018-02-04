package com.example.selenium.selenium_demo;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenShot2 {

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
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));  
  
        ImageIO.write(image, "png", new File(".\\Screenshots\\screen_robot.png"));   

		Thread.sleep(2000);
		driver.quit();

	}

}
