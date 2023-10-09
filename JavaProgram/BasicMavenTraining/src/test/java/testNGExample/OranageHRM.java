package testNGExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtil;

public class OranageHRM extends SeleniumUtil {
  @BeforeTest
  public void openUrl() {
	  driver= setUp("chrome","https://opensource-demo.orangehrmlive.com/");
	  typeInput(driver.findElement(By.name("username")),"Admin");
	  typeInput(driver.findElement(By.name("password")),"admin123");
	  clickOnElement(driver.findElement(By.className("orangehrm-login-button")));
  }
  @BeforeMethod
  public void clickOnPIM() {
	  clickOnElement(driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[2]//span")));
  }
  @Test(priority=1)
  public void CreatePIM(){
	  clickOnElement(driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")));
	  typeInput(driver.findElement(By.name("firstName")),"Toshna");
	  typeInput(driver.findElement(By.name("lastName")),"Meha");
	  clickOnElement(driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")));
	  
  }
  @AfterMethod
  public void searchEmployee() {
	  clickOnElement(driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[2]//span")));
	  typeInput(driver.findElement(By.xpath("//form/div[1]/div/div[1]/div/div[2]/div/div/input")),"Akshara");
  	  clickOnElement(driver.findElement(By.xpath("//form/div[2]/button[2]")));
  }
  @Test(priority=2)
  public void editPIM() {
	  
	 //typeInput(driver.findElement(By.xpath("//form/div[1]/div/div[1]/div/div[2]/div/div/input")),"Toshna");
	 //clickOnElement(driver.findElement(By.xpath("//div/form/div[2]/button[2]")));
	 //clickOnElement(driver.findElement(By.xpath("//form/div[2]/button[2]")));
	 clickOnElement(driver.findElement(By.cssSelector(".oxd-icon.bi-pencil-fill")));
	 //clickOnElement(driver.findElement(By.xpath("//div[@class='card-header-slot']//div/button[2]")));
	  typeInput(driver.findElement(By.name("middleName")),"Sand");
	 
	 
	  //clickOnElement(driver.findElement(By.xpath("//form[@class='oxd-form']/div[5]/button")));
	  clickOnElement(driver.findElement(By.xpath("//form/div[2]/button")));
  }
  @Test(priority=3)
  public void deletePIM() {
	  //typeInput(driver.findElement(By.xpath("//form/div[1]/div/div[1]/div/div[2]/div/div/input")),"Toshna");
	  //clickOnElement(driver.findElement(By.xpath("//form/div[2]/button[2]")));
	  //clickOnElement(driver.findElement(By.xpath("//div[@class='card-header-slot']//div/button[1]")));
	  //clickOnElement(driver.findElement(By.xpath("//div[@class='orangehrm-modal-footer']/button[2]")));
	  
	  clickOnElement(driver.findElement(By.cssSelector(".oxd-icon-button.oxd-table-cell-action-space")));
		clickOnElement(driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-button-margin")));
  }
  @AfterTest
  public void closeDriver() {
	  driver.close();
  }
}


/*
 * https://www.saucedemo.com/inventory.html
1. login into application by fetching username and password from UI
2. add product into cart and keep there names for future validation
3. click on cart
4. validate product names with step-2
5. click on checkout
6. enter name and zipcode
7. click on continue button
8. click on finish
9. validate success msg
10. click on home button and validate home page
*/


/* git command
 * git config --global user.name "yourUserName"
		git config --global user.email "yourEmailID@example.com"
		*/

/*
 * https://github.com/QAAutomation-lab/15thJun2023
 * https://github.com/ShitalTule/AutomationTesting
 * https://github.com/
 * https://git-scm.com/
 */
