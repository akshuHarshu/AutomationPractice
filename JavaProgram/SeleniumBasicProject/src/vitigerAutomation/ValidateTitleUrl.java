package vitigerAutomation;

import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateTitleUrl {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");
		String actualTitle = driver.getTitle();
		System.out.println("Title-->"+actualTitle);
		System.out.println("Lenght of title-->"+actualTitle.length());
		String actualCurrentUrl = driver.getCurrentUrl();
		System.out.println("Current url-->"+actualCurrentUrl);
		System.out.println("Length of current url-->"+actualCurrentUrl.length());
		String expectTitle = "vtiger";
        System.out.println("is actual title equal to expected titile:"+actualTitle.equals(expectTitle));
        String expectCurrentUrl = "https://demo.vtiger.com/vtigercrm/index.php";
        System.out.println("is actual current url equal to expected current url:"+actualCurrentUrl.equals(expectCurrentUrl));
        driver.close();

	}

}
