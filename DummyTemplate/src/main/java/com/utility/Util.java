package com.utility;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Util  {
	public static FileInputStream fis ;
	public static Properties prop;
	
	//takeScreenshot code
//	public static byte[] takeScreenShot()
//	{
//		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//	}
//	
//	public static String readProperties(String key)
//	{
//		String path = System.getProperty("/DummyTemplate/src/test/resources/config.properties");
//		Properties prop= new Properties();	
//		try
//		{
//			fis=new FileInputStream(path);		
//			prop.load(fis);
//		} 
//		catch (Exception e) {
//		e.printStackTrace();
//		}	
//		return prop.getProperty(key);
//	}
}
