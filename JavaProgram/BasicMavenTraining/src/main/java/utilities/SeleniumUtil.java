package utilities;


	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import io.github.bonigarcia.wdm.WebDriverManager;


	public class SeleniumUtil {
		public static WebDriver driver;
		public static WebDriverWait wait;
		public static Properties prop;
		public static Actions action;

		public  WebDriver setUp(String browserName, String appUrl) {
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("ie")) {
				driver = new InternetExplorerDriver();
			}
			// implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			// maximize browser window
			driver.manage().window().maximize();
			// Define WebDriverWait
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			// enter the required URL
			driver.get(appUrl);
			action = new Actions(driver);
			return driver;
		}
		
		public  String getApplicationUrl() {
			return driver.getCurrentUrl();
		}

		public  void typeInput(WebElement element, String input) {
			waitUntilElementIsVisible(element);
			element.clear();
			element.sendKeys(input);
		}

		public  void clickOnElement(WebElement element) {
			waitUntilElementClickable(element);
			element.click();
		}

		public  void waitUntilTextToBeMatched(By element, String text) {
			wait.until(ExpectedConditions.textToBe(element, text));
		}

		public  void waitUntilElementClickable(WebElement element) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}

		public  void waitUntilPageTitleMatched(String title) {
			wait.until(ExpectedConditions.titleIs(title));
		}

		public  void waitUntilElementIsVisible(WebElement element) {
			wait.until(ExpectedConditions.visibilityOf(element));
		}

		public  void loadPropertyFile(String filePath) {
			FileInputStream fis;
			try {
				fis = new FileInputStream(filePath);
				prop = new Properties();
				prop.load(fis);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		public  String getDataFromPropertyFile(String key) {
			return prop.getProperty(key);
		}
		 
		public  String getCurrentPageTitle(String title) {
			wait.until(ExpectedConditions.titleContains(title));
			return driver.getTitle();
		}
		
		public  String getCurrentPageTitle() {
			return driver.getTitle();
		}

		public  String getAttributeForElement(WebElement element, String attributeName) {
			waitUntilElementIsVisible(element);
			return element.getAttribute(attributeName);
		}

		public  String getTextForElement(WebElement element) {
			waitUntilElementIsVisible(element);
			return element.getText();
		}

		public  Select getDropdown(WebElement element) {
			waitUntilElementIsVisible(element);
			return new Select(element);
		}

		public  String getTextFromDropdown(Select select) {
			return select.getFirstSelectedOption().getText();
		}

		public  void mouseHoverOverInTheElement(Actions act, WebElement element) {
			act.moveToElement(element).perform();
		}

		public  void rightClick(Actions action, WebElement option) {
			action.moveToElement(option).contextClick().build().perform();
		}

		public  void mouseHoverWithCords(Actions act, WebElement option, int x, int y) {
			act.moveToElement(option, x, y).perform();
		}

		public  void performDranAndDrop(Actions act, WebElement src, WebElement target) {
			waitUntilElementIsVisible(src);
			waitUntilElementIsVisible(target);
			act.dragAndDrop(src, target).build().perform();
		}

		public  void copyTextFromElement(WebElement element) {
			action.doubleClick(element).sendKeys(Keys.chord(Keys.CONTROL, "c")).perform();
		}

		public  void pasteCopiedTextIntoElement(WebElement element) {
			action.moveToElement(element).sendKeys(Keys.chord(Keys.CONTROL, "v")).perform();
		}

		public  void copyAndPasteText(WebElement copyFrom, WebElement copyTo) {
			copyTextFromElement(copyFrom);
			pasteCopiedTextIntoElement(copyTo);
		}

		public  void takeScreenShot(String location) {
			// type cast WebDriver instance into TakesScreenshot interface
			TakesScreenshot ts = (TakesScreenshot) driver;
			// get screenshot using getScreenshotAs() of TakesScreenshot interface
			File file = ts.getScreenshotAs(OutputType.FILE);
			// store above screenshot into required location
			try {
				FileUtils.copyFile(file, new File(location));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public  WebElement getActiveElementFromScreen() {
			return driver.switchTo().activeElement();
		}
	}

