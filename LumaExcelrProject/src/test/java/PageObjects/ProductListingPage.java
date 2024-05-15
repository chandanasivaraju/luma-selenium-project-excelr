package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductListingPage 
{

	WebDriver driver;
	
	By women = By.xpath("(//a[@role='menuitem'])[2]");
	By tops = By.linkText("Hoodies & Sweatshirts");
	By hoodie = By.linkText("Mona Pullover Hoodlie");
	
	public ProductListingPage(WebDriver idriver)
	{
		this.driver = idriver;
	}
	
	//TC-15-Navigating from home page to all the products listing page
	public void productsList() throws InterruptedException
	{
		driver.findElement(women).click();
		Thread.sleep(1000);
		driver.findElement(tops).click();
		Thread.sleep(1000);
	}

	/*
	 * TC-16-Selecting one product from the products listing page and checking if
	 * that's navigating to the correct product details page where it shows price,size, color etc details of the product
	 */
	public void productDetailPage() throws InterruptedException
	{
		driver.findElement(hoodie).click();
		Thread.sleep(3000);
	}
}
