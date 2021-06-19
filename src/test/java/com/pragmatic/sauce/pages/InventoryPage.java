package com.pragmatic.sauce.pages;

import com.github.javafaker.Faker;
import com.pragmatic.sauce.RunTimeData;
import com.pragmatic.sauce.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class InventoryPage  {


    private final WebDriver webDriver;
    WebDriverWait wait;

    @FindBy(css = "button.btn_inventory")
    List<WebElement> lstAddToCartButtons;

    @FindBy(css = ".inventory_item_price")
    List<WebElement> lstInventoryItemPrice;

    @FindBy(css = ".inventory_item_name")
    List<WebElement> lstItemName;

    @FindBy(css = ".inventory_item_desc")
    List<WebElement> lstItemDescription;

    @FindBy(css = "span.shopping_cart_badge")
    WebElement eleCartIcon;



    private Faker faker = new Faker();


    private int randomButtonIndex;
    private WebElement randomButton;
    private String strIDSelectedItem;


    public InventoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    public String getCurrentURL() {
        return webDriver.getCurrentUrl();
    }

    public void clickAddToCartButton() {
        randomButtonIndex = faker.number().numberBetween(0, lstAddToCartButtons.size() - 1);
        System.out.println("InventoryPage.clickAddToCartButton");
        System.out.println("randomButtonIndex = " + randomButtonIndex);
        randomButton = lstAddToCartButtons.get(randomButtonIndex);
        strIDSelectedItem = randomButton.getAttribute("id");
        strIDSelectedItem = strIDSelectedItem.replace("add-to-cart", "remove");
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
        wait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.shopping_cart_badge"))
        );
        eleCartIcon.click();
    }


    public void clickItem(String item_name) {
        String item_xpath = "//div[text()='" + item_name +  "']";
        webDriver.findElement(By.xpath(item_xpath)).click();
    }

    public void notePriceOfSelectedItem() {
        WebElement elePrice = lstInventoryItemPrice.get(randomButtonIndex);
        String price = elePrice.getText();
        RunTimeData.selectedItemPrice = price;
    }

    public void noteNameOfTheSelectedItem() {
        WebElement eleItemName = lstItemName.get(randomButtonIndex);
        String itemName = eleItemName.getText();
        RunTimeData.selectedItemName = itemName;
    }


    public void noteDescriptionOfTheSelectedItem() {
        WebElement eleItemDescription = lstItemDescription.get(randomButtonIndex);
        String itemDescriptionText = eleItemDescription.getText();
        RunTimeData.selectedItemDescription = itemDescriptionText;
    }
}
