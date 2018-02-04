package com.example.selenium.selenium_demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElement {

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
        
        
        driver.get("https://www.baidu.com/");    
         
        Thread.sleep(2000);  
          
        // 设置  
        WebElement settings = driver.findElement(By.xpath("//*[@id='u1']/a[8]"));  
          
        Actions action = new Actions(driver);  
        action.moveToElement(settings).perform();  
          
        driver.findElement(By.linkText("高级搜索")).click(); 
        

        Thread.sleep(2000);  
        driver.quit();

	}
	
	

}
