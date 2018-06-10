package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Performance extends OrangeHRMLoginLogut
{
	@Test(priority=0)
	public void addperformance()
	{
		driver.findElement(By.xpath(".//*[@id='menu__Performance']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_performance_Configure']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_performance_searchKpi']")).click();
		driver.findElement(By.id("btnAdd")).click();
		WebElement jobtitle = driver.findElement(By.xpath(".//*[@id='defineKpi360_jobTitleCode']"));
		Select jobtit= new Select(jobtitle);
		jobtit.selectByVisibleText("C");
		driver.findElement(By.xpath(".//*[@id='defineKpi360_keyPerformanceIndicators']")).sendKeys("10");
		driver.findElement(By.xpath(".//*[@id='defineKpi360_minRating']")).sendKeys("20");
		driver.findElement(By.xpath(".//*[@id='defineKpi360_maxRating']")).sendKeys("100");
		driver.findElement(By.id("saveBtn")).click();
	}
	
	@Test(priority=1)
	public void deleteperformance()
	{
		driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr/td/input")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		String expsuccess = driver.findElement(By.xpath(".//div[contains(text(),'Successfully Deleted')]")).getText();
		String actualsuccess = "Success";
		Assert.assertTrue(expsuccess.contains(actualsuccess));	
	}
}
