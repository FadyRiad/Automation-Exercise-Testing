package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    private WebDriver driver;

    // 1. Locators
    private By contactUsLink = By.cssSelector("a[href='/contact_us']");
    private By nameField = By.cssSelector("input[data-qa='name']");
    private By emailField = By.cssSelector("input[data-qa='email']");
    private By subjectField = By.cssSelector("input[data-qa='subject']");
    private By messageField = By.id("message");
    private By submitButton = By.cssSelector("input[data-qa='submit-button']");
    private By successMessage = By.cssSelector(".status.alert.alert-success");

    // 2. Constructor
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Actions
    public void clickContactUs() {
        driver.findElement(contactUsLink).click();
    }

    public void fillContactForm(String name, String email, String subject, String message) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(messageField).sendKeys(message);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
        // Handle the JavaScript alert popup
        driver.switchTo().alert().accept();
    }

    public String getSuccessMessageText() {
        return driver.findElement(successMessage).getText();
    }
}