package TestMethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import PageObjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTest 
{
	
		
	WebDriver driver;
	@BeforeTest
	public void beforeTestMethod() throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testMethod() throws InterruptedException, IOException
	{
		HomePage hpl = new HomePage(driver);
		hpl.LaunchURL();
		hpl.conditionCheck();		 
	}
	
	@AfterTest
	public void afterTestMethod()
	{   
		driver.close();
	}
}
