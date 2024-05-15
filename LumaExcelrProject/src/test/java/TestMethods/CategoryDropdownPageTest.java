package TestMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CategoryDropdownPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.UpdateAccountPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CategoryDropdownPageTest 
{
	WebDriver driver;
	@BeforeTest
	public void beforeTestMethod() throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test 
	public void testMethod() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.LaunchURL();
		
		CategoryDropdownPage cdp = new CategoryDropdownPage(driver);
		cdp.dropdown();
	}
	
	
	@AfterTest
	public void afterTestMethod()
	{   
		driver.close();
	}

}
