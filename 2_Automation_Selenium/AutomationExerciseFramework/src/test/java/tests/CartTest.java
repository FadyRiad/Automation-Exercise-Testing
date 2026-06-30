package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

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
        Assert.assertEquals(actualQuantity, "1", "Product quantity in cart is incorrect!");
    }
}