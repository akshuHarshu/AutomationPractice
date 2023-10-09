package erailApplication;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.SeleniumUtil;

public class ErailWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = SeleniumUtil.setUp("chrome", "https://erail.in/");
		String erailId = driver.getWindowHandle();
		System.out.println("Erail window id:"+erailId);
		driver.findElement(By.xpath("//a[text()='Tour Packages']")).click();
		Set<String> allWin = driver.getWindowHandles();
		System.out.println("All window"+allWin);
		allWin.remove(erailId);
		System.out.println("all Window id:"+allWin);
		
		
		String childWinId=allWin.iterator().next();
		System.out.println("Child window id: "+childWinId);
		
		driver.switchTo().window(childWinId);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.findElement(By.xpath("//div[2]/ul/li[2]/label/span")).click();
		List<WebElement> tourPackage = driver.findElements(By.cssSelector("div>div>:nth-child(2)>div>h5"));
		Thread.sleep(2000); 
		System.out.println("Print all places:"+tourPackage.size());
		List<WebElement> packagePrice = driver.findElements(By.cssSelector("div>div>:nth-child(3)>div>strong"));
		System.out.println("All Package price:"+packagePrice.size());
		for(int i=0;i<tourPackage.size();i++) {
			System.out.println(tourPackage.get(i).getText()+".  :"+packagePrice.get(i).getText());
			}
		/*for(int i =0;i<packagePrice.size();i++) {
			System.out.println(packagePrice.get(i).getText());
		}*/
		driver.switchTo().window(erailId);
		WebElement start= driver.findElement(By.xpath("//tbody/tr[2]/td/input[@placeholder='From Station']"));
		start.clear();
		start.sendKeys("Badnera Jn");
		WebElement To=driver.findElement(By.xpath("//tbody/tr[2]/td[3]/input[@placeholder='To Station']"));
		To.clear();
		To.sendKeys("Pune Jn");
		driver.findElement(By.xpath("//tbody/tr[2]/td[4]/input")).click();
		
		driver.findElement(By.xpath("//tbody/tr/td[2]/table/tbody/tr[4]/td[5]")).click();
		
		driver.findElement(By.xpath("//tbody/tr[1]/td[9]/input")).click();
		List<WebElement> trainName = driver.findElements(By.xpath("//div/div[2]/div[3]/div/div/table/tbody/tr/td[2]"));
		System.out.println(" All Trains name: "+trainName.size());
		List<WebElement> trainNo = driver.findElements(By.xpath("//div/div[2]/div[3]/div/div/table/tbody/tr/td[1]"));
		List<WebElement> trainFrom = driver.findElements(By.xpath("//div/div[2]/div[3]/div/div/table/tbody/tr/td[3]"));
		List<WebElement> trainDep = driver.findElements(By.xpath("//div/div[2]/div[3]/div/div/table/tbody/tr/td[4]"));
		System.out.println(trainDep.size());
		List<WebElement> trainTo = driver.findElements(By.xpath("//div/div[2]/div[3]/div/div/table/tbody/tr/td[6]"));
		List<WebElement> trainArraval = driver.findElements(By.xpath("//div/div[2]/div[3]/div/div/table/tbody/tr/td[7]"));
		for(int i=0;i<trainDep.size();i++) {
			System.out.println("Train Number:"+trainNo.get(i).getText()+"Train Name:"+trainName.get(i).getText()+"Train start from:"+trainFrom.get(i).getText()+"Dep. time:"+trainDep.get(i).getText()+"Train Last Station:"+trainTo.get(i).getText()+"Train Arrival:"+trainArraval.get(i).getText());
		}
	}

}
