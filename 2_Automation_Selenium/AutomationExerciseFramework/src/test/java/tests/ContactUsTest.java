package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import utils.JsonDataReader;
import utils.TestListener;

@Listeners(TestListener.class)
public class ContactUsTest extends BaseTest {

    @DataProvider(name = "contactFormData")
    public Object[][] getContactFormData() {
        return new Object[][]{
                {
                        JsonDataReader.getTestData("contactName"),
                        JsonDataReader.getTestData("contactEmail"),
                        JsonDataReader.getTestData("contactSubject"),
                        JsonDataReader.getTestData("contactMessage")
                }
        };
    }

    @Test(priority = 1, groups = {"smoke", "regression"}, dataProvider = "contactFormData")
    public void testSuccessfulContactFormSubmission(String name, String email, String subject, String message) {
        ContactUsPage contactPage = new ContactUsPage(driver);

        contactPage.clickContactUs()
                .fillContactForm(name, email, subject, message)
                .clickSubmit();

        String actualMessage = contactPage.getSuccessMessageText();
        String successMessage = JsonDataReader.getTestData("successContactMessage");

        Assert.assertEquals(actualMessage, successMessage, "Contact us form submission failed!");
    }
}