package testNGExample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.SeleniumUtil;

public class Actitime extends SeleniumUtil{
  @Test
  public void validateHomePageTitle() {
	  WebDriver driver = setUp("chrome","https://demo.actitime.com/login.do");
	  typeInput(driver.findElement(By.id("username")),"admin");
		typeInput(driver.findElement(By.name("pwd")),"manager");
		clickOnElement(driver.findElement(By.id("loginButton")));
		String expectedHomePageTitle="actiTIME - Enter Time-Track";
		String actualHomePageTitle=getCurrentPageTitle("actiTIME - Enter Time-Track");
		Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle,"Either login failed or home page title change");
		
  }
 // @Test(priority=1)
  public void validateTitle() {
	  WebDriver driver = setUp("chrome","https://demo.actitime.com/login.do");
	  String expectedTitle = "actiTIME - Login";
	  String actualTitle = getCurrentPageTitle("actiTIME - Login");
	  Assert.assertEquals(actualTitle, expectedTitle);
  }
  @Test(priority=1)
  public void createTask() throws InterruptedException {
	  driver.findElement(By.cssSelector(".content.tasks")).click();
		//open new task
		driver.findElement(By.cssSelector(".addNewButton")).click();
		driver.findElement(By.cssSelector(".item.createNewTasks")).click();
		//select new customer
		driver.findElement(By.cssSelector(".customerSelector .selectedItem")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".customerSelector .searchItemList")));
		List<WebElement> customer = driver.findElements(By.cssSelector(".customerSelector .searchItemList>div"));
		System.out.println("customer count:"+customer.size());
		if(customer.size()>2) {
			customer.get(customer.size()-1).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".projectSelector .selectedItem")).click();
			Thread.sleep(1000);
			List<WebElement> projectList = driver.findElements(By.cssSelector(".projectSelector .searchItemList>div"));
			if(projectList.size()>3) {
				projectList.get(3).click();
			}
			else {
				projectList.get(0).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".selectProjectRow .newProject")).sendKeys("Abc");
			}
		}
		else {
			customer.get(0).click();
			Thread.sleep(1000);
			List<WebElement> newProject = driver.findElements(By.cssSelector(".newCustomerProjectField "));
			newProject.get(0).sendKeys("Laptop");
			newProject.get(1).sendKeys("Asus");
		}
	  
  }
  @Test(priority=2,invocationCount=5)
  public void EnterTask() {
	  driver.findElement(By.cssSelector("input[placeholder='Enter task name']")).sendKeys("Automation Practice11");
		driver.findElement(By.cssSelector("tbody>tr:nth-child(1) > td.billingTypeCell > div.typeOfWorkButton.editable > div")).click();
		driver.findElement(By.cssSelector("div.dropdownContainer.components_typeOfWorkMenu.typeOfWorkEditorMenu.addNewTasks>div>div>div>div>div:nth-of-type(11)")).click();

  }
  @Test(priority=3)
  public void clickCreateTask() throws InterruptedException {
	  Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".basicLightboxFooter>div:nth-child(2)>.commitButtonPlaceHolder>div>div:nth-child(1)")));

		WebElement task=driver.findElement(By.cssSelector(".basicLightboxFooter>div:nth-child(2)>.commitButtonPlaceHolder>div>div:nth-child(1)"));
		task.click();  
	  
  }
  
}
