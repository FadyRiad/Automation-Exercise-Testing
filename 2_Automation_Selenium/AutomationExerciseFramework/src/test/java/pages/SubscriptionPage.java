package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SubscriptionPage {
    private WebDriver driver;

    // 1. Locators
    private By subscriptionEmailField = By.id("susbscribe_email");
    private By subscribeButton = By.id("subscribe");
    private By successAlert = By.id("success-subscribe");

    // 2. Constructor
    public SubscriptionPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Actions
    public void scrollToFooter() {
        // Use JavascriptExecutor to scroll smoothly to the bottom of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void enterSubscriptionEmail(String email) {
        driver.findElement(subscriptionEmailField).sendKeys(email);
    }

    public void clickSubscribe() {
        driver.findElement(subscribeButton).click();
    }

    public String getSuccessAlertText() {
        return driver.findElement(successAlert).getText();
    }
}