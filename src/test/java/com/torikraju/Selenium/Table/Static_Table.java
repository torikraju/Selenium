package com.torikraju.Selenium.Table;

import WebDriverSetup.WebDriverHelper;
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
        driver = new WebDriverHelper().intialization("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void static_table_handle() {

        String htmlLocation = "file:" + System.getProperty("user.dir") + "/resources/HTML/Table.html";

        driver.get(htmlLocation);


        WebElement table = driver.findElement(By.tagName("table"));

        List<WebElement> tableContent = table.findElements(By.xpath("//tr/td[3]"));
        tableContent.forEach((alltr) -> System.out.println(alltr.getText()));

    }

    @After
    public void close() {
        driver.close();
    }


}
