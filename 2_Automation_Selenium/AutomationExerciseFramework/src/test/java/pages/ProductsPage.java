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

    private By firstProductAddToCart =
            By.xpath("(//a[contains(text(),'Add to cart')])[1]");

    private By viewCartButton =
            By.xpath("//u[contains(text(),'View Cart')]");

    public void addFirstProduct() {

        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(firstProductAddToCart)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", btn);

        btn.click();
    }

    public void clickViewCart() {

        WebElement viewCart = wait.until(
                ExpectedConditions.elementToBeClickable(viewCartButton)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", viewCart);
    }
}