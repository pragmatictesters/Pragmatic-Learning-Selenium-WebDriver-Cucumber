package com.pragmatic.sauce.pages;

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

    @FindBy(css = "#user-name")
    WebElement eleUsername;

    @FindBy(css = "#password")
    WebElement elePassword;

    @FindBy(css= "#login-button")
    WebElement eleLoginButton;

    @FindBy(css = ".error-message-container>h3")
    WebElement eleError;

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage typeUsername(String username) {
        eleUsername.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        elePassword.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        eleLoginButton.click();
    }

    public String getError() {
        return eleError.getText().trim();
    }
}
