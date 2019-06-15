package excelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataDriven {
	
	//Identify "test cases" column by scanning the entire 1st row(header)
	//Once column is identified then scan entire test case column to identify "Purchase" testcase row
	//After you grab purchase test case row, pull all that row and feed in test
		
	
	@Test
	public ArrayList<String> ExcelDataDriven(String testCaseName) throws IOException
	{
		
		ArrayList<String> a=new ArrayList<String>();
		
//Using FileInputStream class to store excel sheet location in "fis" object
	FileInputStream fis=new FileInputStream("G://Selenium base folder//FileForDataDrivenFramework.xlsx");
	//By creating below object, we are getting access to "FileForDataDrivenFramework" excel doc
	XSSFWorkbook workbook=new XSSFWorkbook(fis);  
	
	int sheets = workbook.getNumberOfSheets();
	System.out.println("Number of Sheets: "+sheets); // This prints number of sheet in excel "FileForDataDrivenFramework"
	//This below part will be generic for excel driven which is to get access to specific sheet
	for(int i=0;i<sheets;i++)
	{
		if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
		{
			XSSFSheet sheet = workbook.getSheetAt(i);
			
		Iterator<Row> rows=sheet.iterator(); // sheet is collection of rows
		Row firstRow= rows.next();
		Iterator<Cell> ce=firstRow.cellIterator(); // row is collection of cells
		int k=0;
		int column = 0;
		while(ce.hasNext()) // "hasNext" will just check if next cell is present but will not move
		{
		Cell value=ce.next();
		
		//Identify "test cases" column by scanning the entire 1st row(header)
		if(value.getStringCellValue().equalsIgnoreCase("Testcases"))
		{
			column=k;
		}
		k++;
		}
		System.out.println("Column number is: "+ column);
		
		//Once column is identified then scan entire test case column(Testcases) to identify "Purchase" testcase row.
		while(rows.hasNext())
		{
			Row r=rows.next();
		if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName))// testCaseName is the String which we pass for the test
		{
			//After you grab Login1Rowtest case row, pull all that row and feed in test
				Iterator<Cell> Login1Row= r.cellIterator();
				while(Login1Row.hasNext())
				{
				a.add(Login1Row.next().getStringCellValue());
				}
		}
			
			
			
		}
		}
	}
	return a;

}

	

}
