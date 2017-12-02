package com.torikraju.Selenium.JQuery;

import WebDriverSetup.WebDriverHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by torikul on 11/23/2017.
 */
public class Resizing_Element {

    private HelperClass helperClass;
    private WebDriver driver;

    @Before
    public void init() {
        this.driver = new WebDriverHelper().intialization("chrome");
        this.driver.manage().window().maximize();
        this.helperClass = new HelperClass();

    }

    @Test
    public void resize_element_test() throws Throwable {
        driver.get("http://only-testing-blog.blogspot.in/2014/09/drag-and-drop.html");
        helperClass.waitForJSandJQueryToLoad(driver);

        WebElement resizeElement = driver.findElement(By.xpath("//*[contains(@class,'ui-icon-gripsmall-diagonal-se')]"));
        new Actions(driver).dragAndDropBy(resizeElement, 200, 200).build().perform();

        Thread.sleep(3000);
        //another way ot resize element
        new Actions(driver).clickAndHold(resizeElement).moveByOffset(-200, -100).build().perform();

    }

    @After
    public void close() throws Throwable {
        Thread.sleep(5000);
        driver.close();
    }
}
