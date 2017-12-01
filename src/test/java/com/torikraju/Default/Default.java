package com.torikraju.Default;

import WebDriverSetup.WebDriverSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Default {

    private WebDriver driver;

    @Before
    public void init() {

        driver = new WebDriverSetup().intialization("chrome");
    }

    @Test
    public void tests() {
        System.out.printf("hello form default");
    }

    @After
    public void close() throws InterruptedException {
        driver.close();
    }
}
