package com.example.selenium.selenium_demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchPage {

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
        
        driver.get("https://www.jd.com/");    
        
        Thread.sleep(1000);  
          
        //点击京东左侧菜单中的 手机  
        WebElement phone_link = driver.findElement(By.linkText("手机"));  
        phone_link.click();  
        Thread.sleep(1000);  
      
        // 获取当前页面句柄    
        String handle = driver.getWindowHandle();
        switchToAnother(driver,handle);

          
        WebElement xiaomi_link = driver.findElement(By.linkText("小米"));  
        xiaomi_link.click();  
        Thread.sleep(1000);  
        
        // 获取当前页面句柄    
        handle = driver.getWindowHandle();
        switchToAnother(driver,handle);

	}
	
	
	public static void switchToAnother(WebDriver driver, String handle){
        // 获取所有页面的句柄，并循环判断不是当前的句柄   
        for (String temhandle : driver.getWindowHandles()) {    
            if (!temhandle.equals(handle))    
                driver.close();  
                driver.switchTo().window(temhandle);   
             
        }    
	}

}
