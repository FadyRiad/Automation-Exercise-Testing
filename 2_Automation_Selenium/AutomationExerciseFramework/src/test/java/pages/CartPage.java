package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // --- Locators ---
    private final By cartBtn = By.xpath("//a[@href='/view_cart']");
    private final By proceedToCheckout = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    private final By cartTable = By.id("cart_info_table");
    private final By quantityField = By.cssSelector(".cart_quantity button");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // --- Actions & Methods ---

    public void openCart() {
        // Explicit wait to ensure the cart button is interactable
        wait.until(ExpectedConditions.elementToBeClickable(cartBtn)).click();
        handleVignetteAd("/view_cart");
    }

    public void clickProceedToCheckout() {
        handleVignetteAd("/view_cart");

        // Wait until the button is ready in the DOM
        WebElement checkoutBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(proceedToCheckout)
        );

        // Fix: Use JavaScript to click directly on the DOM element, bypassing ad overlays
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutBtn);
    }

    public boolean isProductDisplayed() {
        try {
            // Replaced raw findElement to prevent instant test failures on slow renders
            return wait.until(ExpectedConditions.visibilityOfElementLocated(cartTable)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getProductQuantity() {
        // Wait until the text is populated inside the element before grabbing it
        WebElement quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityField));
        return quantity.getText();
    }

    // --- Ad Handling Utility ---
    private void handleVignetteAd(String fallbackPath) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.urlContains("#google_vignette"));
        } catch (Exception e) {
            // No URL fragment ad intercepted execution flow
        }

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("#google_vignette")) {
            String cleanUrl = currentUrl.split("#")[0];
            if (cleanUrl.equals("https://automationexercise.com/") && fallbackPath != null) {
                cleanUrl = "https://automationexercise.com" + fallbackPath;
            }
            driver.get(cleanUrl);
        }
    }
}