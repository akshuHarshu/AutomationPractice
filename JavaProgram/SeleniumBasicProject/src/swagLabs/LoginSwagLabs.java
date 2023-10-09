package swagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSwagLabs {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		String actualCurrentUrl = driver.getCurrentUrl();
		System.out.println("current Url:-"+actualCurrentUrl);
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		System.out.println("is actual url equal to expected url:"+actualCurrentUrl.equals(expectedUrl));
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		String actualTitle = driver.getTitle();
		System.out.println("Actual title:"+actualTitle);
		String expectTitle = "Swag Labs";
		System.out.println("is actual title is equal to expected title:"+actualTitle.equals(expectTitle));
	}

}
