package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By registerLoginBtn = By.xpath("//u[contains(text(),'Register') or contains(text(),'Login')]");
    By placeOrderBtn = By.xpath("//a[contains(text(),'Place Order')]");

    By nameOnCard = By.name("name_on_card");
    By cardNumber = By.name("card_number");
    By cvc = By.name("cvc");
    By expiryMonth = By.name("expiry_month");
    By expiryYear = By.name("expiry_year");
    By payBtn = By.id("submit");

    public void clickRegisterLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLoginBtn)).click();
    }

    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }

    public void fillPayment(String name, String number, String cvv, String month, String year) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(nameOnCard)).sendKeys(name);
        driver.findElement(cardNumber).sendKeys(number);
        driver.findElement(cvc).sendKeys(cvv);
        driver.findElement(expiryMonth).sendKeys(month);
        driver.findElement(expiryYear).sendKeys(year);
    }

    public void pay() {
        wait.until(ExpectedConditions.elementToBeClickable(payBtn)).click();
    }
}