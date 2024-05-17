package TestMethods;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.UpdateProductQtyPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckoutPageTest 
{
	WebDriver driver;
	@BeforeTest
	public void beforeTestMethod() throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test (priority =1, enabled=true)
	public void testMethod() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.LaunchURL();

		LoginPage lp = new LoginPage(driver);
		lp.signIn();
		lp.emailID("smith@gmail.com");
		lp.password("smith@123");
		lp.signInButton();

		CheckoutPage cp = new CheckoutPage(driver);
		cp.checkOut();


		WebElement successmessage = driver.findElement(By.xpath("(//div[@class='step-title'])[1]"));
		String actualmessage = successmessage.getText();
		System.out.println("After Checkout: " +actualmessage);
	}

	@Test(enabled=true, dependsOnMethods="testMethod")
	public void purchaseOrder() throws InterruptedException
	{
		CheckoutPage cp = new CheckoutPage(driver);
		cp.orderPurchase("Street-8", "Hyderabad", "500029", "7788994455");
	}
	

	@Test(priority=2, enabled=true, dependsOnMethods="testMethod")
	public void purchaseOrder2() throws InterruptedException
	{
		CheckoutPage cp = new CheckoutPage(driver);
		cp.secondTimeOrderPurchase();
	}
	
	@Test(priority=3, enabled = true)
	public void orderStatusPage() throws InterruptedException, IOException
	{
		HomePage hp = new HomePage(driver);
		hp.LaunchURL();

		LoginPage lp = new LoginPage(driver);
		lp.signIn();
		lp.emailID("smith@gmail.com");
		lp.password("smith@123");
		lp.signInButton();
		
		CheckoutPage cp = new CheckoutPage(driver);
		cp.orderStatusPage();
	}


	@AfterTest
	public void afterTestMethod()
	{   
		driver.close();
	}

}
