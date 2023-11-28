package testsuite;
/**
 * Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    // 1. userShouldLoginSuccessfullyWithValidCredentials
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");
        // Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");
        // Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        // Verify the text “PRODUCTS”
        verifyText("Products", By.xpath("//span[@class='title']"), "Products");

    }

    // 2. verifyThatSixProductsAreDisplayedOnPage
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");
        // Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");
        // Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        // Verify that six products are displayed on page
        countProduct(By.className("inventory_item"));
        verifyCount(By.className("inventory_item"), 6);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
