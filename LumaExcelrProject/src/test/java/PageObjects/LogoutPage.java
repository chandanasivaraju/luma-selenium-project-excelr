package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage 
{

	WebDriver driver;
	
	By dropdown = By.xpath("(//button[@type='button'])[1]");
	By logout = By.xpath("(//li[@class='authorization-link'])[1]");
	
	
	public LogoutPage(WebDriver idriver)
	{
		this.driver = idriver;
	}
	
	//TC-13-Successful logout of the user
	public void logout() throws InterruptedException
	{
		driver.findElement(dropdown).click();
		Thread.sleep(1000);
		driver.findElement(logout).click();
		Thread.sleep(1000);
	}
}
