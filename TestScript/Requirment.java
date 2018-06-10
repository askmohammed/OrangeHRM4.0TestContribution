package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Requirment extends OrangeHRMLoginLogut
{
	@Test(priority=0)
	public void addcandidates()
	{
		driver.findElement(By.xpath(".//*[@id='menu_recruitment_viewRecruitmentModule']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_recruitment_viewCandidates']")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.xpath(".//*[@id='addCandidate_firstName']")).sendKeys("Nithin");
		driver.findElement(By.xpath(".//*[@id='addCandidate_middleName']")).sendKeys("Shukla");
		driver.findElement(By.xpath(".//*[@id='addCandidate_lastName']")).sendKeys("Shukla");
		driver.findElement(By.xpath(".//*[@id='addCandidate_email']")).sendKeys("NithinShuklas@gmail.com");
		driver.findElement(By.xpath(".//*[@id='addCandidate_contactNo']")).sendKeys("98434567543");
		driver.findElement(By.xpath(".//*[@id='addCandidate_keyWords']")).sendKeys("C,Cpp");
		driver.findElement(By.xpath(".//*[@id='frmAddCandidate']/fieldset/ol[2]/li[5]/img")).click();
		WebElement month = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]"));
		Select mon = new Select(month);
		mon.selectByVisibleText("Mar");
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[3]/a")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("btnSave")).click();
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("btnBack")).click();
	}
	
	@Test(priority=1)
	public void viewcandidates()
	{
		driver.findElement(By.xpath(".//*[@id='candidateSearch_candidateName']")).sendKeys("Ni");
		WebDriverWait wait=new WebDriverWait(driver, 50);
		WebElement listemp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='ac_results']/ul/li")));
		listemp.click();
		driver.findElement(By.xpath(".//*[@id='candidateSearch_keywords']")).sendKeys("C");
		driver.findElement(By.xpath(".//*[@id='frmSrchCandidates']/fieldset/ol/li[7]/img")).click();
		WebElement frommonth = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]"));
		Select frommon= new Select(frommonth);
		frommon.selectByVisibleText("Mar");
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[7]/a")).click();
		driver.findElement(By.xpath(".//*[@id='frmSrchCandidates']/fieldset/ol/li[8]/img")).click();
		WebElement tomonth = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]"));
		Select tomon= new Select(tomonth);
		tomon.selectByVisibleText("Apr");
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[6]/a")).click();
		driver.findElement(By.id("btnSrch")).click();
	}
	
	@Test(priority=4)
	public void deletecandidates()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr/td/input")).click();
		driver.findElement(By.xpath(".//*[@id='btnDelete']")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		String expsuccess = driver.findElement(By.xpath(".//div[contains(text(),'Successfully Deleted')]")).getText();
		String actualsuccess = "Success";
		Assert.assertTrue(expsuccess.contains(actualsuccess));	
	}
}
