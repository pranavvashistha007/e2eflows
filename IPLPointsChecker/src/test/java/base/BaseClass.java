package base;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;



import org.apache.commons.io.FileUtils;
import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.text.SimpleDateFormat;
import java.util.Date;


public class BaseClass {

	 public static WebDriver driver;
	 public static WebDriver getDriver() {
	        return driver;
	    }

	public void launchBrowser(String url)  {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);

	}

	public void quiteBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

	public static void hardWait(int waitMS) {
		try {
			Thread.sleep(waitMS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String captureScreenshot(WebDriver driver, String screenshotBaseName) {
	    try {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        
	        // Add timestamp to filename
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        String screenshotName = screenshotBaseName + "_" + timestamp + ".png";
	        String path = System.getProperty("user.dir") + "/target/Screenshots/" + screenshotName;

	        File destination = new File(path);
	        FileUtils.copyFile(source, destination);
	        return path;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}


}
