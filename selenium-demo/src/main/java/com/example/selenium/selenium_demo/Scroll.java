package com.example.selenium.selenium_demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Scroll {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.firefox.marionette", ".\\Tools\\geckodriver.exe");  //firefox版本低于48时使用
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
        //初始化一个火狐浏览器实例，实例名称叫driver  
        WebDriver driver = new FirefoxDriver();  
        //最大化窗口  
        driver.manage().window().maximize();  
        //设置页面加载完成等待时间  
        driver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS);  
        
        driver.get("http://blog.csdn.net/u011541946");    
        
        Thread.sleep(1000);  
          
        // 定义csdn底部 公司简介 这个元素  
        WebElement element = driver.findElement(By.xpath("//*/dd[@class='foot_sub_menu']/a[1]"));  
        //创建一个javascript 执行实例  
        JavascriptExecutor je = (JavascriptExecutor) driver;  
              
        //执行js语句，拖拽浏览器滚动条，直到该元素到底部，马上就不可以见  
        je.executeScript("arguments[0].scrollIntoView(true);",element);    

	}
	
	

}
