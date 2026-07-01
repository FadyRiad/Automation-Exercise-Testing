package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties config;

    // Initialize Log4j2 Logger for this class
    protected static final Logger log = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() throws IOException {
        log.info("Starting Test Execution Configuration...");

        config = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        config.load(fis);
        log.info("Configuration properties loaded successfully.");

        String browserType = config.getProperty("browser").toLowerCase();
        String url = config.getProperty("baseUrl");

        log.info("Initializing browser: " + browserType);
        if (browserType.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        } else if (browserType.equals("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browserType.equals("edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        log.info("Navigating to application URL: " + url);
        driver.get(url);
    }

    public void handleVignetteAd(){
        try {
            if (driver.getCurrentUrl().contains("#google_vignette")) {
                log.warn("Google Vignette ad detected! Attempting to clear it.");
                String cleanUrl = driver.getCurrentUrl().split("#")[0];
                driver.get(cleanUrl);
                log.info("Google Vignette ad cleared successfully.");
            }
        }
        catch (Exception e){
            log.error("Exception occurred while handling Google Vignette ad: " + e.getMessage());
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            log.info("Terminating browser session and closing driver.");
            driver.quit();
        }
    }
}