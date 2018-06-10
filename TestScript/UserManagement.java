package com.orangehrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserManagement extends OrangeHRMLoginLogut
{
	@Test(priority=1)
	public void addemployee()
	{
		driver.findElement(By.xpath(".//*[@id='menu_pim_viewPimModule']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_pim_addEmployee']")).click();
		driver.findElement(By.id("firstName")).sendKeys("Seema");
		driver.findElement(By.id("middleName")).sendKeys("Rathore");
		driver.findElement(By.id("lastName")).sendKeys("K");
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();
	}
	
	@Test(priority=2)
	public void AddUser()
	{
		driver.findElement(By.xpath(".//*[@id='menu_admin_viewAdminModule']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_admin_UserManagement']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_admin_viewSystemUsers']")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Seema");
		driver.findElement(By.xpath(".//div[4]/ul/li")).click();
		driver.findElement(By.id("systemUser_userName")).sendKeys("seemarathore");
		driver.findElement(By.xpath(".//*[@id='systemUser_password']")).sendKeys("seemas1.");
		driver.findElement(By.xpath(".//*[@id='systemUser_confirmPassword']")).sendKeys("seemas1.");
		driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
	}
	
	@Test(priority=3)
	public void CancelUser()
	{
		driver.findElement(By.xpath(".//*[@id='menu_admin_viewAdminModule']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_admin_UserManagement']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_admin_viewSystemUsers']")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("btnCancel")).click();
	}
	
	@Test(priority=4)
	public void EmpLogin()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\DISK_SOFT\\student zone\\Selenium Components\\chromedriver.exe");
		ChromeDriver driver2=new ChromeDriver();
		driver2.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver2.get("http://localhost/orangehrm-4.0");
		driver2.findElement(By.id("txtUsername")).sendKeys("seemarathore");
		driver2.findElement(By.id("txtPassword")).sendKeys("seemas1.");
		driver2.findElement(By.id("btnLogin")).click();
		driver2.findElement(By.id("welcome")).click();
		driver2.findElement(By.partialLinkText("Logout")).click();
		driver2.close();
	}
	
	@Test(priority=5)
	public void SearchEmployee()
	{
		WebElement search = driver.findElement(By.xpath(".//*[@id='searchSystemUser_userName']"));
		search.clear();
		search.sendKeys("seemarathore");
		driver.findElement(By.id("searchBtn")).click();
	}
	
	@Test(priority=6)
	public void ResetSearch()
	{
		driver.findElement(By.id("resetBtn")).click();
	}
	
	@Test(priority=7)
	public void DeleteEmpLogin() throws InterruptedException
	{
		Thread.sleep(2500);
		WebElement chkrec = driver.findElement(By.xpath(".//table[@id='resultTable']/tbody/tr[2]/td/input"));
		if(chkrec.isEnabled())
			chkrec.click();
		driver.findElement(By.xpath(".//*[@id='btnDelete']")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		String expsuccess = driver.findElement(By.xpath(".//div[contains(text(),'Successfully Deleted')]")).getText();
		String actualsuccess = "Success";
		Assert.assertTrue(expsuccess.contains(actualsuccess));	
	}
	
	@Test(priority=8)
	public void DeleteEmpList() throws InterruptedException
	{
		Thread.sleep(2500);
		driver.findElement(By.xpath(".//*[@id='menu_pim_viewPimModule']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_pim_viewEmployeeList']")).click();
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
