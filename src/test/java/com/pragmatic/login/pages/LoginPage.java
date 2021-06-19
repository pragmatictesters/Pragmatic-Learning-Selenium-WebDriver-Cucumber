package com.pragmatic.login.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class LoginPage {

    private final WebDriver driver;

    @FindBy(css = "#user-name")
    WebElement eleUsername;

    @FindBy(css = "#password")
    WebElement elePassword;

    @FindBy(css = "#login-button")
    WebElement eleLoginButton;

    @FindBy(css = "div.error>h3")
    WebElement eleError;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void typeUsername(String username) {
        eleUsername.sendKeys(username);

    }

    public void typePassword(String password) {
        elePassword.sendKeys(password);
    }

    public void clickLoginButton() {
        eleLoginButton.click();
    }

    public String getError() {
        return eleError.getText().trim();
    }
}
