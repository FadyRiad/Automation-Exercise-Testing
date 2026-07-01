package utils;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentReportManager.getReportInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName());
        ExtentReportManager.getTest().log(Status.INFO, "Test execution started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().log(Status.PASS, "Test passed successfully.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.getTest().log(Status.FAIL, "Test failed due to: " + result.getThrowable());

        try {
            Object testClass = result.getInstance();
            WebDriver driver = ((BaseTest) testClass).getDriver();

            if (driver != null) {
                String screenshotPath = takeScreenshot(driver, result.getMethod().getMethodName());
                ExtentReportManager.getTest().addScreenCaptureFromPath("../" + screenshotPath);
            }
        } catch (Exception e) {
            ExtentReportManager.getTest().log(Status.WARNING, "Failed to attach screenshot to report: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().log(Status.SKIP, "Test skipped.");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flushReport();
    }

    private String takeScreenshot(WebDriver driver, String methodName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destPath = "target/ExtentReports/screenshots/" + methodName + "_" + System.currentTimeMillis() + ".png";
        File destFile = new File(destPath);
        try {
            FileHandler.copy(srcFile, destFile);
        } catch (IOException e) {
            destPath = "";
        }
        return "screenshots/" + destFile.getName();
    }
}