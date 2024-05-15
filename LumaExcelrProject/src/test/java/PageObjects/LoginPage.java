package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 

{
	WebDriver driver;
	
	By signin = By.xpath("(//li[@class='authorization-link']/child::a)[1]");
	By emailid = By.id("email");
	By password = By.id("pass");
	By signinbutton = By.id("send2");

	public LoginPage(WebDriver idriver)
	{
		this.driver = idriver;
	}
	
	//TC-12-Successful login of the user with valid credentials
	public void signIn() throws InterruptedException
	{
		driver.findElement(signin).click();
		Thread.sleep(1000);
	}
	public void emailID(String e) throws InterruptedException
	{
		driver.findElement(emailid).sendKeys(e);		
		Thread.sleep(1000);
	}
	public void password(String p) throws InterruptedException
	{
		driver.findElement(password).sendKeys(p);	
		Thread.sleep(1000);
	}
	public void signInButton() throws InterruptedException
	{
		driver.findElement(signinbutton).click();
		Thread.sleep(1000);
	}
}
