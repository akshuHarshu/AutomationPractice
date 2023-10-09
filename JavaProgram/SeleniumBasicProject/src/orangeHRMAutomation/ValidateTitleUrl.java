package orangeHRMAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateTitleUrl {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String actualTitle = driver.getTitle();
		System.out.println("Title-->"+actualTitle);
		System.out.println("Lenght of title-->"+actualTitle.length());
		String actualCurrentUrl = driver.getCurrentUrl();
		System.out.println("Current url-->"+actualCurrentUrl);
		System.out.println("Length of current url-->"+actualCurrentUrl.length());
		String expectTitle = "OrangeHRM";
        System.out.println("is actual title equal to expected titile:"+actualTitle.equals(expectTitle));
        String expectCurrentUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        System.out.println("is actual current url equal to expected current url:"+actualCurrentUrl.equals(expectCurrentUrl));
        driver.close();


	}

}
