package com.trk.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	
	/*
	 * WebDriver
	 * Properties
	 * Logs
	 * ExtentReports
	 * DB
	 * Excel
	 * Mail 
	 * 
	 * 
	 */
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties OR=new Properties();
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	
	@BeforeSuite
	public void setUp() throws IOException {
		System.out.println("inside before suite");
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		config.load(fis);
		if (config.getProperty("browser").equals("chrome")) {
			System.out.println("inside chrome launch");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			System.out.println("setting of chrome done");
			driver=new ChromeDriver();
			System.out.println("launcing chrome");
		}
		else if(config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(config.getProperty("browser").equals("edge")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else {
			System.out.println("only chrome, firefox and edge browser are configured");
		}
		driver.manage().window().maximize();
		driver.get(config.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public static void tearDown() {
		driver.close();
	}
	
	
	

}
