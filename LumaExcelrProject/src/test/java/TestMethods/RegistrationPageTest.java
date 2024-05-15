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
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationPageTest {

	WebDriver driver;

	@BeforeTest
	public void beforeTestMethod() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void testMethod() throws InterruptedException, IOException {
		/*
		 * This can be executed once as I have given the user registration details
		 * different from the login details in other scenarios.
		 * 
		 * first time execution runs smooth and gets the expected result 
		 * This input data/test data should be changed every time when it is executing from the second time onwards
		 */ 
		RegistrationPage rp = new RegistrationPage(driver);
		rp.launchURL();
		rp.createAccount();
		rp.firstName("James");
		rp.lastName("William");
		rp.email("james@gmail.com");
		rp.password("Williamj@123");
		rp.confirmPassword("Williamj@123");
		rp.createAccountButton();
	}

	@Test(priority = 2)
	public void successmessage() throws InterruptedException {
		WebElement successmessage = driver.findElement(
				By.xpath("//div[contains(@data-bind, 'html: $parent.prepareMessageForHtml(message.text)')]"));
		Thread.sleep(2000);
		String actualmessage = successmessage.getText();
		String expectedmessage = "Thank you for registering with Main Website Store.";

		if (actualmessage.equals(expectedmessage)) {
			System.out.println("Successful Message: " + actualmessage);
		}
		if (!actualmessage.contains("Thank you for registering with Main Website Store.")) {
			// If the condition for verifying the success message fails, fail the test case
			Assert.fail("Success message verification failed. Actual message: " + actualmessage);
		}
	}

	@AfterTest
	public void afterTestMethod() {
		driver.close();
	}
}
