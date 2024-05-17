package PageObjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage 
{

    WebDriver driver;
    By hotseller = By.xpath("//a[@title='Fusion Backpack']");
    By addtocart = By.xpath("(//button[@type='submit'])[2]");
    By cart = By.xpath("//a[@class='action showcart']");
	By viewandeditcart = By.xpath("//a[@class='action viewcart']");
	
	//shipping and placing order
	//for the first time user
	//By firstname = By.xpath("//input[@name='firstname']");
	//By lastname = By.xpath("//input[@name='lastname']");
	By address = By.xpath("//input[@name='street[0]']");
	By city = By.xpath("//input[@name='city']");
	//By state = By.xpath("//select[@name='region_id']");
	By zipcode = By.xpath("//input[@name='postcode']");
	//By country = By.xpath("//select[@name='country_id']");
	By contactnum = By.xpath("//input[@name='telephone']");
	By next = By.xpath("//button[@class='button action continue primary']"); 
	By checkbox = By.xpath("//input[@name='billing-address-same-as-shipping']");
	By placeorder = By.xpath("//button[@class='action primary checkout']/span");
	
	By next1 = By.xpath("//form[@id='co-shipping-method-form']/div[3]/div/button/span");
	
	By dropdown = By.xpath("(//button[@class='action switch'])[1]");
	By myaccount = By.xpath("(//li/child::a)[1]");
	By myorders = By.xpath("(//li[@class='nav item'])[1]");
	By vieworder = By.xpath("(//a[@class='action view'])[1]");
	
	public CheckoutPage(WebDriver idriver)
	{
		this.driver = idriver;
	}
	
	//TC-5-Checking if the proceed to checkout button is working
	public void checkOut() throws InterruptedException
	{
		driver.findElement(hotseller).click();
		Thread.sleep(2000);
		driver.findElement(addtocart).click();
		Thread.sleep(2000);
		driver.findElement(cart).click();
		Thread.sleep(2000);
		driver.findElement(viewandeditcart).click();
		Thread.sleep(5000);
	
	
		WebElement web = driver.findElement(By.xpath("//ul[@class='checkout methods items checkout-methods-items']/child::li/child::button"));
		Thread.sleep(6000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", web); 
		 web.click();
		Thread.sleep(5000);
		
	}
	
	/*
	 * TC-6(1)-After proceed to checkout, the user have to execute the below scenario
	 * if purchasing the order for the first time after creating an account
	 */
	public void orderPurchase(String add, String cityname, String postalcode, String contact ) throws InterruptedException
	{
		//driver.findElement(firstname).clear();
		//driver.findElement(firstname).sendKeys(fname);
		//driver.findElement(firstname).clear();
		//driver.findElement(lastname).sendKeys(lname);
		Thread.sleep(3000);
		driver.findElement(address).sendKeys(add);
		Thread.sleep(3000);
		driver.findElement(city).sendKeys(cityname);
		Thread.sleep(3000);
		
		WebElement country = driver.findElement(By.xpath("//select[@name='country_id']"));
		Thread.sleep(3000);
		Select s1 = new Select(country);
		s1.selectByVisibleText("India");
		Thread.sleep(2000);
		
		
		WebElement state = driver.findElement(By.xpath("//select[@name='region_id']"));
		Thread.sleep(3000);
		Select s = new Select(state);
		s.selectByVisibleText("Telangana");
		Thread.sleep(2000);
		
		driver.findElement(zipcode).sendKeys(postalcode);
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		driver.findElement(contactnum).sendKeys(contact);
	
		Thread.sleep(3000);
		driver.findElement(next).click();
		Thread.sleep(3000);
		driver.findElement(checkbox).click();
		Thread.sleep(2000);
		driver.findElement(checkbox).click();
		Thread.sleep(2000);
		driver.findElement(placeorder).click();
		Thread.sleep(3000);
		
	}
	//TC-6(2)- User should execute below scenario from the second time purchase of the order after creating an account
	public void secondTimeOrderPurchase() throws InterruptedException
	{
		//from 2nd time order purchase it will select default address
		driver.findElement(next1).click();
		Thread.sleep(2000);
		driver.findElement(checkbox).click();
		Thread.sleep(2000);
		driver.findElement(checkbox).click();
		Thread.sleep(2000);
		driver.findElement(placeorder).click();
		Thread.sleep(3000);
	}
	
	//TC-7-Checking the order status and order details after purchasing the order successfully
	public void orderStatusPage() throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		driver.findElement(dropdown).click();
		Thread.sleep(1000);
		driver.findElement(myaccount).click();
		Thread.sleep(2000);
		driver.findElement(myorders).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(vieworder));
		driver.findElement(vieworder).click();
		Thread.sleep(2000);
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(2000);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("src\\main\\resources\\orderstatuspage.jpeg");
		FileHandler.copy(src, destination);
		
	}

	

}
