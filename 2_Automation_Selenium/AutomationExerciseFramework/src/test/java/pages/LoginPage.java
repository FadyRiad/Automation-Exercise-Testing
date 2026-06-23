package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
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
        driver.findElement(signupLoginLink).click();
    }

    public void register(String name, String email) {
        driver.findElement(signupName).sendKeys(name);
        driver.findElement(signupEmail).sendKeys(email);
        driver.findElement(signupBtn).click();
    }

    public void login(String email, String password) {
        driver.findElement(loginEmail).sendKeys(email);
        driver.findElement(loginPassword).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public void clickLogout() {
        driver.findElement(logoutBtn).click();
    }

    public boolean isLoggedIn() {
        return driver.findElements(loggedInAsText).size() > 0;
    }

    public boolean isLoginErrorDisplayed() {
        return driver.findElements(loginErrorMsg).size() > 0;
    }

    public boolean isSignupErrorDisplayed() {
        return driver.findElements(signupErrorMsg).size() > 0;
    }
}