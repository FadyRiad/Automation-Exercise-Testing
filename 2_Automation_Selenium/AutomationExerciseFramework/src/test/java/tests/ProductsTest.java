package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    @Test
    public void verifyAllProductsAndProductDetails() {

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.openProductsPage();

        Assert.assertTrue(
                productsPage.isAllProductsVisible(),
                "All Products page is not displayed"
        );

        productsPage.openFirstProductDetails();

        Assert.assertTrue(
                productsPage.isProductDetailsVisible(),
                "Product details page is not displayed"
        );
    }

    @Test
    public void searchProductTest() {

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.openProductsPage();

        productsPage.searchProduct("Blue Top");

        Assert.assertTrue(
                productsPage.isSearchResultVisible(),
                "Search results are not displayed"
        );
    }
}