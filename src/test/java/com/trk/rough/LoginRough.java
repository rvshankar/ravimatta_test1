package com.trk.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.trk.base.TestBase;

public class LoginRough extends TestBase {
	
	
	//public static FileInputStream fis;

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		driver=new ChromeDriver();
		FileInputStream fis=new FileInputStream("D:\\Test github\\test maven project\\src\\test\\resources\\properties\\config.properties");
		config.load(fis);
		//OR.load(inStream);
		System.out.println(config.getProperty("browser"));
		

	}

}
