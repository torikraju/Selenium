package com.torikraju.Selenium.Explicit_wait;

import Framework.Helper.Selenium_framework;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.annotation.Nullable;

public class Explicit_wait extends Selenium_framework {


    @Before
    public void init() {
        setup();
    }

    @Test
    public void driver_wait_tests() {
        browseLocalHTML("resources/HTML/ajax_test.html");
        findAndTriggerClick("#yes");
        findAndTriggerClick("#buttoncheck");
        System.out.println(findAndGetText(".torik"));

    }

    @After
    public void close() {
        close();
    }
}
