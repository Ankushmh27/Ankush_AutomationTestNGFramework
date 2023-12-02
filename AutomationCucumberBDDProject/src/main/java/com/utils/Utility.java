package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import com.base.BaseSetup;

public class Utility extends BaseSetup
{
	public WebDriver driver;
	 public static String configReader(String key) throws IOException {
	        Properties prop = new Properties();
	        FileInputStream myFile;
	        myFile = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/configurations.properties");
	        prop.load(myFile);
	        String value = prop.getProperty(key);
	        return value;
	    } 
	 public static byte[] takeScreenShot(WebDriver driver) throws WebDriverException
		{
		 
			return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		}
		
	 public static String timeStamp() {
	        DateFormat dateFormat = new SimpleDateFormat("ddMMYY-HHmmss");
	        Date date = new Date();
	        return dateFormat.format(date);
	    }
	 
	 public static String getScreenshot(WebDriver driver,String name) throws Exception
		{
			
			File file = (((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE));
			String path = System.getProperty("user.dir")+"/screenshot"+name+".png";
			File dest = new File(path);
			FileUtils.copyFile(file, dest);
			return path;		
	    }
}
