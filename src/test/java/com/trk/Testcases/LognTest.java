package com.trk.Testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.trk.base.TestBase;

public class LognTest extends TestBase {
	
	
	@Test
	public void loginAsOriginator() throws InterruptedException, IOException {
		driver.get(config.getProperty("url"));
		Thread.sleep(5000);
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		System.out.println(OR.getProperty("username"));
		driver.findElement(By.xpath(OR.getProperty("username"))).sendKeys("toorakabcorg1@gmail.com");
		System.out.println(OR.getProperty("password"));
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys("Welcome@1");
		driver.findElement(By.xpath(OR.getProperty("checkTerm"))).click();
		driver.findElement(By.xpath(OR.getProperty("signInBtn"))).click();
		System.out.println(driver.getTitle());
	}

}
