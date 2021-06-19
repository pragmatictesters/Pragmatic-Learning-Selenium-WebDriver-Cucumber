package com.pragmatic.examples;

import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class TestAssertionsWithRegex {

    @Test
    public void testAssertions() {
        String expected = "https://www.saucedemo.com";
        String actual = "https://www.saucedemo.com";
        Assert.assertTrue(actual.matches("^%s/?$".formatted(expected)));
        actual = "https://www.saucedemo.com/";
        Assert.assertTrue(actual.matches("^%s/?$".formatted(expected)));
        actual = "https://www.saucedemo.com/a";
        Assert.assertFalse(actual.matches("^%s/?$".formatted(expected)));
     }
}
