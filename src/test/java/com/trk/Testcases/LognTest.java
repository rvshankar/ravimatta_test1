package com.trk.Testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.trk.base.TestBase;

public class LognTest extends TestBase {
	
	
	@Test
	public void loginAsOriginator() throws InterruptedException, IOException {
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		
	
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		
		driver.findElement(By.xpath(OR.getProperty("username"))).sendKeys("toorakabcorg1@gmail.com");
		log.debug("username element got");
		
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys("Welcome@1");
		log.debug("password element got");
		
		driver.findElement(By.xpath(OR.getProperty("checkTerm"))).click();
		log.debug("clicked on Term checkbox");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("signInBtn"))));
		driver.findElement(By.xpath(OR.getProperty("signInBtn"))).click();
		log.debug("clicked on Sign In button");
		
		System.out.println(driver.getTitle());
	}

}
