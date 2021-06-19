package com.pragmatic.sauce;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class BrowserManager {


    private static ChromeDriver webDriver = null;

    public static WebDriver getBrowser() {
        if (webDriver==null) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }


    public static void closeBrowser() {
        if(webDriver!=null){
            webDriver.quit();
        }
    }
}
