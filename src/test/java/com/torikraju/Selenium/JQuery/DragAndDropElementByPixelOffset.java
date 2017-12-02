package com.torikraju.Selenium.JQuery;


import WebDriverSetup.WebDriverHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by torikul on 11/23/2017.
 */
public class DragAndDropElementByPixelOffset {

    private HelperClass helperClass;
    private WebDriver driver;

    @Before
    public void init() {
        this.driver = new WebDriverHelper().intialization("chrome");
        this.driver.manage().window().maximize();
        this.helperClass = new HelperClass();

    }

    @Test
    public void dragAndDrop_pixel_Test() throws Throwable {
        driver.get("http://only-testing-blog.blogspot.in/2014/09/drag-and-drop.html");
        helperClass.waitForJSandJQueryToLoad(driver);

        WebElement dragElement = driver.findElement(By.id("dragdiv"));
        WebElement dropElement = driver.findElement(By.id("dropdiv"));

        new Actions(driver).dragAndDropBy(dragElement, 100, 0).build().perform();
        helperClass.waitForJSandJQueryToLoad(driver);

        if (driver.findElement(By.xpath("//div[@id='dropdiv']/p")).getText().equals("Dropped!")) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("alert('Element Is drag and drop by 100 pixel offset In horizontal direction.');");
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            Thread.sleep(2000);
        }
    }

    @After
    public void close() throws InterruptedException {
        driver.close();
    }

}
