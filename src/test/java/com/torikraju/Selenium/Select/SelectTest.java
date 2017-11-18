package com.torikraju.Selenium.Select;

import com.torikraju.Selenium.webDreiverControl.WebDriverControl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectTest {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new WebDriverControl().intialization("firefox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void singleSelectTest() {
        driver.get("http://newtours.demoaut.com/mercuryregister.php");

        WebElement selectElement = driver.findElement(By.name("country"));
        Select select = new Select(selectElement);
        List<WebElement> lists = select.getOptions();
        System.out.println(lists.size());
        select.selectByValue("14");
    }

    @Test
    public void multipleSelectTest() {
        driver.get("http://jsbin.com/osebed/2");
        WebElement selectElement = driver.findElement(By.id("fruits"));
        Select multiSelect = new Select(selectElement);
        multiSelect.selectByIndex(1);
        multiSelect.selectByIndex(0);
    }

    @After
    public void close() {
        driver.close();
    }

}
