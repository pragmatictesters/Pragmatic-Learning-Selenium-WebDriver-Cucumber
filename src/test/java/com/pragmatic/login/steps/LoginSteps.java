package com.pragmatic.login.steps;

import com.pragmatic.login.SauceTestBase;
import com.pragmatic.login.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class LoginSteps extends SauceTestBase {

    private LoginPage loginPage;

    @Given("User has accessed the login page {string}")
    public void userHasAccessedTheLoginPage(String base_url) {
        driver.get(base_url);
        loginPage  = new LoginPage(driver);
    }

    @When("User type username {string}")
    public void userTypeUsername(String username) {
        loginPage.typeUsername(username);
        
    }

    @And("User type password {string}")
    public void userTypePassword(String password) {
        loginPage.typePassword(password);
        
    }

    @And("User click the login button")
    public void userClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("User should see error {string}")
    public void userShouldSeeError(String expected_error) {
        String actual_error = loginPage.getError();
        Assert.assertEquals(actual_error, expected_error);
    }
}
