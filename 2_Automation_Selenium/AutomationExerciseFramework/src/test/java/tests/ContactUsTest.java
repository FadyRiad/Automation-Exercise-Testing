package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class ContactUsTest extends BaseTest {

    private static final String SUCCESS_MESSAGE = "Success! Your details have been submitted successfully.";

    @DataProvider(name = "contactFormData")
    public Object[][] getContactFormData() {
        return new Object[][]{
                {"Fady Riad", "fady.riad@outlook.com", "Bulk Order Inquiry", "Hello, I would like to inquire about corporate pricing and delivery timelines. Thanks."}
        };
    }

    @Test(priority = 1, groups = {"smoke", "regression"}, dataProvider = "contactFormData")
    public void testSuccessfulContactFormSubmission(String name, String email, String subject, String message) {
        ContactUsPage contactPage = new ContactUsPage(driver);

        contactPage.clickContactUs()
                .fillContactForm(name, email, subject, message)
                .clickSubmit();

        String actualMessage = contactPage.getSuccessMessageText();
        Assert.assertEquals(actualMessage, SUCCESS_MESSAGE, "Contact us form submission failed!");
    }
}