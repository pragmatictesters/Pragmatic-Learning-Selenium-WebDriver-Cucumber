package com.pragmatic.sauce.steps;

import com.pragmatic.sauce.TestBase;
import com.pragmatic.sauce.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class LoginSteps  extends TestBase {


    private LoginPage loginPage;


    @Given("User has accessed the login page")
    public void userHasAccessedTheLoginPage() {
        webDriver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(webDriver);
    }



    @When("User type the username {string}")
    public void  userTypeTheUsername(String username) {
        loginPage.typeUsername(username);
    }

    @And("User type the password {string}")
    public void userTypeThePassword(String password) {
        loginPage.typePassword(password);
    }

    @And("User click the login button")
    public void userClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("User should see error message {string}")
    public void userShouldSeeErrorMessage(String expectedError) {
        String actualError = loginPage.getError();
        Assert.assertEquals(actualError, expectedError);
    }

    @Then("User should be directed to the login page {string}")
    public void userShouldBeDirectedToTheLoginPage(String expected_url) {
        String actual_url = loginPage.getCurrentURL();
        Assert.assertTrue(actual_url.matches("^%s/?$".formatted(expected_url)));
    }

    @And("User should see the login panel")
    public void userShouldSeeTheLoginPanel() {
       boolean isLoaded = loginPage.isLoginPageLoaded();
       Assert.assertTrue(isLoaded);
    }
}
