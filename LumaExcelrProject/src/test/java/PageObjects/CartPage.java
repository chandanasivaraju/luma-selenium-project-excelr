package PageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage 
{

	WebDriver driver;
	
	By men = By.xpath("(//a[@role='menuitem'])[11]");
	By Jackets = By.linkText("Jackets");
	By product = By.linkText("Beaumont Summit Kit");
	By size = By.xpath("(//div[@index='2'])[1]");
	By color = By.xpath("(//div[@index='2'])[2]");
	By addtocart = By.xpath("(//button[@type='submit'])[2]");
	
	By cart = By.xpath("//a[@class='action showcart']");
	By viewandeditcart = By.xpath("//a[@class='action viewcart']");
	By removeitem = By.xpath("(//a[@title='Remove item'])[2]");
	
	By bin = By.xpath("(//a[@class='action delete'])[1]");
	By alertok = By.xpath("//button[@class='action-primary action-accept']");
	
	public CartPage(WebDriver idriver)
	{
		this.driver = idriver;
	}
	
	//TC-1-Adding a product to the cart
	public void addToCart() throws InterruptedException
	{
		driver.findElement(men).click();
		Thread.sleep(1000);
		driver.findElement(Jackets).click();
		Thread.sleep(1000);
		driver.findElement(product).click();
		Thread.sleep(1000);
		driver.findElement(size).click();
		Thread.sleep(1000);
		driver.findElement(color).click();
		Thread.sleep(1000);
		driver.findElement(addtocart).click();
		Thread.sleep(2000);
		
	}
	
	//TC-2-Removing a product from the cart
	public void removeFromCart() throws InterruptedException
	{
		
		driver.findElement(cart).click();
		Thread.sleep(5000);
		driver.findElement(viewandeditcart).click();
		Thread.sleep(2000);
		driver.findElement(removeitem).click();
		Thread.sleep(2000);
	}
	
	//TC-3-Removing a product from the cart icon which is present on the home page top right corner
	public void removeFromCartOnHomePage() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(cart).click();
		Thread.sleep(3000);
		driver.findElement(bin).click();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.alertIsPresent());
	    //Alert a = driver.switchTo().alert();
		//a.accept();
		Thread.sleep(2000);
		driver.findElement(alertok).click();
		Thread.sleep(5000);
	}
}
