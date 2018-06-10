package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Time extends OrangeHRMLoginLogut
{
	@Test(priority=0)
	public void AddEmployee()
	{
		driver.findElement(By.xpath(".//*[@id='menu_pim_viewPimModule']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_pim_addEmployee']")).click();
		driver.findElement(By.id("firstName")).sendKeys("Suman");
		driver.findElement(By.id("middleName")).sendKeys("Agarwal");
		driver.findElement(By.id("lastName")).sendKeys("M");
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();
	}
	
	@Test(priority=1)
	public void viewemprecord() throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='menu_time_viewTimeModule']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_attendance_Attendance']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_attendance_viewAttendanceRecord']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='attendance_employeeName_empName']")).sendKeys("Su");
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement listemp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='ac_results']/ul/li")));
		listemp.click();
		driver.findElement(By.xpath(".//*[@id='reportForm']/fieldset/ol/li[2]/img")).click();
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[2]/a")).click();
		driver.findElement(By.id("btView")).click();
	}
	
	@Test(priority=2)
	public void addemprecord()
	{
		driver.findElement(By.id("btnPunchOut")).click();
		WebElement time = driver.findElement(By.xpath(".//*[@id='attendance_time']"));
		time.clear();
		time.sendKeys("12:04");
		WebElement timezone = driver.findElement(By.xpath(".//*[@id='attendance_timezone']"));
		Select timez = new Select(timezone);
		timez.selectByValue("6");
		driver.findElement(By.xpath(".//*[@id='attendance_timezone']")).sendKeys("This is timezone");
		driver.findElement(By.id("btnPunch")).click();
	}
	
	@Test(priority=3)
	public void deletetimerecord()
	{
		driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr/td/input")).click();
		driver.findElement(By.xpath(".//*[@id='btnDelete']")).click();
		driver.findElement(By.id("okBtn")).click();
		String expsuccess = driver.findElement(By.xpath(".//div[contains(text(),'Successfully Deleted')]")).getText();
		String actualsuccess = "Success";
		Assert.assertTrue(expsuccess.contains(actualsuccess));	
	}
	
	@Test(priority=4)
	public void DeleteEmpList()
	{
		WebDriverWait wait=new WebDriverWait(driver, 50);
		WebElement viewmodule = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='menu_pim_viewPimModule']")));
		viewmodule.click();
		driver.findElement(By.xpath(".//*[@id='menu_pim_viewEmployeeList']")).click();
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
