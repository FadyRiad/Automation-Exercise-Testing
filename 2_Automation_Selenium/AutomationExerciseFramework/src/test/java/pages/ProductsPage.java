package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // --- Locators ---
    private By firstProductAddToCart = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    private By viewCartButton = By.xpath("//u[contains(text(),'View Cart')]");
    private By productsButton = By.xpath("//a[@href='/products']");
    private By allProductsTitle = By.xpath("//h2[contains(text(),'All Products')]");
    private By firstViewProduct = By.xpath("(//a[contains(text(),'View Product')])[1]");
    private By productDetails = By.xpath("//div[@class='product-information']");
    private By searchInput = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By searchedProductsTitle = By.xpath("//h2[contains(text(),'Searched Products')]");

    // --- Actions & Methods ---

    public void openProductsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(productsButton)).click();
        handleVignetteAd("/products"); // Smart recovery path added
    }

    public boolean isAllProductsVisible() {
        handleVignetteAd("/products");
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsTitle)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void searchProduct(String productName) {
        handleVignetteAd("/products");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys(productName);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        handleVignetteAd("/products");
    }

    public boolean isSearchResultVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProductsTitle)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void openFirstProductDetails() {
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(firstViewProduct));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product);
        handleVignetteAd(null); // Dynamic paths like /product_details/1 keep their path automatically
    }

    public boolean isProductDetailsVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(productDetails)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void addFirstProduct() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(firstProductAddToCart));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    public void clickViewCart() {
        handleVignetteAd("/view_cart");
        WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCart);
    }

    // --- Path-Aware Ad Handling Utility ---
    private void handleVignetteAd(String fallbackPath) {
        try {
            // Check quickly if an ad overlay hijacked the current URL
            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.urlContains("#google_vignette"));
        } catch (Exception e) {
            // No ad string detected in URL, carry on
        }

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("#google_vignette")) {
            String cleanUrl = currentUrl.split("#")[0];

            // FIX: If the ad trapped us on the root homepage domain, reconstruct the targeted destination
            if (cleanUrl.equals("https://automationexercise.com/") && fallbackPath != null) {
                cleanUrl = "https://automationexercise.com" + fallbackPath;
            }

            driver.get(cleanUrl);
        }
    }
}