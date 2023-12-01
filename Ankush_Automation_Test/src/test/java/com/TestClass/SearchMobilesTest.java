package com.TestClass;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BaseClass.baseSetup;
import com.PageObject.AmazonHomePage;

public class SearchMobilesTest extends baseSetup
{
	AmazonHomePage homePage;
	@Test(priority = 1,dataProvider = "SearchDataProvider")
	public void verifyMobiledata(String mobile) throws AWTException, InterruptedException
	{
		homePage = new AmazonHomePage(driver);
		homePage.verifyMobile(mobile);
	}
	
	@DataProvider(name = "SearchDataProvider")
	public Object[][] getLoginData() {
		String excelFilePath = "C://Users//Ankush Mhala//Desktop//Files//search_mobile_name.xlsx";
		String sheetName = "search_data";

		Object[][] data = null;

		try {
			// Open the Excel file
			FileInputStream inputStream = new FileInputStream(excelFilePath);
			Workbook workbook = WorkbookFactory.create(inputStream);

			// Assuming your data is in the first sheet (index 0)
			Sheet sheet = workbook.getSheet(sheetName);

			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();

			data = new Object[rowCount][colCount];

			for (int i = 1; i <= rowCount; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < colCount; j++) {
					data[i - 1][j] = row.getCell(j).toString();
				}
			}

			workbook.close();
			inputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}
}
