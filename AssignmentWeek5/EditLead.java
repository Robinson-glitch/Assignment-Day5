package AssignmentWeek5;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditLead extends BaseClassforCreatelead {


@DataProvider(name="Excelinput")
public Object[][] fetchData() throws InvalidFormatException, IOException{
	 String Sheetname="EditLead";
	
Object [][]data=ExcelClass.readexcel(Sheetname);
	
	return data;
	
}
@Test(dataProvider="Excelinput")

	public void Edit (String firstname, String lastname, String deptname, String email, String yournote) {
		// TODO Auto-generated method stub
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys(firstname);
		driver.findElement(By.id("lastNameField")).sendKeys("Mariaselvam,");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys(lastname);
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("bin");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys(deptname);
		driver.findElement(By.id("createContactForm_description")).sendKeys("Script to create contact through automation");

		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys(email);
		WebElement eleDropdown1=driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select d1 = new Select(eleDropdown1);
		d1.selectByVisibleText("New York");

		driver.findElement(By.name("submitButton")).click();

		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys(yournote);
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		String text2 = driver.findElement(By.id("sectionHeaderTitle_contacts")).getText();
		System.out.println(text2);
		



	}

}
