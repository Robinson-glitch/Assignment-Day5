package AssignmentWeek5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CommonDataProvider extends BaseClassforCreatelead {
	
	@DataProvider(name="Provider")
	public Object[][] fetchData(){
		
		String[][] data= new String[2][5];
		data[0][0]="Philip";
		data[0][1]="Phil";
		data[0][2]="Mechanic";
		data[0][3]="xyx@gmail.com";
		data[0][4]="123456778";
		
		
		data[1][0]="Moris";
		data[1][1]="More";
		data[1][2]="Textile";
		data[1][3]="MNM@gmail.com";
		data[1][4]="2323233232";
		return data;
		
		
		
	}
	
@Test(dataProvider="Provider")


	public  void TestDp(String firstname, String lastName, String dept, String email, String Phno) {

		
		driver.findElement(By.linkText("Contacts")).click();
		
		//6.Click on Create contact
		
		driver.findElement(By.linkText("Create Contact")).click();
		
		//7.Enter FirstName Field Using id Locator
		
		driver.findElement(By.id("firstNameField")).sendKeys(firstname);
		
		
		//8.Enter LastName Field Using id Locator
		driver.findElement(By.id("lastNameField")).sendKeys(lastName);
		
		//9.  Enter FirstName(Local) Field Using id Locator
		
		
		
		
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Tim");
		
		//10. Enter LastName(Local) Field Using id Locator
		
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Bum");
		
		//11.Enter Department Field Using any Locator of Your Choice
		
		driver.findElement(By.name("departmentName")).sendKeys(dept);
		
		//12. Enter Description Field Using any Locator of your choice 
		
		driver.findElement(By.id("createContactForm_description")).sendKeys(" Do it");
		
		//13.  Enter your email in the E-mail address Field using the locator of your choice
		
		
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys(email);
		driver.findElement(By.id("createContactForm_primaryPhoneNumber")).sendKeys(Phno);
		
		//14.  Select State/Province as NewYork Using Visible Text
		
		
		WebElement generalSta = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")); 
		new Select(generalSta).selectByVisibleText("New York"); 
		
		
		//15. Click on Create Contact
		
		driver.findElement(By.name("submitButton")).click();
		
		//16.  Click on edit button 
		
		driver.findElement(By.linkText("Edit")).click();
		
		//17. Clear the Description Field using .clear
		
		driver.findElement(By.xpath("//textarea[@id='updateContactForm_description']")).clear();
		
		//18. Fill ImportantNote Field with Any text
		
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Hi");
		
		//19. Click on update button using Xpath locator
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		//20. Get the Title of Resulting Page.
		
		String leadList = driver.findElement(By.xpath("//div[text()='View Contact']")).getText();
	
		{
			System.out.println(""+leadList);
		}

}

	
	}
		



