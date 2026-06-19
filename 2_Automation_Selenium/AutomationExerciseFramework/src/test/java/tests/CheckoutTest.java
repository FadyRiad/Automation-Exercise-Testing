package tests;

import org.testng.annotations.Test;
import pages.*;

public class CheckoutTest extends BaseTest {

    @Test
    public void placeOrderWhileCheckout() {

        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // 1- add product
        driver.navigate().to("https://automationexercise.com/products");
        productsPage.addFirstProduct();

        // 2- view cart
        productsPage.clickViewCart();

        // 3- checkout
        cartPage.clickProceedToCheckout();

        // 4- register/login
        checkoutPage.clickRegisterLogin();


    }
}