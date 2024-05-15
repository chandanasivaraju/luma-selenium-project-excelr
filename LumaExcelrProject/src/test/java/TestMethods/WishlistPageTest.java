package TestMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CheckoutPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.LogoutPage;
import PageObjects.WishlistPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WishlistPageTest 
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
		lp.emailID("smith@gmail.com");
		lp.password("smith@123");
		lp.signInButton();
	
		WishlistPage wp = new WishlistPage(driver);
		wp.addProductToWishlist();
		
		LogoutPage lop = new LogoutPage(driver);
		lop.logout();
		
	}
	
	@Test(priority=2)
	public void testMethod2() throws InterruptedException
	{
		
		HomePage hp = new HomePage(driver);
		hp.LaunchURL();
		
		LoginPage lp = new LoginPage(driver);
		lp.signIn();
		lp.emailID("smith@gmail.com");
		lp.password("smith@123");
		lp.signInButton();
	
		WishlistPage wp = new WishlistPage(driver);
		wp.addProductToCart();
		
		LogoutPage lop = new LogoutPage(driver);
		lop.logout();
	}
	
	@Test(priority=3)
	public void testMethod3() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.LaunchURL();
		
		LoginPage lp = new LoginPage(driver);
		lp.signIn();
		lp.emailID("smith@gmail.com");
		lp.password("smith@123");
		lp.signInButton();
		
		WishlistPage wp = new WishlistPage(driver);
		wp.addProductToWishlist();
		wp.removeProductFromWishlist();
			
	}
	
	  @Test(priority=4) public void successmessage() throws InterruptedException 
	  {
	  WebElement successmessage = driver.findElement(By.xpath("//div[contains(@data-bind, 'html: $parent.prepareMessageForHtml(message.text)')]"));
	  Thread.sleep(2000); String actualmessage = successmessage.getText();
	  String expectedmessage="Neve Studio Dance Jacket has been removed from your Wish List.";
	  if(actualmessage.equals(expectedmessage)) 
	  {
	  System.out.println("Successful Message: " +actualmessage); 
	  } 
	  if(!actualmessage.contains("Neve Studio Dance Jacket has been removed from your Wish List."))
	  {
	  // If the condition for verifying the success message fails, fail the testcase
		  Assert.fail("Success message verification failed. Actual message: " +actualmessage); 
		  } 
	  }
	 

	@AfterTest
	public void afterTestMethod()
	{   
		driver.close();
	}

}
