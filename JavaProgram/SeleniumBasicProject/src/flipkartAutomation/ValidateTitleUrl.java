package flipkartAutomation;

import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateTitleUrl {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		String actualTitle = driver.getTitle();
		System.out.println("Title-->"+actualTitle);
		System.out.println("Lenght of title-->"+actualTitle.length());
		String actualCurrentUrl = driver.getCurrentUrl();
		System.out.println("Current url-->"+actualCurrentUrl);
		System.out.println("Length of current url-->"+actualCurrentUrl.length());
		String expectTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
        System.out.println("is actual title equal to expected titile:"+actualTitle.equals(expectTitle));
        String expectCurrentUrl = "https://www.flipkart.com/";
        System.out.println("is actual current url equal to expected current url:"+actualCurrentUrl.equals(expectCurrentUrl));
        driver.close();

	}

}
