package com.pragmatic.login.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class InventoryPage {

    private final WebDriver driver;
    private Faker faker = new Faker();


    @FindBy(css = "button.btn_inventory")
    List<WebElement> lstAddToCartButton;

    @FindBy(css = ".shopping_cart_badge")
    WebElement eleCartIcon;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl().trim();
    }

    public void clickOnAddToCartButton() {
        int randomProductID;
        randomProductID = faker.number().numberBetween(0, lstAddToCartButton.size()-1);
        lstAddToCartButton.get(randomProductID).click();
    }

    public void clickCartIcon() {
        eleCartIcon.click();
    }
}
