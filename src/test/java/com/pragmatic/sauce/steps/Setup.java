package com.pragmatic.sauce.steps;

import com.pragmatic.sauce.BrowserManager;
import com.pragmatic.sauce.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class Setup extends TestBase {

    @Before
    public void before(){
        System.out.println("Setup.before");
        if (getWebDriver() == null) {
            setWebDriver(BrowserManager.getBrowser("chrome"));
        }
    }

    @After
    public void after(){
        System.out.println("Setup.after");
        WebDriver webDriver = getWebDriver();
        if (webDriver!=null) {
            webDriver.quit();
            setWebDriver(null);
        }
    }

}
