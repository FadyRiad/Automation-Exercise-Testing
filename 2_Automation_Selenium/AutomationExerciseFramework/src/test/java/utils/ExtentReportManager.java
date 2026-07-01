package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    public static ExtentReports getReportInstance() {
        if (extent == null) {
            String reportPath = System.getProperty("user-dir", "target/ExtentReports/AutomationReport.html");
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("Automation Test Execution Report");
            sparkReporter.config().setReportName("Regression Test Suite");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Operating System", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Framework Framework", "Selenium WebDriver 4.28.0");
        }
        return extent;
    }

    public static synchronized ExtentTest createTest(String testName) {
        ExtentTest test = getReportInstance().createTest(testName);
        testThread.set(test);
        return test;
    }

    public static synchronized ExtentTest getTest() {
        return testThread.get();
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}