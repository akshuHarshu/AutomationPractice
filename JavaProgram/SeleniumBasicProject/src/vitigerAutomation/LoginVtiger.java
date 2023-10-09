package vitigerAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginVtiger {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");
		WebElement usr = driver.findElement(By.id("username"));
		usr.clear();
		usr.sendKeys("Admin");
		WebElement pass = driver.findElement(By.id("password"));
		pass.clear();
		pass.sendKeys("admin");
		//driver.findElement(By.className("buttonBlue")).click();
		//driver.findElement(By.cssSelector(".buttonBlue")).click();
		//driver.findElement(By.cssSelector("button[class='button buttonBlue']")).click();
		//driver.findElement(By.cssSelector("form>div:nth-of-type(3)>button")).click();
		driver.findElement(By.cssSelector("form button")).click();
		String homeTitle = driver.getTitle();
		String expectHomeTitle = "Dashboard";
		System.out.println("is actual home title equal to expected home title :"+homeTitle.equals(expectHomeTitle));
		driver.findElement(By.className("fa-user")).click();
		driver.findElement(By.id("menubar_item_right_LBL_SIGN_OUT")).click();
		String loginTitle = driver.getTitle();
		String expectLoginTitle = "vtiger";
		System.out.println("is actual title of login page equal to expected title of login page:"+loginTitle.equals(expectLoginTitle));
		driver.close(); 
	}

}
