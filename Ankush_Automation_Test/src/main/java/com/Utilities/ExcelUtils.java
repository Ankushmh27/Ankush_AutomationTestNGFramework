package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.BaseClass.baseSetup;

public class ExcelUtils extends baseSetup
{
	public static void excelReader(){
		// Specify the path to your Excel file
		String excelFilePath = "src/test/resources/search_mobile_name.xlsx";
		Row row;
		try {
			// Open the Excel file
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

			// Create a workbook instance
			Workbook workbook = WorkbookFactory.create(inputStream);

			// Assuming your test data is in the first sheet (index 0)
			Sheet sheet = workbook.getSheetAt(0);

			// Iterate through each row in the sheet
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				// Get the current row
				 row = sheet.getRow(i);

				// Assuming the first cell contains the username and the second cell contains the password
//				String username = row.getCell(0).getStringCellValue();
//				String password = row.getCell(1).getStringCellValue();

				/*WebElement usernameField = driver.findElement(By.id("username"));
				WebElement passwordField = driver.findElement(By.id("password"));
				WebElement loginButton = driver.findElement(By.id("loginButton"));

				usernameField.sendKeys(username);
				passwordField.sendKeys(password);
				loginButton.click();*/

				// Add any additional verification or actions as needed

				// Optional: Add a delay or other synchronization method to ensure the page loads properly
				// Thread.sleep(2000);
			}

			// Close the workbook and input stream
			workbook.close();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}

