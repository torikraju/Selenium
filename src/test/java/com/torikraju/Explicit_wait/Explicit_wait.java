package com.torikraju.Explicit_wait;

import WebDriverSetup.WebDriverHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Explicit_wait {

    private WebDriver driver;

    @Before
    public void init() {

        driver = new WebDriverHelper().intialization("firefox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void driver_wait_tests() {

        driver.get("https://www.google.com/");
        driver.findElement(By.id("lst-ib")).sendKeys("Selenium");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='selenium ide']")));

        driver.findElement(By.xpath("//*[text()='selenium ide']"));

    }

    @After
    public void close() throws InterruptedException {
        //driver.close();
    }
}
