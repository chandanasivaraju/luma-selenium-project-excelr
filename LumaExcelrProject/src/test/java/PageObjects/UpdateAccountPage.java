package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class UpdateAccountPage 
{

	WebDriver driver;
	
	By dropdown = By.xpath("(//button[@type='button'])[1]");
	By myaccount = By.linkText("My Account");
	By edit = By.xpath("(//a[@class='action edit'])[4]");
	By firstname = By.id("firstname");
	By lastname = By.id("lastname");
	By changeemail = By.id("change-email");
	By changepassword = By.id("change-password");
	By editemail = By.id("email");
	By currentpassword = By.id("current-password");
	By newpassword = By.id("password");
	By confrimpassword = By.id("password-confirmation");
	By save = By.xpath("(//button[@type='submit'])[2]");
	
	
	public UpdateAccountPage(WebDriver idriver)
	{
		this.driver = idriver;
	}
	
	//TC-21-Updating user's personal or sign in information
	public void updateAccount() throws InterruptedException
	{
		driver.findElement(dropdown).click();
		Thread.sleep(1000);
		driver.findElement(myaccount).click();
		Thread.sleep(1000);
        driver.findElement(edit).click();
        Thread.sleep(1000);
	}
	
	public void editFirstName(String fname) throws InterruptedException
	{
		 driver.findElement(firstname).clear();
		 driver.findElement(firstname).sendKeys(fname);
		 Thread.sleep(1000);
	}
	public void editLastName(String lname) throws InterruptedException
	{
		 driver.findElement(lastname).clear();
		 driver.findElement(lastname).sendKeys(lname);
		 Thread.sleep(1000);
	}
	
	public void changeEmail() throws InterruptedException
	{
		driver.findElement(changeemail).click();
		Thread.sleep(1000);
	}
	public void changePassword() throws InterruptedException
	{
	   driver.findElement(changepassword).click();	
	   Thread.sleep(1000);
	}
	public void editEmail(String email) throws InterruptedException
	{
		driver.findElement(editemail).clear();
		driver.findElement(editemail).sendKeys(email);
		Thread.sleep(1000);
	}
	
	public void currentPassword(String current) throws InterruptedException
	{
		driver.findElement(currentpassword).sendKeys(current);
		Thread.sleep(1000);
	}
	
	public void newPassword(String newp) throws InterruptedException
	{
		driver.findElement(newpassword).sendKeys(newp);
		Thread.sleep(1000);
	}
	
	public void confirmPassword(String confirm) throws InterruptedException
	{
		driver.findElement(confrimpassword).sendKeys(confirm);
		Thread.sleep(1000);
	}
		
	public void save() throws InterruptedException
	{
		driver.findElement(save).click();
		Thread.sleep(1000);
	}
}
