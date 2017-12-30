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
public class Move_Slider {

    private HelperClass helperClass;
    private WebDriver driver;

    @Before
    public void init() {
        this.driver = new WebDriverHelper().intialization("chrome");
        this.driver.manage().window().maximize();
        this.helperClass = new HelperClass();

    }

    @Test
    public void slider_test() throws Throwable {
        driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
        helperClass.waitForJSandJQueryToLoad(driver);

        WebElement slider = driver.findElement(By.xpath("//span[contains(@class, 'ui-slider-handle')]"));

        // new Actions(driver).dragAndDropBy(slider, 100, 0).build().perform();
        Thread.sleep(5000);
        //another way to move slider
        new Actions(driver).clickAndHold(slider).moveByOffset(100, 0).release().perform();
        Thread.sleep(5000);

        //to move slider to a particular location:
/*      Long width = (Long) ((JavascriptExecutor) driver).executeScript("return $('#slider').width();");
        new Actions(driver).clickAndHold(slider).moveByOffset((int) ((width * 50) / 100), 0).release().perform();*/
    }

    @After
    public void close() throws Throwable {
        Thread.sleep(5000);
        driver.close();
    }
}
