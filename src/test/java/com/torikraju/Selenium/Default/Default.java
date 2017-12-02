package com.torikraju.Selenium.Default;

import WebDriverSetup.WebDriverHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Default {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new WebDriverHelper().intialization("firefox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void defaultTest() {



    }

    @After
    public void close() {
        //driver.close();
    }


}
