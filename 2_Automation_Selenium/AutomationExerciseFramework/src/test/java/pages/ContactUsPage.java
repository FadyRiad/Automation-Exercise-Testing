package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    private final WebDriver driver;

    private final By contactUsLink = By.cssSelector("a[href='/contact_us']");
    private final By nameField = By.cssSelector("input[data-qa='name']");
    private final By emailField = By.cssSelector("input[data-qa='email']");
    private final By subjectField = By.cssSelector("input[data-qa='subject']");
    private final By messageField = By.id("message");
    private final By submitButton = By.cssSelector("input[data-qa='submit-button']");
    private final By successMessage = By.cssSelector(".status.alert.alert-success");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ContactUsPage clickContactUs() {
        driver.findElement(contactUsLink).click();
        return this;
    }

    public ContactUsPage fillContactForm(String name, String email, String subject, String message) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(messageField).sendKeys(message);
        return this;
    }

    public ContactUsPage clickSubmit() {
        driver.findElement(submitButton).click();
        driver.switchTo().alert().accept();
        return this;
    }

    public String getSuccessMessageText() {
        return driver.findElement(successMessage).getText();
    }
}