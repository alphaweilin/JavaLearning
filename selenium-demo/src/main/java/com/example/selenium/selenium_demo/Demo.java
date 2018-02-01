package com.example.selenium.selenium_demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.firefox.marionette", ".\\Tools\\geckodriver.exe");  //firefox版本低于48时使用
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
        //初始化一个火狐浏览器实例，实例名称叫driver  
        WebDriver driver = new FirefoxDriver();  
        //最大化窗口  
        driver.manage().window().maximize();  
        //设置隐性等待时间  
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);  
          
        // get()打开一个站点  
        driver.get("https://www.baidu.com");  
        //getTitle()获取当前页面title的值  
        System.out.println("当前打开页面的标题是： "+ driver.getTitle());  
        
        //判断title是不是 百度一下，你就知道  
        try{  
            String baidu_title = "百度一下，你就知道";  
            assert baidu_title == driver.getTitle();  
            System.out.println("Test Pass");  
              
        }catch(Exception e){  
            e.printStackTrace();  
        }  
          
        //关闭并退出浏览器  
        driver.quit();  
        
//        System.out.println("当前用户目录是:" + System.getProperty("user.dir"));
	}

}
