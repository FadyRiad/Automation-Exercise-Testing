package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    By nameOnCard = By.name("name_on_card");
    By cardNumber = By.name("card_number");
    By cvc = By.name("cvc");
    By expiryMonth = By.name("expiry_month");
    By expiryYear = By.name("expiry_year");
    By payBtn = By.id("submit");

    By successMsg = By.xpath("//p[contains(text(),'Your order has been placed')]");

    public void fillPayment(String name, String number, String cvcVal, String month, String year) {
        driver.findElement(nameOnCard).sendKeys(name);
        driver.findElement(cardNumber).sendKeys(number);
        driver.findElement(cvc).sendKeys(cvcVal);
        driver.findElement(expiryMonth).sendKeys(month);
        driver.findElement(expiryYear).sendKeys(year);
    }

    public void pay() {
        driver.findElement(payBtn).click();
    }

    public boolean isOrderSuccess() {
        return driver.findElement(successMsg).isDisplayed();
    }
}