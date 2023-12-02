package com.base;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
import com.utils.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSetup 
{
	protected static WebDriver driver;

	@BeforeMethod
	public void startBrowser() throws IOException{
		String browser=Utility.configReader("browser"); //select browser by config prop file
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(Utility.configReader("url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options= new EdgeOptions();
			options.addArguments("headless");
			driver = new EdgeDriver(options);
			driver.get(Utility.configReader("url"));
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(Utility.configReader("url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		} else {
			System.out.println("This Browser is not found in your system.");
		}		
	}

	@AfterMethod
	public void closeBrowser() 
	{
		driver.close();
		driver.quit();
	}
	
		
	
	//For Parallel Execution using Testng XML
//	@Parameters("browser")
//	@BeforeMethod
//	public void startBrowser(String browser) throws IOException {
//	
//		if (browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver.get(Utility.configReader("url"));
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//		} else if (browser.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			EdgeOptions options= new EdgeOptions();
//			options.addArguments("headless");
//			driver = new EdgeDriver(options);
//			driver.get(Utility.configReader("url"));
//			driver.manage().deleteAllCookies();
//			driver.manage().window().maximize();
//		} else if (browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//			driver.get(Utility.configReader("url"));
//			driver.manage().deleteAllCookies();
//			driver.manage().window().maximize();
//		} else {
//			System.out.println("This Browser is not found in your system.");
//		}	
//	}
//	@AfterMethod
//	public void closeBrowser() 
//	{
//		driver.close();
//		driver.quit();
//	}
	
	
}
