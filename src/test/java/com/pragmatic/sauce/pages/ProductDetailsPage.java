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
public class ProductDetailsPage {

    private final WebDriver webDriver;

    @FindBy(css = "div.inventory_details_price")
    WebElement elePrice;

    @FindBy(css = "div.inventory_details_name")
    WebElement eleItemName;

    @FindBy(css = "div.inventory_details_desc")
    WebElement eleItemDetail;


    public ProductDetailsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }


    public String getCurrentURL() {
        return webDriver.getCurrentUrl();
    }

    public String getItemPrice() {
        return elePrice.getText().trim();
    }

    public String getItemName() {
        return eleItemName.getText().trim();
    }

    public String getDescription() {
        return eleItemDetail.getText();
    }
}
