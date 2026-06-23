package tests;

import org.testng.annotations.Test;
import pages.*;

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