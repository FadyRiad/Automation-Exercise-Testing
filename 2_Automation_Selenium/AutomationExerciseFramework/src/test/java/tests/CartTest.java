package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

public class CartTest extends BaseTest {

    @Test
    public void addProductsInCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        try {
            WebElement ad = driver.findElement(By.id("dismiss-button"));
            ad.click();
        } catch (Exception e) {
        }

        productsPage.openProductsPage();
        productsPage.addFirstProduct();
        productsPage.clickViewCart();

        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"));
    }

    @Test
    public void verifyProductQuantityInCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        try {
            WebElement ad = driver.findElement(By.id("dismiss-button"));
            ad.click();
        } catch (Exception e) {
        }

        productsPage.openProductsPage();
        productsPage.addFirstProduct();
        productsPage.clickViewCart();

        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"));
    }
}