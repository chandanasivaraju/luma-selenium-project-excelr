package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage 
{
	WebDriver driver;
	
	By searchbox = By.xpath("//input[@id='search']");
	By searchbutton = By.xpath("(//button[@type='submit'])[1]");

	
	public SearchPage(WebDriver idriver)
	{
		this.driver=idriver;
	}

	//TC-19-Searching and checking if the results display valid product details after searching for a valid product
	public void validSearch(String valid) throws InterruptedException
	{
		driver.findElement(searchbox).sendKeys(valid);
		Thread.sleep(1000);
		driver.findElement(searchbutton).click();
		Thread.sleep(1000);
	}
	//TC-20-Searching and checking if the results doesn't display any details after searching for an invalid product
	public void invalidSearch(String invalid) throws InterruptedException
	{
		driver.findElement(searchbox).clear();
		driver.findElement(searchbox).sendKeys(invalid);
		Thread.sleep(1000);
		driver.findElement(searchbutton).click();
		Thread.sleep(1000);
		
		
	}
}
