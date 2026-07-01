package tests;

import base.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.TestListener;

@Listeners(TestListener.class)
public class CheckoutTest extends BaseTest {

    @Test
    public void placeOrderWhileCheckout() {
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        driver.navigate().to("https://automationexercise.com/products");
        productsPage.addFirstProduct();

        productsPage.clickViewCart();

        cartPage.clickProceedToCheckout();

        checkoutPage.clickRegisterLogin();
    }
}