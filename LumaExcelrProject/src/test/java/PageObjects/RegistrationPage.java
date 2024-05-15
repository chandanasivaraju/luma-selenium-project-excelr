package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage 
{
	//TC-17-Verify that users can create an account successfully by filling out the registration form
	//This can be executed only once as the user details will be unique every time when registers

	WebDriver driver;
	
	By createaccount = By.linkText("Create an Account");
	By firstname = By.xpath("//input[@id=\"firstname\"]");
	By lastname = By.xpath("//input[@id=\"lastname\"]");
	By email = By.xpath("//input[@id=\"email_address\"]");
	By password = By.xpath("//input[@id=\"password\"]");
	By confirmpassword = By.xpath("//input[@id=\"password-confirmation\"]");
	By createaccountbutton = By.xpath("(//button[@type=\"submit\"])[2]");
	
	
	public RegistrationPage(WebDriver idriver)
	{
		this.driver = idriver;
	}
	
	public void launchURL() throws InterruptedException
	{
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(2000);
	}
	
	public void createAccount() throws InterruptedException
	{
		driver.findElement(createaccount).click();
		Thread.sleep(1000);
	}
	
	public void firstName(String fn) throws InterruptedException
	{
		driver.findElement(firstname).sendKeys(fn);
		Thread.sleep(1000);
	}
	
	public void lastName(String ln) throws InterruptedException
	{
		driver.findElement(lastname).sendKeys(ln);
		Thread.sleep(1000);
	}
	
	public void email(String e) throws InterruptedException
	{
		driver.findElement(email).sendKeys(e);
		Thread.sleep(1000);
	}
	
	public void password(String pwd) throws InterruptedException
	{
		driver.findElement(password).sendKeys(pwd);
		Thread.sleep(1000);
	}
	
	public void confirmPassword(String cpwd) throws InterruptedException
	{
		driver.findElement(confirmpassword).sendKeys(cpwd);
		Thread.sleep(1000);
	}
	
	public void createAccountButton() throws InterruptedException
	{
		driver.findElement(createaccountbutton).click();
		Thread.sleep(1000);
	}
	

}
