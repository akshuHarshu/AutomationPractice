package actitimeAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UiValidation {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		 driver.manage().window().maximize();
		 driver.manage().window().minimize();
		 driver.manage().window().setSize(new Dimension(900,800));
		 driver.get("https://demo.actitime.com/login.do");
		 WebElement usr = driver.findElement(By.id("username"));
		 System.out.println("userame is enable or not?:"+usr.isEnabled());
		 System.out.println("Username is display or not?:"+usr.isDisplayed());
		 System.out.println("Username is selected or not?:"+usr.isSelected());
		 System.out.println("Username field name: "+usr.getText());
		 System.out.println("Username field Attribute:"+usr.getAttribute("id"));
		 
		 WebElement pass = driver.findElement(By.name("pwd"));
		 System.out.println("Password is displayed or not?:"+pass.isDisplayed());
		 System.out.println("Password is enabled or not?:"+pass.isEnabled());
		 System.out.println("Password is selected or not?:"+pass.isSelected());
		 System.out.println("Password field name: "+pass.getText());
		 System.out.println("Password field Attribute:"+pass.getAttribute("name"));
		 
		 WebElement loginbtn = driver.findElement(By.className("initial"));
		 System.out.println("Login button displayed or not?:"+loginbtn.isDisplayed());
		 System.out.println("Login button enabled or not?:"+loginbtn.isEnabled());
		 System.out.println("Login button is selected or not?:"+loginbtn.isSelected());
		 
		 
		 System.out.println("Login text size:"+loginbtn.getCssValue("font-family"));
		 System.out.println("Login font size:"+loginbtn.getCssValue("font-size"));
		 System.out.println("Login color:"+loginbtn.getCssValue("color"));
		 System.out.println("Background clr:"+loginbtn.getCssValue("background"));
		 System.out.println("background image:"+loginbtn.getCssValue("background-image"));
		 
		 

	}

}
