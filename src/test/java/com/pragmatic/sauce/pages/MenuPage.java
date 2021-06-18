package com.pragmatic.sauce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class MenuPage {

    private final WebDriver webDriver;
    private final WebDriverWait wait;

    @FindBy(css = "#react-burger-menu-btn")
    WebElement eleIcon;

    @FindBy(css = "#logout_sidebar_link")
    WebElement eleLogout;

    public MenuPage(WebDriver webDriver) {
        this.webDriver= webDriver;
        PageFactory.initElements(this.webDriver, this);
        wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(10));
    }

    public void clickIcon() {
        eleIcon.click();
    }

    public void clickLogout() {
        wait.until(
                ExpectedConditions.elementToBeClickable(eleLogout)
        ).click();
    }
}
