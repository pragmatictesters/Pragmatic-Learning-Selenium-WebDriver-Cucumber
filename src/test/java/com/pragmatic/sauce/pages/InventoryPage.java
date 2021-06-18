package com.pragmatic.sauce.pages;

import com.github.javafaker.Faker;
import com.pragmatic.sauce.RunTimeData;
import org.openqa.selenium.By;
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


    private final WebDriver webDriver;

    @FindBy(css = "button.btn_inventory")
    List<WebElement> lstAddToCartButtons;

    @FindBy(css = "span.shopping_cart_badge")
    WebElement eleCartIcon;

    private Faker faker = new Faker();


    private int randomButtonIndex;
    private WebElement randomButton;


    public InventoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public String getCurrentURL() {
        return webDriver.getCurrentUrl();
    }

    public void clickAddToCartButton() {
        System.out.println("InventoryPage.clickAddToCartButton");
        System.out.println("randomButtonIndex = " + randomButtonIndex);
        randomButton = lstAddToCartButtons.get(randomButtonIndex);
        randomButton.click();
    }

    public String getTheButtonLabel() {
        System.out.println(lstAddToCartButtons.size());
        String buttonLabel = lstAddToCartButtons.get(randomButtonIndex).getText();
        return buttonLabel;
    }

    public String getItemCount() {
        System.out.println(lstAddToCartButtons.size());
        return eleCartIcon.getText();
    }

    public void clickCartIcon() {
        eleCartIcon.click();
    }

    public void takeNoteOfAnItem() {
        randomButtonIndex = faker.number().numberBetween(0, lstAddToCartButtons.size() - 1);
        randomButton = lstAddToCartButtons.get(randomButtonIndex);
        WebElement eleItemName = randomButton.findElement(By.xpath("//ancestor::div[@class='inventory_item']/following::div[@class='inventory_item_name']"));
        RunTimeData.selectedItemName = eleItemName.getText();
    }
}
