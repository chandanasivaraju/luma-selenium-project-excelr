package TestMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.LogoutPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LogoutPageTest 
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
		
		LoginPage lp = new LoginPage(driver);
		lp.signIn();
		lp.emailID("smith@gmail.com");
		lp.password("smith@123");
		lp.signInButton();
		
		LogoutPage lop = new LogoutPage(driver);
		lop.logout();
	}
	
	@AfterTest
	public void afterTestMethod()
	{   
		driver.close();
	}
}
