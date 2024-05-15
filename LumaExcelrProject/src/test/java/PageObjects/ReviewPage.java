package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewPage 
{

	WebDriver driver;
	
	By product = By.xpath("//a[@title='Push It Messenger Bag']");
	By addreview = By.xpath("//a[@class='action add']");
	By rating = By.xpath("//label[@class='rating-1']");
	By nickname = By.id("nickname_field");
	By summary = By.id("summary_field");
	By review = By.id("review_field");
	By submit = By.xpath("(//button[@type='submit']/span)[3]");
	
	
	public ReviewPage(WebDriver idriver)
	{
		this.driver = idriver;
	}
	
	//TC-18-Adding review to the product
	public void addReview(String nick_name, String summary_text, String review_text) throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(product).click();
		Thread.sleep(1000);
		driver.findElement(addreview).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(rating));
		driver.findElement(rating).click();
		Thread.sleep(1000);
		driver.findElement(nickname).sendKeys(nick_name);
		Thread.sleep(1000);
		driver.findElement(summary).sendKeys(summary_text);
		Thread.sleep(1000);
		driver.findElement(review).sendKeys(review_text);
		Thread.sleep(1000);
		driver.findElement(submit).click();
		Thread.sleep(2000);
	}
}
