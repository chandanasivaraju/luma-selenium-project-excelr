package TestMethods;

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
import PageObjects.UpdateAccountPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateAcountPageTest 
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
		
		LoginPage lp = new LoginPage(driver);
		lp.signIn();
		lp.emailID("kiran@gmail.com");
		lp.password("kiran@123");
		lp.signInButton();
		
		//first time execution runs smooth and gets the expected result
		//This input data/test data should be changed every time when it is executing second time onwards
		UpdateAccountPage uap = new UpdateAccountPage(driver);
		uap.updateAccount();
		uap.editFirstName("kiran");
		uap.editLastName("rao");
		uap.changeEmail();
		uap.changePassword();
		uap.editEmail("kiran@gmail.com");
		uap.currentPassword("kiran@123");
		uap.newPassword("kiran@123");
		uap.confirmPassword("kiran@123");
		uap.save();
	}
	
	@Test (priority=2)
	public void successmessage() throws InterruptedException
	{
		WebElement successmessage = driver.findElement(By.xpath("//div[contains(@data-bind, 'html: $parent.prepareMessageForHtml(message.text)')]"));
		Thread.sleep(2000);
		String actualmessage = successmessage.getText();
		String expectedmessage = "You saved the account information.";
		
		if(actualmessage.equals(expectedmessage))
		{
			System.out.println("Successful Message: " +actualmessage);
		}
		if (!actualmessage.contains("You saved the account information.")) {
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
