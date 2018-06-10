package com.orangehrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeesList extends OrangeHRMLoginLogut 
{
	@Test(priority=1)
	public void AddEmployee()
	{
		driver.findElement(By.xpath(".//*[@id='menu_pim_viewPimModule']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_pim_addEmployee']")).click();
		driver.findElement(By.id("firstName")).sendKeys("Rahul");
		driver.findElement(By.id("middleName")).sendKeys("Shukla");
		driver.findElement(By.id("lastName")).sendKeys("S");
		WebElement chkLogin = driver.findElement(By.id("chkLogin"));
		if(chkLogin.isEnabled())
		{
			chkLogin.click();
		}
		driver.findElement(By.xpath(".//*[@id='user_name']")).sendKeys("RahulShukla");
		driver.findElement(By.id("user_password")).sendKeys("Rahul123");
		driver.findElement(By.id("re_password")).sendKeys("Rahul123");
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();
	}
	
	@Test(priority=2)
	public void SearchEmployee() throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='menu_pim_viewEmployeeList']")).click();
		Thread.sleep(4000);
		WebElement search = driver.findElement(By.xpath(".//*[@id='empsearch_employee_name_empName']"));
		search.clear();
		search.sendKeys("Rahul");
		driver.findElement(By.xpath(".//div[4]/ul/li")).click();
		driver.findElement(By.id("searchBtn")).click();
	}
	
	@Test(priority=3)
	public void ResetSearch()
	{
		driver.findElement(By.id("resetBtn")).click();
	}
	
	@Test(priority=4)
	public void LoginEmployee()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\DISK_SOFT\\student zone\\Selenium Components\\chromedriver.exe");
		ChromeDriver driver1=new ChromeDriver();
		driver1.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver1.get("http://localhost/orangehrm-4.0");
		driver1.findElement(By.id("txtUsername")).sendKeys("RahulShukla");
		driver1.findElement(By.id("txtPassword")).sendKeys("Rahul123");
		driver1.findElement(By.id("btnLogin")).click();
		driver1.findElement(By.id("welcome")).click();
		driver1.findElement(By.partialLinkText("Logout")).click();
		driver1.close();
	}
	
	@Test(priority=5)
	public void DeleteEmployee() throws InterruptedException
	{
		Thread.sleep(2500);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		WebElement chkrec = driver.findElement(By.xpath(".//table[@id='resultTable']/tbody/tr[2]/td/input"));
		if(chkrec.isEnabled())
			chkrec.click();
		driver.findElement(By.xpath(".//*[@id='btnDelete']")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		String expsuccess = driver.findElement(By.xpath(".//div[contains(text(),'Successfully Deleted')]")).getText();
		String actualsuccess = "Success";
		Assert.assertTrue(expsuccess.contains(actualsuccess));		
	}
}
