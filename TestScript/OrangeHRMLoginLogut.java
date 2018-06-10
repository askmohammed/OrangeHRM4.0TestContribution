package com.orangehrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class OrangeHRMLoginLogut 
{
	public static ChromeDriver driver;
	
	@BeforeSuite
	public void Openbrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\DISK_SOFT\\student zone\\Selenium Components\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://opensource.demo.orangehrmlive.com");
	}
	
	@BeforeTest
	public void Loginbrowser()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@AfterTest
	public void Logoutbrowser()
	{
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@AfterSuite
	public void Closebrowser()
	{
		driver.close();
	}
	
}
