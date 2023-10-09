package amazonAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAmazon {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		WebElement us = driver.findElement(By.id("ap_email"));
		us.sendKeys("9423913433");
		driver.findElement(By.id("continue")).click();
		WebElement pass = driver.findElement(By.id("ap_password"));
		pass.sendKeys("Sandip@123");
		driver.findElement(By.id("signInSubmit")).click();
		String homeUrl = driver.getCurrentUrl();
		String expectUrl = "https://www.amazon.in/?ref_=nav_ya_signin";
		System.out.println("is home url equals to expexted url:"+homeUrl.equals(expectUrl));
		driver.findElement(By.className("nav-text")).click();
	}

}
