package hooks;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import base.BaseClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

	@After
	public void takeScreenshotOnFailure(Scenario scenario) {
	    if (scenario.isFailed()) {
	        try {
	            TakesScreenshot ts = (TakesScreenshot) BaseClass.getDriver();
	            byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);

	            // Save file
	            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	            String screenshotName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";
	            String screenshotFolder = "target/screenshots/";
	            String fullPath = screenshotFolder + screenshotName;

	            Files.createDirectories(Paths.get(screenshotFolder));
	            Files.write(Paths.get(fullPath), screenshotBytes);

	            // 🟢 Attach to Extent Report
	            ExtentCucumberAdapter.addTestStepLog("Screenshot on failure:");
	            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath("../screenshots/" + screenshotName);

	            // 🟡 (Optional) Attach to Cucumber scenario
	            scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

}
