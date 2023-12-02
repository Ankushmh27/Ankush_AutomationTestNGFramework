

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemeScript 
{
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager .chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String title= driver.getTitle();
		System.out.println(title);
		List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

		// Switch to the child window
		driver.switchTo().window(windowHandles.get(1));
		driver.close();


	}

}
