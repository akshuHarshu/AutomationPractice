package automationTestingWebApp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutomationTesting {

	public static void main(String[] args) {
		WebDriver driver = setUp("chrome","https://demo.automationtesting.in/Register.html\r\n");
		List<WebElement> autoList = driver.findElements(By.cssSelector(".navbar-nav>li>a"));
		System.out.println("Count:"+autoList.size());
		for(int i =0;i<autoList.size();i++) {
			System.out.println(autoList.get(i).getText());
		}
		

	}
	
	public static WebDriver setUp(String browsername, String Url) {
		WebDriver driver = null;
		if(browsername.equalsIgnoreCase("chrome")){
		driver = new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(Url);
		return driver;
	}

}
