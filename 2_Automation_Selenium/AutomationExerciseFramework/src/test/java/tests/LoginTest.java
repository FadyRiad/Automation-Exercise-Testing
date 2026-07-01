package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.JsonDataReader;
import utils.TestListener;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage;
    String signupEmail = "judysignup" + System.currentTimeMillis() + "@gmail.com";

    @Test(priority = 1)
    public void testRegisterUser() {
        loginPage = new LoginPage(driver);
        loginPage.clickRegisterLogin();

        String testName = JsonDataReader.getTestData("testName");
        loginPage.register(testName, signupEmail);

        Assert.assertTrue(driver.getCurrentUrl().contains("signup"),
                "Registration page did not load as expected");
    }

    @Test(priority = 2)
    public void testLoginIncorrect() {
        loginPage = new LoginPage(driver);
        loginPage.clickRegisterLogin();

        String wrongEmail = JsonDataReader.getTestData("wrongEmail");
        String wrongPassword = JsonDataReader.getTestData("wrongPassword");
        loginPage.login(wrongEmail, wrongPassword);

        Assert.assertTrue(loginPage.isLoginErrorDisplayed(),
                "Error message should be displayed for incorrect login");
    }

    @Test(priority = 3)
    public void testLoginCorrect() {
        loginPage = new LoginPage(driver);
        loginPage.clickRegisterLogin();

        String testEmail = JsonDataReader.getTestData("testEmail");
        String testPassword = JsonDataReader.getTestData("testPassword");
        loginPage.login(testEmail, testPassword);

        Assert.assertTrue(loginPage.isLoggedIn(),
                "User should be logged in with correct credentials");
    }

    @Test(priority = 4)
    public void testLogoutUser() {
        loginPage = new LoginPage(driver);
        loginPage.clickRegisterLogin();

        String testEmail = JsonDataReader.getTestData("testEmail");
        String testPassword = JsonDataReader.getTestData("testPassword");
        loginPage.login(testEmail, testPassword);

        Assert.assertTrue(loginPage.isLoggedIn(),
                "Login must succeed before logout test");

        loginPage.clickLogout();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "User should be redirected to login page after logout");
    }
}