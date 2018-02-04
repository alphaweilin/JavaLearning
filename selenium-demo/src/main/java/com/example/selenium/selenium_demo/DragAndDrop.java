package com.example.selenium.selenium_demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

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
        
        driver.get("http://jqueryui.com/resources/demos/droppable/default.html");    
        
        Thread.sleep(2000);  
          
        // 定位能拖拽的元素  
        WebElement move_ele = driver.findElement(By.id("draggable"));  
          
        // 定位拖拽目标位置元素  
        WebElement target_ele = driver.findElement(By.id("droppable"));  
          
        Actions action = new Actions(driver);  
        action.dragAndDrop(move_ele, target_ele).build().perform();  
          
        // 验证拖拽成功  
        assert(driver.findElement(By.xpath("//*[@id='droppable']/p[text()='Dropped!']")).isDisplayed() == true);  
        
        Thread.sleep(2000);
        driver.quit();

	}
	
	

}
