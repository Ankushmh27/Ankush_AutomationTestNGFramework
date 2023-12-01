package com.PageObject;

import java.awt.AWTException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Utilities.utility;

public class AmazonHomePage extends utility
{
	WebDriver driver;
	@FindBy(id = "twotabsearchtextbox")
	WebElement search;

	@FindBy(id = "low-price")
	WebElement lowerPrice;

	@FindBy(id = "high-price")
	WebElement highererPrice;

	@FindBy(xpath = "//input[@class='a-button-input']")
	WebElement go_Btn; 

	@FindBy(xpath = "(//span[@class='a-price-whole'])[1]")
	WebElement mobilePrice;

	public AmazonHomePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyPrice() throws AWTException, InterruptedException 
	{
		sendKey(search, "Mobile");
		search.sendKeys(Keys.ENTER);
		sleep(1000);

		ScrollIntoView(driver, lowerPrice);
		lowerPrice.sendKeys("15000");
		highererPrice.sendKeys("20000");
		sleep(1000);
		clickOn(go_Btn);

		ScrollIntoView(driver, mobilePrice);
		sleep(1000);
		System.out.println("mobilePrice display: "+ mobilePrice.isDisplayed());
		String price =mobilePrice.getText();
		System.out.println("Mobile Price: "+ price);

		double pricetext = Double.parseDouble(price.replaceAll("[^0-9.]", ""));
		if (pricetext >= 15000 && pricetext <= 20000) {
			System.out.println("The price is within the range of 15000 and 20000");
		} else {
			System.out.println("The price is not within the range of 15000 and 20000");
		}
	}

	public void verifyMobile(String mobiles) throws AWTException, InterruptedException 
	{
		sendKey(search, mobiles);
		sleep(500);
		search.clear();
		sleep(500);
	}
}
