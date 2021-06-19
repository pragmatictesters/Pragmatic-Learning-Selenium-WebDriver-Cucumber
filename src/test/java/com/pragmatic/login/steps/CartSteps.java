package com.pragmatic.login.steps;

import com.pragmatic.login.SauceTestBase;
import com.pragmatic.login.pages.CartPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class CartSteps extends SauceTestBase {

    private CartPage cartPage;

    @Then("User should be directed to cart page {string}")
    public void userShouldBeDirectedToCartPage(String expected_url) {
        cartPage = new CartPage(driver);
        String actual_url = cartPage.getCurrentURL();
        Assert.assertEquals(actual_url, expected_url);
    }
}
