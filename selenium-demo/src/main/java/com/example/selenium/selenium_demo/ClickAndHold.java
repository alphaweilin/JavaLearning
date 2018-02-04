package com.example.selenium.selenium_demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickAndHold {

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
        
        driver.get("https://www.baidu.com/duty/");  
        
        //定义第一段文字  
        WebElement Sting_Sected = driver.findElement(By.xpath("//*/div[@class='dwri_bule']/table/tbody/tr/td/p"));  
          
        //定义第二段文字  
        WebElement String_Second = driver.findElement(By.xpath("//*/div[@class='dwri_bule']/table/tbody/tr/td/ul/li[1]"));  
          
        Actions action = new Actions(driver);  
        action.clickAndHold(Sting_Sected).moveToElement(String_Second).perform();  
        action.release();  
        
        Thread.sleep(2000);
        driver.quit();

	}
	
	

}
