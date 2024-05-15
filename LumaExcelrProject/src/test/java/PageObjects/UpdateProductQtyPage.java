package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateProductQtyPage 
{

	WebDriver driver;
	
	By cart = By.xpath("//a[@class='action showcart']");
	By viewandeditcart = By.xpath("//a[@class='action viewcart']");
	By quantity = By.xpath("(//input[@class='input-text qty'])[1]");
	By updateshoppingcart = By.xpath("(//button[@type='submit'])[2]");
	
	
	public UpdateProductQtyPage(WebDriver idriver)
	{
		this.driver = idriver;
	}
	
	//TC-22-Updating quantity of the product from the cart page and clicking on update shopping cart button
	public void updateqty() throws InterruptedException
	{
		driver.findElement(cart).click();
		Thread.sleep(5000);
		driver.findElement(viewandeditcart).click();
		Thread.sleep(3000);
		driver.findElement(quantity).click();
		Thread.sleep(4000);
		driver.findElement(quantity).clear();
		Thread.sleep(4000);
	}
	
	public void updateQtyCount(String qty) throws InterruptedException
	{
		driver.findElement(quantity).sendKeys(qty);
		Thread.sleep(4000);
	}
	
	public void updateShoppingCart() throws InterruptedException
	{
		driver.findElement(updateshoppingcart).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
	}
}
