package com.pragmatic.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class SauceTestBase {


    public static WebDriver driver;


    public SauceTestBase() {
        System.out.println("I am in the constructor!");
        if (driver==null) {
            WebDriverManager.chromedriver().setup(); //Setup the browser driver
            driver = new ChromeDriver(); //Launch (open) browser instance
        }
    }
}
