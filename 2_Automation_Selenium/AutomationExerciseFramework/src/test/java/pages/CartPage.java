package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartBtn = By.xpath("//a[@href='/view_cart']");
    By proceedToCheckout = By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    public void openCart() {
        driver.findElement(cartBtn).click();
    }

    public void clickProceedToCheckout() {
        driver.findElement(proceedToCheckout).click();
    }
}