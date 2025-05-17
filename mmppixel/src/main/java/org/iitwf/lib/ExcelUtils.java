package org.iitwf.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {



	public static String[][] readExcel(String fileName,String sheetName) throws IOException {

		String filePath = System.getProperty("user.dir")+"//"+fileName;
		File f = new File(filePath);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		int rows = sheet.getPhysicalNumberOfRows();
		String data[][] = new String[rows][cols];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				XSSFCell cell = sheet.getRow(i).getCell(j);
				CellType cellType = cell.getCellType();
				switch (cellType) 
				{
					case STRING:
						data[i][j]= cell.getStringCellValue();
						break;

					case NUMERIC:
						data[i][j]= cell.getNumericCellValue()+"";
						break;

					default:
						throw new IllegalStateException("Illegal cell type: " +cellType );
				}
				System.out.println("output:::::  " + data[i][j]);
			}
		}

		wb.close();
		return data;

	}
}
