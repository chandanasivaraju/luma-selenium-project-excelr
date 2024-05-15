package TestMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.LogoutPage;
import PageObjects.UpdateAccountPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CartPageTest 
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
	
		CartPage cp = new CartPage(driver);
		cp.addToCart();
	}
	
	@Test (priority=2)
	public void testMethod2() throws InterruptedException
	{
		
		Thread.sleep(8000);
		CartPage cp = new CartPage(driver);
		cp.removeFromCart();
		
		WebElement successmessage = driver.findElement(By.xpath("//div[@class='cart-empty']"));
		String actualmessage = successmessage.getText();
		System.out.println(actualmessage);
		
		LogoutPage lop = new LogoutPage(driver);
		lop.logout();
	}
	
	@Test(enabled = false, dependsOnMethods ="testMethod")
	public void testMethod3() throws InterruptedException
	{
		CartPage cp = new CartPage(driver);
		cp.removeFromCartOnHomePage();	
	}
	@AfterTest
	public void afterTestMethod()
	{   
		driver.close();
	}

}
