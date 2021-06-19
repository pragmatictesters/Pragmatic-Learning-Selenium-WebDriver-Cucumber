package com.pragmatic.sauce.steps;

import com.pragmatic.sauce.TestBase;
import com.pragmatic.sauce.pages.MenuPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class MenuSteps  extends TestBase {


    private MenuPage menuPage;

    @Before
    public void before(){
        menuPage = new MenuPage(webDriver);
    }

    @When("User clicked on the left top icon")
    public void userClickedOnTheLeftTopIcon() {
        menuPage.clickIcon();
    }

    @And("User click the logout link")
    public void userClickTheLogoutLink() {
        menuPage.clickLogout();
    }

    @And("User reset the application state")
    public void userResetTheApplicationState() {
        menuPage.clickIcon();
        menuPage.clickResetLink();
    }
}
