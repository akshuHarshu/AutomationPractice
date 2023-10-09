package orangeHRMAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.SeleniumUtil;

public class CreatePIM {

	public static void main(String[] args) {
		WebDriver driver = SeleniumUtil.setUp("chrome", "https://opensource-demo.orangehrmlive.com/");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//login
		WebElement usr = driver.findElement(By.name("username"));
		usr.sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123"); 
		driver.findElement(By.cssSelector(".oxd-button")).click();
		//driver.findElement(By.className("oxd-userdropdown-tab")).click();
		//click on PIM
		driver.findElement(By.cssSelector("ul>li:nth-child(2)>a>span")).click();
		
		// click on Add button
		driver.findElement(By.cssSelector(".orangehrm-header-container>.oxd-button.oxd-button--medium.oxd-button--secondary")).click();
		
		//Enter Employee Name and Save 
		driver.findElement(By.name("firstName")).sendKeys("Akshara");
		driver.findElement(By.name("lastName")).sendKeys("Mehare");
		/*List<WebElement> empId = driver.findElements(By.cssSelector(".oxd-form-row div>div>div  .oxd-input.oxd-input--active"));
		empId.get(2).clear();
		empId.get(2).sendKeys("123");
		*/
		driver.findElement(By.cssSelector(".oxd-button--medium.oxd-button--secondary ")).click();
		/*List<WebElement> emp1 = driver.findElements(By.xpath("//input[@class ='oxd-input oxd-input--active']"));
		emp1.get(1).clear();
		*/
		//driver.findElement(By.cssSelector(".orangehrm-custom-fields .oxd-select-text-input")).click();
		/*driver.findElement(By.name("firstName")).sendKeys("Sandip");
		driver.findElement(By.cssSelector(".orangehrm-custom-fields .oxd-button--secondary")).click();
		*/
		
		//click on employee list
		driver.findElement(By.xpath("//div/header/div[2]/nav/ul/li[2]")).click();
		
		//Enter employee Name for search employee list
		driver.findElement(By.xpath("//div[1]/div/div[2]/div/div/input[@placeholder=\"Type for hints...\"]")).sendKeys("Mehare");
		
		//Click on Search button
		driver.findElement(By.xpath("//div/form/div[2]/button[2]")).click();
		
		//Click on edit Symbol
		driver.findElement(By.xpath("//div/div[3]//div/button[2]")).click();
		
		//Clear and enter empId
		WebElement empid1 = driver.findElement(By.xpath("//div/form/div[2]/div[1]/div[1]/div/div[2]/input"));
		empid1.clear();
		empid1.sendKeys("123");
		
		//Click on Save button after click update information
		WebElement empid = driver.findElement(By.xpath("//div/form/div[5]/button"));
		empid.click();
		//click employee list
		driver.findElement(By.xpath("//div/header/div[2]/nav/ul/li[2]")).click();
		
		//search employee
		driver.findElement(By.xpath("//div[1]/div/div[2]/div/div/input[@placeholder=\"Type for hints...\"]")).sendKeys("Mehare");
		driver.findElement(By.xpath("//div/form/div[2]/button[2]")).click();
		//Click on delete symbol
		driver.findElement(By.xpath("//div/div[3]//div/button[1]")).click();
		
		//Click on popup msg(yes,Delete)
		driver.findElement(By.xpath("//div/div/div/div[3]/button[2]")).click();
		
	}

}
