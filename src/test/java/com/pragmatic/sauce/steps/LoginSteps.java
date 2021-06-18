package com.pragmatic.sauce.steps;

import com.pragmatic.sauce.TestBase;
import com.pragmatic.sauce.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class LoginSteps  extends TestBase {


    private LoginPage loginPage;

    @Before
    public void before(Scenario scenario){

    }


    @After
    public void after(Scenario scenario){

    }

    @Given("User has accessed the login page")
    public void userHasAccessedTheLoginPage() {
        webDriver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(webDriver);

    }

    @When("User type the username {string}")
    public void userTypeTheUsername(String username) {
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
}
