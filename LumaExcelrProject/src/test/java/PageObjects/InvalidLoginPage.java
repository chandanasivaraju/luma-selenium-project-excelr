package PageObjects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvalidLoginPage 
{

	WebDriver driver;
	
	public InvalidLoginPage(WebDriver idriver)
	{
		this.driver = idriver;
	}
	
	//TS-Checking unsuccessful user login with invalid credentials by getting data from the excel sheet(DataDrivenFramework)
	//TC-9-Invalid email id and invalid password
	//TC-10-Invalid email id and valid password
	//TC-11-Valid email id and invalid password
	public void invalidLogin() throws IOException, InterruptedException
	{
		String filepath = "E:\\ExcelR\\Daily Notes-Selenium Java\\Excel Data\\InvalidLogin.xlsx";
		FileInputStream fis = new FileInputStream(filepath); //reading the data from the sheet
		XSSFWorkbook workbook = new XSSFWorkbook(fis); //going through the hierarchy and creating the workbook
		XSSFSheet sheet = workbook.getSheet("TestData"); //sheet name
		
		int rows = sheet.getLastRowNum();
		System.out.println("number of rows: " +rows);
		
		for(int r = 1; r<=rows; r++)
		{
			XSSFRow row = sheet.getRow(r);
			XSSFCell emailid = row.getCell(0); //reading the data from excel sheet - getcell method
			XSSFCell password = row.getCell(1); //reading the data from excel sheet - getcell method
			//creating variable to store the output of Result column in excel sheet in 3rd index
			XSSFCell result = row.createCell(2);
			
			System.out.println("EmailID:"+emailid +"Password:"+password);
			
			try //handles valid data
			{
			//login
				driver.findElement(By.xpath("(//li[@class='authorization-link']/child::a)[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("email")).sendKeys(emailid.toString());
				Thread.sleep(2000);
				driver.findElement(By.id("pass")).sendKeys(password.toString());
				Thread.sleep(2000);
				driver.findElement(By.id("send2")).click();
				Thread.sleep(2000);
			}	
				
			catch(Exception e) //handles invalid data
			{
				Thread.sleep(2000);
				System.out.println("Invalid Data");
				result.setCellValue("Invalid Input");
			}
		}
		fis.close();
		
		
		//for writing the result on the excel sheet
		FileOutputStream fos = new FileOutputStream(filepath);
		workbook.write(fos);
		Thread.sleep(2000);
		
    }
}
