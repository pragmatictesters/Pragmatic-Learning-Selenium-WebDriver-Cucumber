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

    private static WebDriver webDriver;


    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        TestBase.webDriver = webDriver;
    }

    public void clearBrowser() {
        webDriver.manage().deleteAllCookies();
        webDriver.get("chrome://settings/clearBrowserData");
        webDriver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
    }
}
