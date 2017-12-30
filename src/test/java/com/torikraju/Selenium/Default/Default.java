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
        s.browseLocalHTML("resources/HTML/Table.html");
        //class name


    }

    @After
    public void close() {
        s.close();
    }


}
