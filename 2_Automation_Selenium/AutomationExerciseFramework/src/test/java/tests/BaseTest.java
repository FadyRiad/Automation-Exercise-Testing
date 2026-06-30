package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://automationexercise.com/");
    }

    public void handleVignetteAd(){
        try {
            if (driver.getCurrentUrl().contains("#google_vignette")) {
                String cleanUrl = driver.getCurrentUrl().split("#")[0];
                driver.get(cleanUrl);
            }
        }
        catch (Exception e){
            // Handle context switch or alert exceptions gracefully
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}