package com.TestClass;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.BaseClass.baseSetup;
import com.PageObject.AmazonHomePage;
import com.Utilities.ExcelUtils;
import com.Utilities.utility;

public class SearchMobilesTest extends baseSetup
{
	AmazonHomePage homePage;

	@Test(dataProvider = "SearchDataProvider")
	public void verifyMobiledata(String mobile) throws AWTException, InterruptedException
	{
		homePage = new AmazonHomePage(driver);
		homePage.verifyMobile(mobile);
		System.out.println("mobile search list : "+mobile);	
	}

	@DataProvider(name = "SearchDataProvider")
	public Object[][] getData() throws IOException {
		String excelpath=utility.configReader("excelFilePath");//"./src/test/resources/search_mobile_name.xlsx"; 
		ExcelUtils.setExcelFile(excelpath, "Sheet1");
		int rowCount = ExcelUtils.sheet.getLastRowNum();
		int colCount = ExcelUtils.sheet.getRow(1).getLastCellNum();
		Object[][] data = new Object[rowCount][colCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				data[i-1][j] = ExcelUtils.getCellData(i, j);
			}
		}
		return data;
	}
}
