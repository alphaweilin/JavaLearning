package com.example.selenium.selenium_demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBox {

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
        
        driver.get("https://www.sojump.com/m/2792226.aspx/");    
        
        Thread.sleep(1000);  
          
        // 把单选按钮放在一个list里面  
        List<WebElement> answer_options = driver.findElements(By.xpath("//*/div[@id='divQuestion']/fieldset/div/div/div/span/input/../a"));  
          
        for(WebElement ele : answer_options){  
            ele.click();  
            Thread.sleep(1000);  
        }  
          
        driver.quit();
	}

}
