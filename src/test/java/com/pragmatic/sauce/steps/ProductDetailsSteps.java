package com.pragmatic.sauce.steps;

import com.pragmatic.sauce.TestBase;
import com.pragmatic.sauce.pages.ProductDetailsPage;
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
public class ProductDetailsSteps extends TestBase {


    private ProductDetailsPage productDetailPage;

    @BeforeStep
    public void beforeStep() {
        if (productDetailPage==null) productDetailPage = new ProductDetailsPage(getWebDriver());
    }

    @Then("User should be directed to the product details page {string}")
    public void userShouldBeDirectedToTheProductDetailsPage(String expected_url) {
        String actual_url = productDetailPage.getCurrentURL();
        Assert.assertTrue(actual_url.contains(expected_url));
    }

    @And("Price of the item should be {string}")
    public void priceOfTheItemShouldBe(String expected_price) {
        String actual_price = productDetailPage.getItemPrice();
        Assert.assertEquals(actual_price, expected_price);
    }

    @And("Item name should be {string}")
    public void itemNameShouldBe(String expected_name) {
        String actual_name = productDetailPage.getItemName();
        Assert.assertEquals(actual_name,expected_name);
    }

    @And("Product description should be {string}")
    public void productDescriptionShouldBe(String expected_description) {
        String actual_description = productDetailPage.getDescription();
        Assert.assertEquals(actual_description, expected_description);
    }
}
