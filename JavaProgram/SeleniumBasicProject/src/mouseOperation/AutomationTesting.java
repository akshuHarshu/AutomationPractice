package mouseOperation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.SeleniumUtil;

public class AutomationTesting {

	public static void main(String[] args) {
WebDriver driver=SeleniumUtil.setUp("chrome", "https://demo.automationtesting.in/Register.html");
		
		Actions action=new Actions(driver);
		WebElement firstName=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstName.sendKeys("Pune");
		action.moveToElement(firstName).doubleClick().perform();
		action.keyDown(Keys.CONTROL).sendKeys("c");
		action.keyUp(Keys.CONTROL).build().perform();
		
		WebElement lastName=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		lastName.click();
		action.moveToElement(lastName).keyDown(Keys.CONTROL);
		action.sendKeys("v");
		action.keyUp(Keys.CONTROL).build().perform();
	}

}
