package com.BaseClass;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.Utilities.utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseSetup 
{
	protected static WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public static void setupBrowser(String browser) throws IOException
	{
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else 
		{
			System.out.println("This Browser is not found in your system");
		}
		driver.get(utility.configReader("url"));
		driver.manage().window().maximize();
		utility.implicitWait(driver, 5);
	}

	@AfterClass
	public static void tearDown() throws IOException
	{
		driver.close();
		driver.quit();
	}
}