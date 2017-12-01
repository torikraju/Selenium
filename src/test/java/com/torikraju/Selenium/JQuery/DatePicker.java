package com.torikraju.Selenium.JQuery;

import WebDriverSetup.WebDriverSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by torikul on 11/23/2017.
 */
public class DatePicker {
    WebDriver driver;
    private DatePickerFunction datePickerFunction;


    @Before
    public void start() {
        driver = new WebDriverSetup().intialization("chrome");
        driver.manage().window().maximize();
        this.datePickerFunction = new DatePickerFunction();
    }

    @Test
    public void date_picker_test() throws InterruptedException {
        driver.get("http://www.aorank.com/tutorial/jquery-datepicker-example/cal.html");
        datePickerFunction.setDate(driver, "//input[@id='datepicker']", 18, 8, 2013);

    }

    @After
    public void close() throws Throwable {
        Thread.sleep(5000);
        driver.close();
    }


}
