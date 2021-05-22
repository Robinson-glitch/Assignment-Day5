package AssignmentWeek5;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelClass {
		// TODO Auto-generated method stub
		
		@Test
		public static String[][] readexcel(String Sheetname) throws InvalidFormatException, IOException {
			// TODO Auto-generated method stub
			
	File FileName=new File("C:\\TestLeaf\\eclipse_64bit\\MavenProject\\data\\Leads.xlsx");
	XSSFWorkbook wbook= new XSSFWorkbook(FileName);
	XSSFSheet sheet=wbook.getSheet(Sheetname);
	
	
	 
	int rCount = sheet.getLastRowNum();
	int cCount=sheet.getRow(0).getLastCellNum();
	String [][] data = new String[rCount][cCount];
	for(int i=1;i<=rCount;i++) 
	{
		
		XSSFRow row= sheet.getRow(i);
		for(int j=0;j< cCount;j++) 
		{
			XSSFCell cell= row.getCell(j);
			System.out.println(cell.getStringCellValue());
			data[i-1][j]=cell.getStringCellValue();
		}
	}
	wbook.close();
	return data;
		}

	}


