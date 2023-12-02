package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	 WebDriver driver;

	@FindBy(xpath = "//input[@name='username']")
    WebElement usernameInput;

	@FindBy(xpath = "//input[@name='password']")
    WebElement passwordInput;

	@FindBy(css = "button.orangehrm-login-button[type='submit']")
    WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void inputUsername(String username) {
//		System.out.println("username displayed : "+ usernameInput.isDisplayed());
		usernameInput.sendKeys(username);	
	}

	public void inputPassword(String password) {
//		System.out.println("username displayed : "+passwordInput.isDisplayed());
		passwordInput.sendKeys(password);
	}

	public void clickLoginButton() {
//		System.out.println("loginButton enable : "+loginButton.isEnabled());
		loginButton.click();
	}
}



