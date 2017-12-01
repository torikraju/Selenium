package com.torikraju.Selenium.Anchor;

import WebDriverSetup.WebDriverSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AnchorTest {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new WebDriverSetup().intialization("chrome");

    }

    @Test
    public void anchorTest() {
        driver.get("http://newtours.demoaut.com");

        List<WebElement> elements = driver.findElements(By.tagName("a"));

        elements.forEach((element) -> System.out.println(element.getAttribute("href")));
        // elements.forEach(System.out::println);


    }

    @After
    public void close() {
        driver.close();
    }


}
