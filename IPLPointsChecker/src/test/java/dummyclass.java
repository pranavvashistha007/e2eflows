import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import base.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dummyclass extends base.BaseClass {
	// extends base.BaseClass

	@Test
	public void dummymethod() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		BaseClass.hardWait(5000);
		
		driver.quit();
		
		driver.close();

		// driver.get("https://www.google.com/");

	}

}
