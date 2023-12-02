package demoTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationTestNG 
{
	@BeforeSuite
	public void A()
	{
		System.out.println("1: Execute 1");
	}

	@BeforeTest
	public void C()
	{
		System.out.println("3: Execute 2");
	}

	@BeforeClass
	public void E()
	{
		System.out.println("5: Execute 3");
	}

	@BeforeMethod
	public void G()
	{
		System.out.println("7: Execute 4");
	}

	@Test
	public void name()
	{
		System.out.println("Test");	
	}
	@AfterMethod
	public void H()
	{
		System.out.println("8: Execute 5");
	}
	@AfterClass
	public void F()
	{
		System.out.println("6: Execute 6");
	}
	@AfterTest
	public void D()
	{
		System.out.println("4: Execute 7");
	}
	@AfterSuite
	public void B()
	{
		System.out.println("2: Execute 8");
	}
}
