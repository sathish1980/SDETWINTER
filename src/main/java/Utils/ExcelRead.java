package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	static String  filePath = System.getProperty("user.dir")+"\\Input\\MakeMytrip.xlsx";
	static String[][] testdata;
	public static String[][] ReadData(String sheetName) throws IOException
	{
		File F = new File(filePath);
		FileInputStream Fs = new FileInputStream(F);
		//HSSFWorkbook workbook = new HSSFWorkbook(Fs); // .xls file
		XSSFWorkbook workbook = new XSSFWorkbook(Fs); //.xlsx file
		Sheet sheet = workbook.getSheet(sheetName);
		// to get the total rows and column value;
		int totalusedRows = sheet.getPhysicalNumberOfRows();
		Row firstRowColumn = sheet.getRow(0);
		int totalusedcolumns = firstRowColumn.getLastCellNum();
		testdata= new String[totalusedRows][totalusedcolumns];
		for(int i=0;i<totalusedRows;i++)
		{
			Row eachrow = sheet.getRow(i);
			int totalusedcolumn = eachrow.getLastCellNum();
			for(int j=0;j<totalusedcolumn;j++)
			{
				Cell eachCell = eachrow.getCell(j);
				testdata[i][j] = eachCell.getStringCellValue();
				System.out.println(eachCell.getStringCellValue());
			}
		}
		return testdata;
	}

}
