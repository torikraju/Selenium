package com.torikraju.Selenium.Table;

import WebDriverSetup.WebDriverSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Static_Table {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new WebDriverSetup().intialization("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void static_table_handle() {
        driver.get("file:///C:/Git/Selenium_tutorial/resources/HTML/Table.html");

        WebElement table = driver.findElement(By.tagName("table"));

        List<WebElement> tableContent = table.findElements(By.xpath("//tr/td[3]"));
        tableContent.forEach((alltr) -> System.out.println(alltr.getText()));

    }

    @After
    public void close() {
        driver.close();
    }


}
