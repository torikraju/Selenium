package com.torikraju.Selenium.Handling_iframes;

import WebDriverSetup.WebDriverHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Handling_iframes {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new WebDriverHelper().intialization("firefox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void Handling_iframes_Test() {

        driver.get("http://toolsqa.com/iframe-practice-page/");

        driver.switchTo().frame(driver.findElement(By.id("IF2")));

        driver.findElement(By.id("ui-id-3")).click();

        String getTitle = driver.findElement(By.xpath("//*[text()='Content 3 Title']")).getText();

        Assert.assertEquals("Content 3 Title", getTitle);

    }

    @After
    public void close() {
        driver.close();
    }


}
