package testdatafromPropertyFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.SeleniumUtil;

public class ActitimeLoginandLogoutProperty {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(".\\testData\\AppData.properties");
		Properties pos = new Properties();
		pos.load(fis);
		String browserName = pos.getProperty("browser");
		String url = pos.getProperty("appUrl");
		String username = pos.getProperty("username");
		String password = pos.getProperty("password");
		//String expectTitle = pos.getProperty("expectHomeTitle");
		WebDriver driver = SeleniumUtil.setUp(browserName, url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);//this element will get 0-30 sec for identification
		driver.findElement(By.id("loginButton")).click();//this element will get 0-30 sec for identification
		
		String expectedHomePageTitle=pos.getProperty("expectHomeTitle");
		
		//explicit wait
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.titleIs(expectedHomePageTitle));
					//or
		wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLink")));
		
		String actualHomePageTitle=driver.getTitle();
		System.out.println("Home page Acutal Title: "+actualHomePageTitle);
		System.out.println("Home page Expected Title: "+expectedHomePageTitle);
		System.out.println("Is login successfull? "+actualHomePageTitle.equals(expectedHomePageTitle));
		
		
		driver.findElement(By.id("logoutLink")).click();//this element will get 0-30 sec for identification
			
		/*String expectedLoginPageTitle=pos.getProperty("expectedLoginPageTitle");
		wait.until(ExpectedConditions.titleIs(expectedLoginPageTitle));
		String actualLoginPageTitle=driver.getTitle();
		System.out.println("is logout done sccuessfully? "+actualLoginPageTitle.equals(expectedLoginPageTitle));
		*/
		//driver.close();
		

	}

}
