package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobTitles extends OrangeHRMLoginLogut
{
	@Test(priority=1)
	public void addjobtitle()
	{
		driver.findElement(By.xpath(".//*[@id='menu_admin_viewAdminModule']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_admin_Job']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_admin_viewJobTitleList']")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.xpath(".//*[@id='jobTitle_jobTitle']")).sendKeys("Manual Testing");
		String jobdesc="Experience in manual testing for 3-4 years";
		driver.findElement(By.xpath(".//*[@id='jobTitle_jobDescription']")).sendKeys(jobdesc);
		String notes = "Job Expired on after 4 days";
		driver.findElement(By.xpath(".//*[@id='jobTitle_note']")).sendKeys(notes);
		driver.findElement(By.id("btnSave")).click();	
	}
	
	@Test(priority=2)
	public void addjobtitlecancel()
	{
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("btnCancel")).click();
	}
	
	@Test(priority=3)
	public void editjobtitle()
	{
		driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr[2]/td[2]/a")).click();
		driver.findElement(By.xpath(".//*[@value='Edit']")).click();
		WebElement editjobttitle = driver.findElement(By.xpath(".//*[@id='jobTitle_jobTitle']"));
		editjobttitle.clear();
		editjobttitle.sendKeys("Automation Testing");
		WebElement editjobdesc = driver.findElement(By.xpath(".//*[@id='jobTitle_jobDescription']"));
		editjobdesc.clear();
		String editjobdes = "Experience in automation testing for 3-4 years";
		editjobdesc.sendKeys(editjobdes);
		WebElement editnotes = driver.findElement(By.xpath(".//*[@id='jobTitle_note']"));
		editnotes.clear();
		String editnote = "Job Expired in 2 days";
		editnotes.sendKeys(editnote);
		driver.findElement(By.xpath(".//*[@value='Save']")).click();
	}
	
	@Test(priority=4)
	public void jobdelete()
	{
		driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr/td/input")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		String expsuccess = driver.findElement(By.xpath(".//div[contains(text(),'Successfully Deleted')]")).getText();
		String actualsuccess = "Success";
		Assert.assertTrue(expsuccess.contains(actualsuccess));	
	}
}
