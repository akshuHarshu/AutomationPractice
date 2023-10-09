package switchToFrame;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import utility.SeleniumUtil;

public class JquerySwitchFrame {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = SeleniumUtil.setUp("chrome", "https://jqueryui.com/");
		
		 driver.findElement(By.xpath("//a[text()='Sortable']")).click();
		 
		driver.switchTo().frame(0);
		List<WebElement> items = driver.findElements(By.xpath("//ul[@id='sortable']/li"));
		System.out.println("Items count:"+items.size());
		for(int i=1;i<items.size();i++) {
			WebElement item = driver.findElement(By.xpath("((//ul[@id='sortable']/li)["+i+"])"));
			
			WebElement item1 = driver.findElement(By.xpath("((//ul[@id='sortable']/li)[1])"));
			WebElement item2 = driver.findElement(By.xpath("((//ul[@id='sortable']/li)[2])"));
			WebElement item3 = driver.findElement(By.xpath("((//ul[@id='sortable']/li)[3])"));
			WebElement item4 = driver.findElement(By.xpath("((//ul[@id='sortable']/li)[4])"));
			WebElement item5 = driver.findElement(By.xpath("((//ul[@id='sortable']/li)[5])"));
			WebElement item6 = driver.findElement(By.xpath("((//ul[@id='sortable']/li)[6])"));
			WebElement item7 = driver.findElement(By.xpath("((//ul[@id='sortable']/li)[7])"));
			Actions ac1 = new Actions(driver);
			if(item!=null) {
				ac1.dragAndDrop(item7, item).perform();
				ac1.dragAndDrop(item6, item).perform();
				ac1.dragAndDrop(item5, item).perform();
				ac1.dragAndDrop(item4, item).perform();
				ac1.dragAndDrop(item3, item).perform();
				ac1.dragAndDrop(item2, item).perform();
				ac1.dragAndDrop(item1, item).perform();
				break;
			}
		}
		/*
		driver.findElement(By.xpath("//a[text()='Sortable']")).click();
		List<WebElement> lists = driver.findElements(By.xpath("//ul[@id='sortable']/li"));
		// above list holds size of 7
		Actions a = new Actions(driver);
		WebElement lastEle = driver.findElement(By.xpath("//li[text()='Item " + lists.size() + "']"));
		
		for(int i=1;i<=lists.size();i++) {
		// Here, I don't want to drag last element i.e Item 7 as it will be on top at last. That is why I am not considering 7th element to drag
		    WebElement elementToDrag = driver.findElement(By.xpath("//li[text()='Item " + i + "']"));
		    a.clickAndHold(elementToDrag).dragAndDrop(elementToDrag, lastEle).build().perform();
		    Thread.sleep(1000);
		    */
		}
	}


