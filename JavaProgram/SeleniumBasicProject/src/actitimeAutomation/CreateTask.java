package actitimeAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.SeleniumUtil;

public class CreateTask {

	public static void main(String[] args) throws IOException, InterruptedException  {
		FileInputStream fis = new FileInputStream(".\\testData\\AppData.properties");
		Properties pos = new Properties();
		pos.load(fis);
		String browserName = pos.getProperty("browser");
		String url = pos.getProperty("appUrl");
		
		String username = pos.getProperty("username");
		String password = pos.getProperty("password");
		//String expectTitle = pos.getProperty("expectHomeTitle");
		WebDriver driver = SeleniumUtil.setUp(browserName, url);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
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
		/*
		List<WebElement> enterTask = driver.findElements(By.cssSelector(".nameCell.first>.inputFieldWithPlaceholder"));
		enterTask.get(0).sendKeys("Testing");
		//List<WebElement> typeWork = driver.findElements(By.cssSelector(".billingTypeCell .value.ellipsis"));
		//typeWork.get(0).click();
	    // driver.findElement(By.xpath("//div[text()='Create Tasks']")).click();;
		driver.findElement(By.cssSelector(".basicLightboxFooter>div:nth-child(2)>.commitButtonPlaceHolder>div>div:nth-child(1)")).click();
		//ceateTask.get(4).click();
		*/
		
		
		driver.findElement(By.cssSelector("input[placeholder='Enter task name']")).sendKeys("Automation Practice11");
		driver.findElement(By.cssSelector("tbody>tr:nth-child(1) > td.billingTypeCell > div.typeOfWorkButton.editable > div")).click();
		driver.findElement(By.cssSelector("div.dropdownContainer.components_typeOfWorkMenu.typeOfWorkEditorMenu.addNewTasks>div>div>div>div>div:nth-of-type(11)")).click();

	
		//Actions at = new Actions(driver);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".basicLightboxFooter>div:nth-child(2)>.commitButtonPlaceHolder>div>div:nth-child(1)")));

		WebElement task=driver.findElement(By.cssSelector(".basicLightboxFooter>div:nth-child(2)>.commitButtonPlaceHolder>div>div:nth-child(1)"));
		task.click();  
		//at.moveToElement(task).click().build().perform();
		//driver.findElement(By.cssSelector("#createTasksPopup_content >.basicLightboxFooter >.buttonsBox >.commitButtonPlaceHolder > div")).click();
		System.out.println("Succusefully Task Created........");
	}

}
