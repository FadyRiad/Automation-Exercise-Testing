package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SubscriptionPage {
    private final WebDriver driver;

    private final By subscriptionEmailField = By.id("susbscribe_email");
    private final By subscribeButton = By.id("subscribe");
    private final By successAlert = By.id("success-subscribe");

    public SubscriptionPage(WebDriver driver) {
        this.driver = driver;
    }

    public SubscriptionPage scrollToFooter() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return this;
    }

    public SubscriptionPage enterSubscriptionEmail(String email) {
        driver.findElement(subscriptionEmailField).sendKeys(email);
        return this;
    }

    public SubscriptionPage clickSubscribe() {
        driver.findElement(subscribeButton).click();
        return this;
    }

    public String getSuccessAlertText() {
        return driver.findElement(successAlert).getText();
    }
}