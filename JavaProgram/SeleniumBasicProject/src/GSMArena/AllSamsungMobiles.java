package GSMArena;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class  AllSamsungMobiles {

	public static void main(String[] args) {
		WebDriver driver = setUp("chrome","https://www.gsmarena.com/samsung-phones-9.php");
		List<WebElement> samsMobile = driver.findElements(By.cssSelector(".makers>ul strong"));
		int samsList = samsMobile.size();
		System.out.println(samsList);
		for(int i = 0;i<samsMobile.size();i++) {
			 System.out.println(samsMobile.get(i).getText());
		}
	}
	public static WebDriver setUp(String browserName, String Url) {
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
