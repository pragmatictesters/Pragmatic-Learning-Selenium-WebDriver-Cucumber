package com.pragmatic.sauce.steps;

import com.pragmatic.sauce.RunTimeData;
import com.pragmatic.sauce.TestBase;
import com.pragmatic.sauce.pages.CartPage;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class CartSteps extends TestBase {

    private CartPage cartPage;

    @BeforeStep
    public void beforeStep(){
        if (cartPage==null) cartPage = new CartPage(getWebDriver());
    }

    @Then("User should be directed to the cart page {string}")
    public void userShouldBeDirectedToTheCartPage(String expected_url) {
        String actual_url = cartPage.getCurrentURL();
        Assert.assertEquals(actual_url, expected_url);
    }

    @And("Item count in the cart page should be {string}")
    public void itemCountInTheCartPageShouldBe(String expected_item_count) {
        String actual_item_count = cartPage.getItemCount();
        Assert.assertEquals(actual_item_count, expected_item_count);
    }

    @And("The item name should be matched with the selected item")
    public void theItemNameShouldBeMatchedWithTheSelectedItem() {
        String actual_item_name = cartPage.getItemName();
        Assert.assertEquals(actual_item_name, RunTimeData.selectedItemName);
    }

    @And("Item price in the cart should match")
    public void itemPriceInTheCartShouldMatch() {
        String actual_item_price = cartPage.getItemPrice();
        Assert.assertEquals(actual_item_price, RunTimeData.selectedItemPrice);

    }

    @And("Item name in the cart should match")
    public void itemNameInTheCartShouldMatch() {
        String actual_item_name = cartPage.getItemName();
        Assert.assertEquals(actual_item_name, RunTimeData.selectedItemName);
    }


    @And("Item description in the cart should match")
    public void itemDescriptionInTheCartShouldMatch() {
        String actual_item_description = cartPage.getItemDescription();
        Assert.assertEquals(actual_item_description, RunTimeData.selectedItemDescription);
    }
}
