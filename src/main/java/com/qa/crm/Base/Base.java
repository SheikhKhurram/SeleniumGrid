package com.qa.crm.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.crm.Utility.Utility;

public class Base
{
     
	public static WebDriver driver;
	public static Properties prop;
	
	public Base()
	{
		prop = new Properties();
		FileInputStream fis;
		
		try {
			fis = new FileInputStream( System.getProperty("user.dir") +"\\src\\main\\java\\com\\qa\\crm\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization ()
	{
		String browserName = prop.getProperty("Browser");
		switch (browserName)
		{
		case "chrome" : 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+
					"\\src\\main\\java\\com\\qa\\browserDrivers\\chromedriver.exe" );
			driver =  new ChromeDriver();
			break;
		}
		case "FF":
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+
					"\\src\\main\\java\\com\\qa\\browserDrivers\\geckodriver.exe" );
			driver =  new FirefoxDriver();
			break;
		}
		
		case "IE" : 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+
					"\\src\\main\\java\\com\\qa\\browserDrivers\\MicrosoftWebDriver.exe" );
			driver =  new FirefoxDriver();
			break;
		}
		default :
		{
			System.out.println("Set the browser name as \"chrome\" or  \"FF\"  or  \"IE\"  in properties file");
		}
		}
		driver.get(prop.getProperty("Url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Utility.implicitTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Utility.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		}
		
	}
	
