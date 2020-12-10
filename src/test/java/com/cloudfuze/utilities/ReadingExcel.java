package com.cloudfuze.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadingExcel {

	public static String[][] ReadingExcelmethod(String filelocation,String fileextension,String sheetName){
		String[][] Testdata=null;
		try {
			File file = new File(filelocation);
			FileInputStream fis = new FileInputStream(file);
			Workbook workbook = null;
			if(fileextension.equals("xls")) {
				workbook = new HSSFWorkbook(fis);
			}else if(fileextension.equals("xlsx")) {
				workbook = new XSSFWorkbook(fis);
			}
			Sheet sheet = workbook.getSheet(sheetName);
			int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();
			int columncount = sheet.getRow(0).getLastCellNum();
			Testdata = new String[rowcount+1][columncount];
			for(int i =0;i<rowcount+1 ;i++) {
				Row row = sheet.getRow(i);
				for(int j =0;j<columncount ;j++) {
					Cell cell = sheet.getRow(i).getCell(j);
					String celltype = cell.getCellType().toString();
					if(celltype.contentEquals("NUMERIC")) 
						Testdata[i][j] = String.valueOf(cell.getNumericCellValue());
					if(celltype.contentEquals("STRING")) 
						Testdata[i][j] = cell.getStringCellValue();
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return Testdata;
	}
}
