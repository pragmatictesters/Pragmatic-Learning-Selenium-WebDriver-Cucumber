package com.pragmatic.sauce;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class TestBase {

    public static WebDriver webDriver;

    public TestBase() {
        if (webDriver==null) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }
    }

    public void clearBrowser() {
        webDriver.manage().deleteAllCookies();
        webDriver.get("chrome://settings/clearBrowserData");
        webDriver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
    }
}
