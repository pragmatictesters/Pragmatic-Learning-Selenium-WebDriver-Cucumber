package com.pragmatic.sauce;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.runner.RunWith;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */

@RunWith(Cucumber.class)
@CucumberOptions (
        features = {"classpath:features/"},
        glue = "com.pragmatic.sauce.steps",
        dryRun = false,
        monochrome = false,
        publish = true,
        tags = "@smoke or @login",
        plugin = {"pretty", "html:target/cucumber.html"}
)
public class RunTests {

    @After
    public void after(){
        System.out.println("I run after everything");
        if (TestBase.webDriver!=null){
            TestBase.webDriver.quit();
        }
    }

}
