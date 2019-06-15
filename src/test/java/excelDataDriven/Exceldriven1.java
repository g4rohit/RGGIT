package excelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Exceldriven1 {

	@Test
	public void dataDriver() throws IOException {

		System.out.println("1st print");
		// Saving excel file path in Obj fis
		FileInputStream fis = new FileInputStream("G:\\Selenium base folder\\FileForDataDrivenFramework.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis); // Creating obj for XSSFWorkbook class

		int sheets = workbook.getNumberOfSheets(); // to count number of sheets in provided excel

		System.out.println("Second print");

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) // Here we are checking the index of sheet with
																		// name "testdata"
			{
				XSSFSheet sheet = workbook.getSheetAt(i); // Now "Sheet" has been loaded with all the rows of worksheet
															// name "testdata"/index 0

				// a)Identify TestCases column from excel sheet by scanning entire 1st row

				Iterator<Row> rows = sheet.iterator(); // This is a good option available in java collections
				Row firstRow = rows.next(); // Now with this we navigated to first row of "testdata" sheet
				Iterator<Cell> ce = firstRow.cellIterator();

				int k = 0;
				int column = 0;
				// System.out.println("Third print");
				while (ce.hasNext()) // This is to check whether there is value in next coloumn
				{
					Cell value = ce.next();

					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) // Comparing cell value against
																					// "TestCases"
					{
						column = k;
					}
					k++;
				}
				System.out.println("Column number" + column);
				System.out.println("hi");

			}
		}

	}

}
