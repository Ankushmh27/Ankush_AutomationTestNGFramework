package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.*;


public class ExcelUtils {

	private static Workbook workbook;
	public static Sheet sheet;

	public static void setExcelFile(String filePath, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(new File(filePath));
		workbook = WorkbookFactory.create(file);
		sheet = workbook.getSheet(sheetName);
	}

	public static String getCellData(int rowNum, int colNum) {
		Cell cell = sheet.getRow(rowNum).getCell(colNum);
		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(cell);
	}
}
