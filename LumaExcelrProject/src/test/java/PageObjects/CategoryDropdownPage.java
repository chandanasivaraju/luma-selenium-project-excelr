package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CategoryDropdownPage 

{

	WebDriver driver;
	public CategoryDropdownPage(WebDriver idriver)
    {
		this.driver = idriver;
	}

	//TC-4-Selecting on one particular product from the category drop down menu on the home page
	public void dropdown() throws InterruptedException
	{
		List<WebElement> gearlink = driver.findElements(By.xpath("//a[@id='ui-id-6']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(gearlink.get(0)).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='ui-id-27']")).click();
		Thread.sleep(2000);

	}
}

