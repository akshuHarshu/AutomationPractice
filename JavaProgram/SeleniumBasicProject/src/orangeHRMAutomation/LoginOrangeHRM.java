package orangeHRMAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginOrangeHRM {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		
		driver.manage().window().setSize(new Dimension(500,600));
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement usr = driver.findElement(By.name("username"));
		usr.sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123"); 
		driver.findElement(By.cssSelector(".oxd-button")).click();
		driver.findElement(By.className("oxd-userdropdown-tab")).click();
		String expectHomeUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));//explicit wait 
		wait.until(ExpectedConditions.urlToBe(expectHomeUrl));
		
		String homeUrl = driver.getCurrentUrl();
		System.out.println("is actual home Url equals to expected Url:"+homeUrl.equals(expectHomeUrl));
		driver.findElement(By.linkText("Logout")).click();
		String  expectTitle = "OrangeHRM";
		Wait<WebDriver> wait1=new FluentWait<WebDriver>(driver)//fluent wait
				.withTimeout(Duration.ofSeconds(20)) //total time
				.pollingEvery(Duration.ofSeconds(5)) //retry time
				.ignoring(NoSuchElementException.class);//by pass exception if it comes
	//wait.until(ExpectedConditions.titleIs(expectedHomePageTitle));
		wait1.until(ExpectedConditions.titleIs(expectTitle));
		String actualTitle = driver.getTitle();
		System.out.println("is actual title equals to expected title:"+actualTitle.equals(actualTitle));
        driver.navigate().to("https://www.google.com");
        driver.navigate().back();
         driver.navigate().forward();
        driver.navigate().refresh();
	}

}
