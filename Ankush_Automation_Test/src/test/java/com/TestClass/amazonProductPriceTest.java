package com.TestClass;

import java.awt.AWTException;
import org.testng.annotations.Test;
import com.BaseClass.baseSetup;
import com.PageObject.AmazonHomePage;

public class amazonProductPriceTest extends baseSetup
{
	AmazonHomePage homePage;
	@Test(priority = 1)
	public void verifyPriceRange() throws AWTException, InterruptedException
	{
		homePage = new AmazonHomePage(driver);
		homePage.verifyPrice();
	}
}
