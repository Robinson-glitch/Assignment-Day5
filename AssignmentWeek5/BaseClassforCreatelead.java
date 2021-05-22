package AssignmentWeek5;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassforCreatelead {
	
	ChromeDriver driver;
@BeforeMethod
	public  void base () {
		
		// TODO Auto-generated method stub
		
	WebDriverManager.chromedriver().setup();

	
	 driver=new ChromeDriver();
	 
	 driver.get("http://leaftaps.com/opentaps");
		
		//2. Enter UserName and Password Using Id Locator
	
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//3.Click on Login Button using Class Locator
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//4.Click on CRM/SFA Link
		
		driver.findElement(By.linkText("CRM/SFA")).click();

	}
@AfterMethod
public void close() {
	
	driver.close();
	
}
	
	


}
