package commonFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDatasRead {
	public static FileInputStream inputstream;
	public static Object[][] data;

	@DataProvider
	public Object[][] myExcelDataRead() throws Exception {
		try {
			System.out.println("Excel File Read Started");
			File excelfile= new File(".\\src\\test\\resources\\ExcelDatasRead.xlsx");
			System.out.println("Excel File Exists or Not : " +excelfile.exists());
			inputstream=new FileInputStream(excelfile);
			XSSFWorkbook workbook= new XSSFWorkbook(inputstream);
			XSSFSheet sheet= workbook.getSheetAt(0);
			int totalrows= sheet.getPhysicalNumberOfRows();
			int totalcells= sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Number of Rows : "+ totalrows);
			System.out.println("Number of Cells : "+ totalcells);

			data= new Object[totalrows-1][totalcells];

			for (int i = 0; i < totalrows-1; i++) {
				for (int j = 0; j < totalcells; j++) {
					//String eachCell=sheet.getRow(i).getCell(j).getStringCellValue();
					//System.out.println(eachCell);
					DataFormatter df= new DataFormatter();
					//String eachcellUsingdf= df.formatCellValue(sheet.getRow(i).getCell(j));
					//System.out.println(eachcellUsingdf);
					data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				}
			}
			for (Object[] objects : data) {
				System.out.println(Arrays.toString(objects));
			}
			workbook.close();
			inputstream.close();
			System.out.println("Excel File Read Success");
		} catch (FileNotFoundException e) {
			System.out.println("Excel File Read Failed!!!");
		}
		return data;
	}
}
