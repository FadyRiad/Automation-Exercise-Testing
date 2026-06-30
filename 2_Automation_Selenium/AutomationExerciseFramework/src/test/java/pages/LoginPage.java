package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait; // Added to handle synchronization

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialized here
    }

    // --- Navigation ---
    By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");

    // --- Signup Locators ---
    By signupName = By.name("name");
    By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    By signupBtn = By.xpath("//button[contains(text(),'Signup')]");

    // --- Login Locators ---
    By loginEmail = By.xpath("//input[@data-qa='login-email']");
    By loginPassword = By.xpath("//input[@data-qa='login-password']");
    By loginBtn = By.xpath("//button[contains(text(),'Login')]");

    // --- Logout & Validation Locators ---
    By logoutBtn = By.xpath("//a[contains(text(),'Logout')]");
    By loggedInAsText = By.xpath("//a[contains(text(),'Logged in as')]");
    By loginErrorMsg = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
    By signupErrorMsg = By.xpath("//p[contains(text(),'Email Address already exist!')]");

    // --- Actions ---
    public void clickRegisterLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(signupLoginLink)).click();
        handleVignetteAd();
    }

    public void register(String name, String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupName)).sendKeys(name);
        driver.findElement(signupEmail).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(signupBtn)).click();
        handleVignetteAd(); // Clears any interstitial ads after clicking signup
    }

    public void login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmail)).sendKeys(email);
        driver.findElement(loginPassword).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        handleVignetteAd(); // Clears any interstitial ads after clicking login
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
    }

    public boolean isLoggedIn() {
        handleVignetteAd();
        try {
            // Replaced instant check with an explicit wait to allow page stabilization
            return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInAsText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginErrorDisplayed() {
        handleVignetteAd();
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(loginErrorMsg)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSignupErrorDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(signupErrorMsg)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private void handleVignetteAd() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.urlContains("#google_vignette"));
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("#google_vignette")) {
                driver.get(currentUrl.split("#")[0]); // Navigates to a clean URL instead of refreshing
            }
        } catch (Exception e) {
            // Quietly ignore if no ad appears
        }
    }
}