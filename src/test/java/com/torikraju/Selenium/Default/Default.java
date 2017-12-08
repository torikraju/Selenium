package com.torikraju.Selenium.Default;

import Framework.Helper.Selenium_framework;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Default {

    private Selenium_framework s;

    public Default() {
        this.s = new Selenium_framework();
    }

    @Before
    public void setup() {
        s.setup();
    }

    @Test
    public void defaultTest() {
        s.browseURL("http://www.baeldung.com/thymeleaf-in-spring-mvc");
        System.out.println();
        //class name


    }

    @After
    public void close() {
        s.close();
    }


}
