package com.torikraju.Selenium.JQuery;


import WebDriverSetup.WebDriverHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by torikul on 11/23/2017.
 */
public class Selectable_Items {

    private HelperClass helperClass;
    private WebDriver driver;

    @Before
    public void init() {
        this.driver = new WebDriverHelper().intialization("chrome");
        this.driver.manage().window().maximize();
        this.helperClass = new HelperClass();

    }

    @Test
    public void Selectable_Items_test() throws Throwable {
        driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
        helperClass.waitForJSandJQueryToLoad(driver);

        List<WebElement> selectableItems = driver.findElements(By.xpath("//*[@id='selectable']/*"));
        Actions toSelect = new Actions(driver);

        toSelect.clickAndHold(selectableItems.get(3)).clickAndHold(selectableItems.get(6)).click();

        /*toSelect.click(selectableItems.get(1)).sendKeys(Keys.CONTROL).click(selectableItems.get(4));*/

        Action selectItems = toSelect.build();
        selectItems.perform();


    }

    @After
    public void close() throws Throwable {
        Thread.sleep(5000);
        driver.close();
    }
}
