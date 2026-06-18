package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class ContactUsTest extends BaseTest {

    @Test
    public void testContactUsForm() {
        ContactUsPage contactPage = new ContactUsPage(driver);

        // Execute test steps
        contactPage.clickContactUs();
        contactPage.fillContactForm("Fady Riad", "fady@example.com", "Testing POM", "This is an automated text from Selenium Java.");
        contactPage.clickSubmit();

        // Verify the success message
        String actualMessage = contactPage.getSuccessMessageText();
        Assert.assertEquals(actualMessage, "Success! Your details have been submitted successfully.");
    }
}