import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.time.Duration;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.PublicEncryptionKey;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPriceTest 

{
	@Test
	public void VerifyPrice() throws AWTException, InterruptedException 
	{
		//test price in bet ranges 15k to 20 k
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement search=  driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("Mobile");
		Actions action = new Actions(driver);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		WebElement lowerPrice= driver.findElement(By.id("low-price"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", lowerPrice);

		System.out.println(lowerPrice.isDisplayed());
		lowerPrice.sendKeys("15000");
		Thread.sleep(2000);

		WebElement highererPrice= driver.findElement(By.id("high-price"));
		highererPrice.sendKeys("20000");
		Thread.sleep(2000);
		System.out.println(highererPrice.isDisplayed());

		driver.findElement(By.xpath("//input[@class='a-button-input']")).click();

		WebElement mobilePrice = driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN"
				+ " template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-price-whole']"));
		String price =mobilePrice.getText();
		System.out.println(price);
		double pricetext = Double.parseDouble(price.replaceAll("[^0-9.]", ""));
		if (pricetext >= 15000 && pricetext <= 20000) {
			System.out.println("The price is within the range of 15000 and 20000.");
		} else {
			System.out.println("The price is not within the range of 15000 and 20000.");
		}

		driver.quit();
	}
}
