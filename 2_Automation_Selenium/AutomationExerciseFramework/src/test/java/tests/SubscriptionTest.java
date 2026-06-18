package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SubscriptionPage;

public class SubscriptionTest extends BaseTest {

    @Test
    public void testHomePageSubscription() {
        SubscriptionPage subPage = new SubscriptionPage(driver);

        // Scroll to footer and subscribe
        subPage.scrollToFooter();
        subPage.enterSubscriptionEmail("fady_test@example.com");
        subPage.clickSubscribe();

        // Verify subscription success alert
        String actualAlert = subPage.getSuccessAlertText();
        Assert.assertEquals(actualAlert, "You have been successfully subscribed!");
    }
}