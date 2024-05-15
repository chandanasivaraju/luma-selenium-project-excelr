package TestMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.LogoutPage;
import PageObjects.ReviewPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ReviewPageTest 
{

	WebDriver driver;
	@BeforeTest
	public void beforeTestMethod() throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test (priority =1)
	public void testMethod() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.LaunchURL();
		
		ReviewPage rp = new ReviewPage(driver);
		rp.addReview("johny", "product review", "good");
	}
	
	@AfterTest
	public void afterTestMethod()
	{   
		driver.close();
	}
}
