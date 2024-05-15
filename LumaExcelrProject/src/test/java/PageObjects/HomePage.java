package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage 
{
    //create a constructor which helps in doing certain operations
    //Once the instance is created, whatever there in the constructor will start executing

    WebDriver driver;
	public HomePage(WebDriver idriver)
	{
		this.driver = idriver;
	}
	
	//TC-8-Verify that the homepage loads successfully by launching the valid URL
	public void LaunchURL() throws InterruptedException
	{
	    driver.get("https://magento.softwaretestingboard.com/");
	    Thread.sleep(2000); 
	}
	
	public void conditionCheck() throws InterruptedException
	{
	  String actualpagetitle = driver.getTitle();
      String expectedpagetitle = "Home Page";
		
		if(actualpagetitle.equals(expectedpagetitle))
		{
			System.out.println("Page loaded and the title of the homepage is: " +actualpagetitle);
		}
		else
		{
			System.out.println("Page not loaded");
		}
	}
}
