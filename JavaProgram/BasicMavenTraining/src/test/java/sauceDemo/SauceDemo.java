package sauceDemo;

import org.testng.annotations.Test;

import utilities.SeleniumUtil;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class SauceDemo extends SeleniumUtil {
  @Test
  public void f() {
  }
  @BeforeTest
  public void openUrl() {
	  driver = setUp("chrome","https://www.saucedemo.com/inventory.html");
	  Actions action = new Actions(driver);
	  WebElement copyUsername = driver.findElement(By.xpath("//div[text()='standard_user']"));
	  copyUsername.sendKeys("standard_user");
	  action.moveToElement(copyUsername).doubleClick().perform();
  }

  @AfterTest
  public void afterTest() {
  }

}
