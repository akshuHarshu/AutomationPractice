package actitimeAutomation;

import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateTitleActitime {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/");
		String actualTitle = driver.getTitle();
		System.out.println("Title-->"+actualTitle);
		System.out.println("Lenght of title-->"+actualTitle.length());
		String actualCurrentUrl = driver.getCurrentUrl();
		System.out.println("Current url-->"+actualCurrentUrl);
		System.out.println("Length of current url-->"+actualCurrentUrl.length());
		String expectTitle = "actiTIME - Login";
        System.out.println("is actual title equal to expected titile:"+actualTitle.equals(expectTitle));
        String expectCurrentUrl = "https://demo.actitime.com/login.do";
        System.out.println("is actual current url equal to expected current url:"+actualCurrentUrl.equals(expectCurrentUrl));
        driver.close();
        }

}
