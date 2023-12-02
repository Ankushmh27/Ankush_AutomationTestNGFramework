package com.stepdefination;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.base.BaseSetup;
import com.pages.LoginPage;
import com.utils.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseSetup
{
	LoginPage lp;
	@Given("user launch application")
	public void LaunchApplication() throws IOException 
	{  
		startBrowser() ;// run by config property
//		startBrowser("browser");  //run parallel by xml
		System.out.println("launch app"); 
	}

	@When("user enter username")
	public void enterUsername() throws IOException, InterruptedException 
	{   lp=new LoginPage(driver);
		System.out.println("enterUsername()");
		lp.inputUsername(Utility.configReader("username"));
		Thread.sleep(2000);
	}

	@When("user enter password")
	public void enterPassword() throws IOException, InterruptedException 
	{
		System.out.println("enterpassword()");
		lp.inputPassword(Utility.configReader("password"));
		Thread.sleep(2000);
	}
	
	@When("user click on login button")
	public void clickOnLoginBtn() throws InterruptedException
	{
		System.out.println("click on login btn()");
		lp.clickLoginButton();
//		Assert.fail();
		Thread.sleep(2000);
	}
	@Test
	@Then("user verify pageTitle")
	public void verifyPageTitle() throws InterruptedException 
	{   
		System.out.println(driver.getTitle()); 
		Thread.sleep(2000);
	}

	@Then("user close application")
	public void closeApplication()
	{
		closeBrowser();
		System.out.println("teardown"); 
	}
}
