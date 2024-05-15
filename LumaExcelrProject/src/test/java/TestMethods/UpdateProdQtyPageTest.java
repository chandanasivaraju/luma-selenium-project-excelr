package TestMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.LogoutPage;
import PageObjects.UpdateProductQtyPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateProdQtyPageTest 

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
		
		UpdateProductQtyPage upq = new UpdateProductQtyPage(driver);
		upq.updateqty();
		upq.updateQtyCount("5");
		upq.updateShoppingCart();
		
		
		WebElement successmessage = driver.findElement(By.xpath("//span[@class='counter-number']"));
		String actualmessage = successmessage.getText();
		System.out.println("Number of items in the cart: " +actualmessage);
	}
	
	@AfterTest
	public void afterTestMethod()
	{   
		driver.close();
	}

}
