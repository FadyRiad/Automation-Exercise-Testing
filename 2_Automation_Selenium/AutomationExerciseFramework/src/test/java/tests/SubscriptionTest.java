package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.SubscriptionPage;
import utils.JsonDataReader;
import utils.TestListener;

@Listeners(TestListener.class)
public class SubscriptionTest extends BaseTest {

    @DataProvider(name = "subscriptionData")
    public Object[][] getSubscriptionData() {
        return new Object[][] {
                { JsonDataReader.getTestData("subscriptionEmail") }
        };
    }

    @Test(priority = 2, groups = {"smoke", "regression"}, dataProvider = "subscriptionData")
    public void testSuccessfulHomePageSubscription(String email) {
        SubscriptionPage subPage = new SubscriptionPage(driver);

        String actualAlert = subPage.scrollToFooter()
                .enterSubscriptionEmail(email)
                .clickSubscribe()
                .getSuccessAlertText();

        String expectedSubscribeMsg = JsonDataReader.getTestData("expectedSubscribeMsg");
        Assert.assertEquals(actualAlert, expectedSubscribeMsg, "Newsletter subscription failed!");
    }
}