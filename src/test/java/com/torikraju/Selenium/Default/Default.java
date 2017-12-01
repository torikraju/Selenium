package com.torikraju.Selenium.Default;

import WebDriverSetup.WebDriverSetup;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Default {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new WebDriverSetup().intialization("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void defaultTest() {

    }

    @After
    public void close() {
        driver.close();
    }


}
