package openbrowser;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "E:\\Software Testing Class\\Workplace\\SeleniumBasicProject\\drivers\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();

	}

}
