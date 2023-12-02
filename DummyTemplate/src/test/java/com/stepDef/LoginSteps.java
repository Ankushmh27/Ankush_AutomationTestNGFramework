package com.stepDef;

import org.testng.annotations.Test;
import com.base.BaseClass;
import com.page.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass{
    private LoginPage loginPage= new LoginPage(driver);
    
//    @Before
    @Given("User is on the login page")
    public void user_is_on_the_login_page() 
    {
    	
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
    	loginPage=new LoginPage(driver);
    	loginPage.login("fbhsd", "dfhsbh");
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
    	System.out.println("user login");
    	System.out.println("======="	+driver.getTitle());
    }
    @Test
    @Then("User should be redirected to the dashboard")
    public void user_should_be_redirected_to_the_dashboard() {
      
       System.out.println( "====");
    }



}