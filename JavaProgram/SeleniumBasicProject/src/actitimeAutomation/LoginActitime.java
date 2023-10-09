package actitimeAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginActitime {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//implicit wait
		driver.get("https://demo.actitime.com/");
		//driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.cssSelector("#username")).sendKeys("Admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.linkText("Login")).click();
		 
				String expectHomeTitle = "actiTIME - Enter Time-Track";
		//explicit wait
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));//explicit wait 
		//wait.until(ExpectedConditions.titleIs(expectHomeTitle));
					//or
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLink")));
				
		//fluent wait
				Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(20)) //total time
						.pollingEvery(Duration.ofSeconds(5)) //retry time
						.ignoring(NoSuchElementException.class);//by pass exception if it comes
			//wait.until(ExpectedConditions.titleIs(expectedHomeTitle));
						//or
			wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLink")));
		
		String homeTitle = driver.getTitle();
		System.out.println(homeTitle);
		System.out.println("is actual home title equals to expexted home title:"+homeTitle.equals(expectHomeTitle));
		driver.findElement(By.linkText("Logout")).click();
	}

}
