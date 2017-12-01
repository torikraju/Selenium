package com.torikraju.Selenium.Javascript;

import WebDriverSetup.WebDriverSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class handle_Javascript {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new WebDriverSetup().intialization("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void handle_Javascript_test() throws Throwable {
        driver.get("http://rediff.com");

        WebElement sign_In = driver.findElement(By.linkText("Sign in"));
        sign_In.click();

        WebElement go_Button = driver.findElement(By.name("proceed"));
        go_Button.click();

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(2000);
        alert.accept();

    }

    @Test
    public void handle_Javascript_test_pop_Up() throws Throwable {
        driver.get("file:///C:/Git/Selenium_tutorial/resources/HTML/Javascript_pop_up.html");

        driver.findElement(By.tagName("button")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Triss merigold");
        Thread.sleep(2000);
        alert.accept();

        WebDriverWait driverWait = new WebDriverWait(driver, 10);
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("demo"))));
        System.out.println(driver.findElement(By.id("demo")).getText());


    }

    @After
    public void close() {
        driver.close();
    }


}
