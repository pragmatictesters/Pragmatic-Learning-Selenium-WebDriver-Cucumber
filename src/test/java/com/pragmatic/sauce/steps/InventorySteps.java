package com.pragmatic.sauce.steps;

import com.pragmatic.sauce.TestBase;
import com.pragmatic.sauce.pages.InventoryPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class InventorySteps extends TestBase {

    private InventoryPage inventoryPage;


    @Before
    public void before() {
        inventoryPage = new InventoryPage(webDriver);
    }

    @Then("User should be directed to the inventory page {string}")
    public void userShouldBeDirectedToTheInventoryPage(String expected_url) {
        String actualURL = inventoryPage.getCurrentURL();
        Assert.assertEquals(actualURL, expected_url);
    }

    @When("User click the Add To Cart Button")
    public void userClickTheAddToCartButton() {
        inventoryPage.clickAddToCartButton();
    }

    @Then("The button label should be changed to {string}")
    public void theButtonLabelShouldBeChangedTo(String expected_label) {
        String actualLabel = inventoryPage.getTheButtonLabel();
        Assert.assertEquals(actualLabel, expected_label);
    }

    @And("Items in the shopping cart should be {string}")
    public void itemsInTheShoppingCartShouldBe(String expected_item_count) {
        String actual_item_count = inventoryPage.getItemCount();
        System.out.println("actual_item_count = " + actual_item_count);
        Assert.assertEquals(actual_item_count, expected_item_count);
    }

    @And("Click on the cart icon")
    public void clickOnTheCartIcon() {
        inventoryPage.clickCartIcon();
    }

    @When("User take note of an item")
    public void userTakeNoteOfAnItem() {
        inventoryPage.takeNoteOfAnItem();
    }

    @When("User has clicked product {string}")
    public void userHasClickedProduct(String item_name) {
        inventoryPage.clickItem(item_name);

    }
}
