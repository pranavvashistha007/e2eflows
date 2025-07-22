package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentManager  {
	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Browser", "Chrome");
        }
        return extent;
    }


	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		// ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter ("");

		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
		extent.attachReporter(spark);
		
		extent.createTest("ILP_GetPoints","Description for demo")
        .addScreenCaptureFromPath("extent.png")
        .pass(MediaEntityBuilder.createScreenCaptureFromPath("extent.png").build());
		
		
	}

}
