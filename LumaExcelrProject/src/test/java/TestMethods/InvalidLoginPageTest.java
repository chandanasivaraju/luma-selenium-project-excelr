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
import PageObjects.InvalidLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InvalidLoginPageTest 
{

	WebDriver driver;
	@BeforeTest
	public void beforeTestMethod() throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void testMethod() throws InterruptedException, IOException
	{
		HomePage hp = new HomePage(driver);
		hp.LaunchURL();

		InvalidLoginPage invalid = new InvalidLoginPage(driver);
		invalid.invalidLogin();
	}
	@Test(priority=2)
	public void errormessage() throws InterruptedException
	{
		WebElement errormessage = driver.findElement(By.xpath("//div[contains(@data-bind, 'html: $parent.prepareMessageForHtml(message.text)')]"));
		Thread.sleep(2000);
		String actualmessage = errormessage.getText();
		String expectedmessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
		
		if(actualmessage.equals(expectedmessage))
		{
			System.out.println("Error Message: " +actualmessage);
		}
		if (!actualmessage.contains("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.")) {
            // If the condition for verifying the success message fails, fail the test case
            Assert.fail("Success message verification failed. Actual message: " + actualmessage);
        }
	}
	@AfterTest
	public void afterTestMethod()
	{   
		driver.close();
	}

}
