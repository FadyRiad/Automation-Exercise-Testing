package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SubscriptionPage;

public class SubscriptionTest extends BaseTest {

    private static final String EXPECTED_SUBSCRIBE_MSG = "You have been successfully subscribed!";

    @DataProvider(name = "subscriptionData")
    public Object[][] getSubscriptionData() {
        return new Object[][] {
                { "fady.riad@outlook.com" }
        };
    }

    @Test(priority = 2, groups = {"smoke", "regression"}, dataProvider = "subscriptionData")
    public void testSuccessfulHomePageSubscription(String email) {
        SubscriptionPage subPage = new SubscriptionPage(driver);

        String actualAlert = subPage.scrollToFooter()
                .enterSubscriptionEmail(email)
                .clickSubscribe()
                .getSuccessAlertText();

        Assert.assertEquals(actualAlert, EXPECTED_SUBSCRIBE_MSG, "Newsletter subscription failed!");
    }
}