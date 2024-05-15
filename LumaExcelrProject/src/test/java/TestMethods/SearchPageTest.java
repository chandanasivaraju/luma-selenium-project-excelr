package TestMethods;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import PageObjects.SearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchPageTest 
{


	WebDriver driver;
	@BeforeTest
	public void beforeTestMethod() throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test (priority=1)
	public void testMethod() throws InterruptedException, IOException
	{
		
		HomePage hp = new HomePage(driver);
		hp.LaunchURL();
		
		SearchPage sp = new SearchPage(driver);	 
		sp.validSearch("Bag");
		
		WebElement successmessage = driver.findElement(By.xpath("//div[@class='columns']"));
		String actualmessage = successmessage.getText();
		System.out.println("VALID PRODUCT DETAILS: ");
		System.out.println(actualmessage);
		
		System.out.println("****************************************************************************************");
	}
	
	
	@Test (priority=2)
	public void testMethod2() throws InterruptedException, IOException
	{
		
		HomePage hp = new HomePage(driver);
		hp.LaunchURL();
		
		SearchPage sp = new SearchPage(driver);	 
		sp.invalidSearch("Bags");
		
		WebElement errormessage = driver.findElement(By.xpath("//div[@class='message notice']"));
		String actualmessage = errormessage.getText();
		System.out.println("INVALID PRODUCT DETAILS: ");
		System.out.println(actualmessage);
	}
	
	@AfterTest
	public void afterTestMethod()
	{   
		driver.close();
	}
}
