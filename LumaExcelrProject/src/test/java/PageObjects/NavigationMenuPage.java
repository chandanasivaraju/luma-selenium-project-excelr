package PageObjects;

import java.awt.AWTException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationMenuPage 
{

	WebDriver driver;

	public NavigationMenuPage (WebDriver idriver) 
	{
		this.driver = idriver;
	}

	/*
	 * TC-14-Hovering on each category on the main menu of the home page and
	 * clicking on each of them to check if it is navigating to the correct detailed
	 * pages
	 */
	
	public void navigationLinksHover() throws InterruptedException, AWTException
	{
	   // List<WebElement> links = driver.findElements(By.xpath("//div[@id='store.menu']/child::nav/child::ul/child::li/child::a"));
		List<WebElement> links = driver.findElements(By.xpath("//nav/ul/li"));
		System.out.println(links.size());
		Actions action = new Actions(driver);

		for(int i=0; i<links.size(); i++) 
		{
			action.moveToElement(links.get(i)).perform();
			Thread.sleep(2000); 
		}
	}
	public void navigationLinksClick() throws InterruptedException 
	{
		Thread.sleep(2000);
		List<WebElement> links1 = driver.findElements(By.xpath("//nav/ul/li/child::a"));
		
		for(int i=0; i<links1.size(); i++) 
		{
			WebElement link = links1.get(i);
			System.out.println(link.getText());
			link.click();
			Thread.sleep(1000); 
			links1 = driver.findElements(By.xpath("//nav/ul/li/child::a"));
			
		}
	}
}


