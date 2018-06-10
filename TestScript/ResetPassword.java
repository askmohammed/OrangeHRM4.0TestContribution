package com.orangehrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResetPassword extends OrangeHRMLoginLogut
{
	@Test(priority=1)
	public void addemployee()
	{
		driver.findElement(By.xpath(".//*[@id='menu_pim_viewPimModule']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_pim_addEmployee']")).click();
		driver.findElement(By.id("firstName")).sendKeys("John");
		driver.findElement(By.id("middleName")).sendKeys("Michael");
		driver.findElement(By.id("lastName")).sendKeys("T");
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();
	}
	
	@Test(priority=2)
	public void AddUser()
	{
		driver.findElement(By.xpath(".//*[@id='menu_admin_viewAdminModule']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_admin_UserManagement']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_admin_viewSystemUsers']")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Jo");
		driver.findElement(By.xpath(".//div[4]/ul/li")).click();
		driver.findElement(By.id("systemUser_userName")).sendKeys("JohnMicheal");
		driver.findElement(By.xpath(".//*[@id='systemUser_password']")).sendKeys("johnm");
		driver.findElement(By.xpath(".//*[@id='systemUser_confirmPassword']")).sendKeys("johnm");
		driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
	}
	
	@Test(priority=3)
	public void EmpResetPass()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\DISK_SOFT\\student zone\\Selenium Components\\chromedriver.exe");
		ChromeDriver driver2=new ChromeDriver();
		driver2.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver2.get("http://localhost/orangehrm-4.0");
		driver2.findElement(By.id("txtUsername")).sendKeys("JohnMicheal");
		driver2.findElement(By.id("txtPassword")).sendKeys("johnm");
		driver2.findElement(By.id("btnLogin")).click();
		driver2.findElement(By.id("welcome")).click();
		driver2.findElement(By.xpath(".//*[contains(text(),'Change Password')]")).click();
		driver2.findElement(By.xpath(".//*[@value='Edit']")).click();
		driver2.findElement(By.xpath(".//*[@id='changeUserPassword_currentPassword']")).sendKeys("johnm");
		driver2.findElement(By.xpath(".//*[@id='changeUserPassword_newPassword']")).sendKeys("johnm123");
		driver2.findElement(By.xpath(".//*[@id='changeUserPassword_confirmNewPassword']")).sendKeys("johnm123");
		driver2.findElement(By.xpath(".//*[@value='Save']")).click();
		driver2.findElement(By.id("welcome")).click();
		driver2.findElement(By.partialLinkText("Logout")).click();
		driver2.findElement(By.id("txtUsername")).sendKeys("JohnMicheal");
		driver2.findElement(By.id("txtPassword")).sendKeys("johnm123");
		driver2.findElement(By.id("btnLogin")).click();		
		driver2.findElement(By.id("welcome")).click();
		driver2.findElement(By.partialLinkText("Logout")).click();
		driver2.close();
	}
	
	@Test(priority=4)
	public void DeleteEmpList() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='menu_pim_viewPimModule']")));
		delete.click();
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
