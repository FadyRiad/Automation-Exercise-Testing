package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    // Use a unique email for registration to prevent "Email already exists" errors
    String signupEmail = "judysignup" + System.currentTimeMillis() + "@gmail.com";

    static String testEmail = "judyzaghloul21@gmail.com";
    static String testName = "Judy";
    static String testPassword = "GKryP@LbbWV6eFP";

    @Test(priority = 1)
    public void testRegisterUser() {
        loginPage = new LoginPage(driver);
        loginPage.clickRegisterLogin();
        loginPage.register(testName, signupEmail); // Changed to signupEmail
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"),
                "Registration page did not load as expected");
    }

    @Test(priority = 2)
    public void testLoginIncorrect() {
        loginPage = new LoginPage(driver);
        loginPage.clickRegisterLogin();
        loginPage.login("wrongemail@example.com", "WrongPassword");
        Assert.assertTrue(loginPage.isLoginErrorDisplayed(),
                "Error message should be displayed for incorrect login");
    }

    @Test(priority = 3)
    public void testLoginCorrect() {
        loginPage = new LoginPage(driver);
        loginPage.clickRegisterLogin();
        loginPage.login(testEmail, testPassword);
        Assert.assertTrue(loginPage.isLoggedIn(),
                "User should be logged in with correct credentials");
    }

    @Test(priority = 4)
    public void testLogoutUser() {
        loginPage = new LoginPage(driver);
        loginPage.clickRegisterLogin();
        loginPage.login(testEmail, testPassword);
        Assert.assertTrue(loginPage.isLoggedIn(),
                "Login must succeed before logout test");
        loginPage.clickLogout();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "User should be redirected to login page after logout");
    }
}