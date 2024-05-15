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
import PageObjects.LoginPage;
import PageObjects.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest 
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
	public void testMethod() throws InterruptedException, IOException
	{
		
		HomePage hp = new HomePage(driver);
		hp.LaunchURL();
		
		LoginPage lp = new LoginPage(driver);
		lp.signIn();
		lp.emailID("smith@gmail.com");
		lp.password("smith@123");
		lp.signInButton();
	}

	@AfterTest
	public void afterTestMethod() throws InterruptedException
	{   
		Thread.sleep(2000);
		driver.close();
	}
}
