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
public class CartPage {

    private final WebDriver webDriver;

    @FindBy(css = "div.cart_quantity")
    WebElement eleItemCount;

    @FindBy(css = "div.inventory_item_name")
    WebElement eleItemName;

    @FindBy(css = ".inventory_item_price")
    WebElement eleItemPrice;

    @FindBy(css = ".inventory_item_desc")
    WebElement eleItemDescription;



    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }


    public String getCurrentURL() {
        return webDriver.getCurrentUrl();
    }

    public String getItemCount() {
        return eleItemCount.getText();
    }

    public String getItemName() {
        return eleItemName.getText();
    }

    public String getItemPrice() {
        return  eleItemPrice.getText().trim();
    }

    public String getItemDescription() {
        return eleItemDescription.getText();
    }
}
