package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import utils.JsonDataReader;
import utils.TestListener;

@Listeners(TestListener.class)
public class CartTest extends BaseTest {

    @Test
    public void testAddProductToCartSuccessfully() {
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        productsPage.openProductsPage();
        productsPage.addFirstProduct();
        productsPage.clickViewCart();

        Assert.assertTrue(cartPage.isProductDisplayed(), "Product was not added to the cart!");
    }

    @Test
    public void testVerifyProductQuantityInCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        productsPage.openProductsPage();
        productsPage.addFirstProduct();
        productsPage.clickViewCart();

        String actualQuantity = cartPage.getProductQuantity();
        String expectedQuantity = JsonDataReader.getTestData("expectedQuantity");

        Assert.assertEquals(actualQuantity, expectedQuantity, "Product quantity in cart is incorrect!");
    }
}