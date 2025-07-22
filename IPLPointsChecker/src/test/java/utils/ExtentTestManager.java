package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;

public class ExtentTestManager {
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void startTest(String testName) {
        ExtentReports extent = ExtentManager.getInstance();
        ExtentTest test = extent.createTest(testName);
        extentTest.set(test);
    }

    public static void endTest() {
        extentTest.remove();
    }
}
