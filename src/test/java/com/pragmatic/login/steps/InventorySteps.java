package com.pragmatic.login.steps;

import com.pragmatic.login.SauceTestBase;
import com.pragmatic.login.pages.InventoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class InventorySteps  extends SauceTestBase {

    private InventoryPage inventoryPage;

    @Then("User should be directed to inventory page {string}")
    public void userShouldBeDirectedToInventoryPage(String expected_url) {
        inventoryPage = new InventoryPage(driver);
        String actual_url = inventoryPage.getCurrentURL();
        Assert.assertEquals(actual_url, expected_url);
     }

    @When("User click on an Add to cart button")
    public void userClickOnAnAddToCartButton() {
        inventoryPage.clickOnAddToCartButton();
    }

    @And("User click on the cart icon on the top of the page")
    public void userClickOnTheCartIconOnTheTopOfThePage() {
        inventoryPage.clickCartIcon();
    }
}
