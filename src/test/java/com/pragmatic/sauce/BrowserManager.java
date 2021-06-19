package com.pragmatic.sauce;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Collections;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class BrowserManager {

    private static boolean driver_setup_completed = false;

    public static WebDriver getBrowser(String browser_name) {

        if (browser_name.isEmpty() || browser_name.isBlank()) {
            System.exit(-1);
        }
        if (!driver_setup_completed) {
            setupBrowserDriver(browser_name);
        }

        return launchBrowser(browser_name);

    }

    private static WebDriver launchBrowser(String browser_name) {
        WebDriver driver = null;

        switch (browser_name.toLowerCase()) {
            case "chrome" , "google-chrome" -> {
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("useAutomationExtension", false);
                options.setExperimentalOption("excludeSwitches",
                        Collections.singletonList("enable-automation"));
                driver = new ChromeDriver(options);
            }case "chrome-headless"  -> {
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                driver = new ChromeDriver(options);
            } case  "firefox" -> driver = new FirefoxDriver();
            case  "firefox-headless" -> {
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(true);
                driver = new FirefoxDriver(options);
            }case  "edge" -> driver = new EdgeDriver();
            case  "ie" -> {
                driver = new InternetExplorerDriver();
            }case  "safari" -> {
                driver = new SafariDriver();
            }case  "opera" -> {
                driver = new OperaDriver();
            }default -> {
                System.exit(-1);
            }

        }

        driver.manage().window().maximize();
        return driver;
    }

    private static void setupBrowserDriver(String browser_name) {

        switch (browser_name.toLowerCase()) {
            case "chrome" , "google-chrome", "chrome-headless" -> {
                WebDriverManager.chromedriver().setup();
            } case  "firefox", "firefox-headless" -> {
                WebDriverManager.firefoxdriver().setup();
            }case  "edge" -> {
                WebDriverManager.edgedriver().setup();
            }case  "ie" -> {
                WebDriverManager.iedriver().setup();
            }case  "safari" -> {
                //NOT REQUIRED
            }case  "opera" -> {
                WebDriverManager.operadriver().setup();
            }default -> {
                System.exit(-1);
            }
        }
        driver_setup_completed= true;
    }
}
