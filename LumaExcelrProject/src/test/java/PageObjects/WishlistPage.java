package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WishlistPage 
{

	WebDriver driver;
	By yogacollection = By.xpath("//a[@class='block-promo home-main']");
	By product = By.linkText("Neve Studio Dance Jacket");
	By addtowishlist = By.xpath("(//a[@class='action towishlist'])[1]");
	
	By dropdown = By.xpath("(//button[@class='action switch'])[1]");
	By mywishlist = By.xpath("(//li[@class='link wishlist']/child::a)[1]");
	//add same 'product' xpath here
	By size = By.xpath("(//div[@index='2'])[1]");
	By color = By.xpath("(//div[@index='2'])[2]");
	By addtocart = By.xpath("(//button[@type='submit'])[2]");
	By showcart = By.xpath("//a[@class='action showcart']");
	
  
    By bin = By.xpath("(//a[@class='btn-remove action delete'])[2]");
	
	
	public WishlistPage(WebDriver idriver)
	{
		this.driver = idriver;
	}
	
	//TC-23-Adding product to wishlist
	public void addProductToWishlist() throws InterruptedException
	{
		driver.findElement(yogacollection).click();
		Thread.sleep(3000);
		driver.findElement(product).click();
		Thread.sleep(3000);
		driver.findElement(addtowishlist).click();
		Thread.sleep(3000);
	}
	//TC-24-moving the same product from wishlist and adding it to the cart
	public void addProductToCart() throws InterruptedException
	{
		
		driver.findElement(dropdown).click();
		Thread.sleep(3000);
		driver.findElement(mywishlist).click();
		Thread.sleep(3000);
		driver.findElement(product).click();
		Thread.sleep(3000);
		driver.findElement(size).click();
		Thread.sleep(3000);
		driver.findElement(color).click();
		Thread.sleep(3000);
		driver.findElement(addtocart).click();
		Thread.sleep(5000);
		driver.findElement(showcart).click();
		Thread.sleep(5000);
	}
	
	//TC-25-Removing the product from the wishlist
	public void removeProductFromWishlist() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(bin).click();
		Thread.sleep(5000);
	}
}
