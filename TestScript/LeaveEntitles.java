package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeaveEntitles extends OrangeHRMLoginLogut
{
	
	@Test(priority=0)
	public void AddEmployee()
	{
		driver.findElement(By.xpath(".//*[@id='menu_pim_viewPimModule']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_pim_addEmployee']")).click();
		driver.findElement(By.id("firstName")).sendKeys("Krithika");
		driver.findElement(By.id("middleName")).sendKeys("Singhaniya");
		driver.findElement(By.id("lastName")).sendKeys("K");
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();
	}
	
	@Test(priority=1)
	public void AddLeaveType()
	{
		driver.findElement(By.xpath(".//*[@id='menu_leave_viewLeaveModule']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_leave_Configure']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_leave_leaveTypeList']")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.xpath(".//*[@id='leaveType_txtLeaveTypeName']")).sendKeys("Deepawali");
		driver.findElement(By.id("saveButton")).click();
	}
	
	@Test(priority=2)
	public void AddLeaveEntitle()
	{
		WebDriverWait wait1=new WebDriverWait(driver, 50);
		WebElement leaveentitles = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='menu_leave_Entitlements']")));
		leaveentitles.click();
		driver.findElement(By.xpath(".//*[@id='menu_leave_addLeaveEntitlement']")).click();
		WebElement mulemp = driver.findElement(By.xpath(".//*[@id='entitlements_filters_bulk_assign']"));
		if(mulemp.isEnabled())
		{
			mulemp.click();
			WebElement selectleavetype = driver.findElement(By.xpath(".//*[@id='entitlements_leave_type']"));
			Select leavetype=new Select(selectleavetype);
			leavetype.selectByIndex(1);
			
			WebElement selectleaveperiod = driver.findElement(By.id("period"));
			Select leaveperiod = new Select(selectleaveperiod);
			leaveperiod.selectByIndex(1);
			
			driver.findElement(By.xpath(".//*[@id='entitlements_entitlement']")).sendKeys("22.47");
			driver.findElement(By.id("btnSave")).click();
			driver.findElement(By.id("dialogConfirmBtn")).click();
		}
		
	}
	
	@Test(priority=3)
	public void AddLeaveEntitlewithoutchckbox() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='menu_leave_Entitlements']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_leave_addLeaveEntitlement']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='entitlements_employee_empName']")).sendKeys("kr");
		WebDriverWait wait4=new WebDriverWait(driver, 50);
		WebElement listemp = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[4]/ul/li")));
		listemp.click();
		WebElement selectleavetype1 = driver.findElement(By.xpath(".//*[@id='entitlements_leave_type']"));
		Select leavetype1=new Select(selectleavetype1);
		leavetype1.selectByIndex(1);
		
		WebElement selectleaveperiod1 = driver.findElement(By.id("period"));
		Select leaveperiod1 = new Select(selectleaveperiod1);
		leaveperiod1.selectByIndex(1);
		
		driver.findElement(By.xpath(".//*[@id='entitlements_entitlement']")).sendKeys("22.34");
		driver.findElement(By.id("btnSave")).click();
		WebDriverWait wait=new WebDriverWait(driver, 50); 
		WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='dialogUpdateEntitlementConfirmBtn']")));
		boolean disp = confirm.isDisplayed();
		if(disp)
		{
			confirm.click();
		}
	}
	
	@Test(priority=4)
	public void SearchLeave() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='menu_leave_Entitlements']")).click();
		driver.findElement(By.xpath(".//*[@id='menu_leave_viewLeaveEntitlements']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='entitlements_employee_empName']")).sendKeys("Kri");
		WebDriverWait wait7=new WebDriverWait(driver, 50);
		WebElement suggestion = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[4]/ul/li")));
		suggestion.click();
		WebElement selectleavetype = driver.findElement(By.xpath(".//*[@id='entitlements_leave_type']"));
		Select leavetype=new Select(selectleavetype);
		leavetype.selectByIndex(1);
		driver.findElement(By.id("searchBtn")).click();
	}
	
	@Test(priority=5)
	public void DeleteEmpList()
	{
		WebDriverWait wait8=new WebDriverWait(driver, 50);
		WebElement viewmodule = wait8.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='menu_pim_viewPimModule']")));
		viewmodule.click();
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
