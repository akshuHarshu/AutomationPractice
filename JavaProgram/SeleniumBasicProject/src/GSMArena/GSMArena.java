package GSMArena;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import openbrowser.FireFoxBrowser;

public class GSMArena {

	public static void main(String[] args) {
		WebDriver driver = setUp("Chrome","https://www.gsmarena.com/");
		List<WebElement> mobileList = driver.findElements(By.cssSelector(".brandmenu-v2 li>a"));
		int mobListSize = mobileList.size();
		System.out.println(mobListSize);
		for(int i= 0;i<mobListSize;i++) {
		System.out.println(mobileList.get(i).getText());
		}
		}
		
	public static WebDriver setUp(String browserName,String Url) {
		WebDriver driver = null;
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get(Url);
		return driver;
		
	}
}
