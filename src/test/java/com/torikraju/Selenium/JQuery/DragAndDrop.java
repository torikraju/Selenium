package com.torikraju.Selenium.JQuery;

import WebDriverSetup.WebDriverHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by torikul on 11/23/2017.
 */
public class DragAndDrop {

    private WebDriver driver;

    @Before
    public void init() {
        driver = new WebDriverHelper().intialization("chrome");
        driver.manage().window().maximize();

    }

    @Test
    public void dragAndDrop_Test() {
        driver.get("http://only-testing-blog.blogspot.in/2014/09/drag-and-drop.html");
        waitForJSandJQueryToLoad();

        WebElement dragElement = driver.findElement(By.id("dragdiv"));
        WebElement dropElement = driver.findElement(By.id("dropdiv"));

        //one way to do it
/*        Actions actions = new Actions(driver);
        Action dragNdrop = actions.clickAndHold(dragElement)
                .moveToElement(dropElement)
                .release(dropElement)
                .build();
        dragNdrop.perform();*/

        //another way to do it
        new Actions(driver).dragAndDrop(dragElement, dropElement).build().perform();

        Assert.assertEquals("Dropped!", driver.findElement(By.xpath("//div[@id='dropdiv']/p")).getText());

    }

    @After
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    public void waitForJSandJQueryToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        wait.until(ExpectedConditions.and(jQueryLoad, jsLoad));
    }
}
