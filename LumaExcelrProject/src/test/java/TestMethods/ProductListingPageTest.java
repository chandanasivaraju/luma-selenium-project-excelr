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
import PageObjects.ProductListingPage;
import PageObjects.UpdateAccountPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductListingPageTest 

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
		
		
		ProductListingPage plp = new ProductListingPage(driver);
		plp.productsList();
		
		WebElement successmessage = driver.findElement(By.xpath("//ol[@class='products list items product-items']"));
		String actualmessage = successmessage.getText();
		System.out.println("PRODUCT DETAILS: ");
		System.out.println(actualmessage);
		
		plp.productDetailPage();
	}
	
	
	@AfterTest
	public void afterTestMethod()
	{   
		driver.close();
	}

}
