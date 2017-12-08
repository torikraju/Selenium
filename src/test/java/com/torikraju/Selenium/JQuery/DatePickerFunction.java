package com.torikraju.Selenium.JQuery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

/**
 * Created by torikul on 11/23/2017.
 */
public class DatePickerFunction {
    private List<String> monthList;
    private int expMonth;

    private int expYear;
    private int expDate;
    private String calMonth = null;
    private String calYear = null;
    private boolean dateNotFound;

    DatePickerFunction() {
        this.monthList = Arrays.asList(
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December");
    }

    public void setDate(WebDriver driver, String XpathOfInputDatePicker, int date, int month, int year) {

        this.dateNotFound = true;
        this.expDate = date;
        this.expMonth = month;
        this.expYear = year;

        driver.findElement(By.xpath(XpathOfInputDatePicker)).click();

        while (dateNotFound) {
            //Retrieve current selected month name from date picker popup.
            calMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
            //Retrieve current selected year name from date picker popup.
            calYear = driver.findElement(By.className("ui-datepicker-year")).getText();

            if (monthList.indexOf(calMonth) + 1 == expMonth && (expYear == Integer.parseInt(calYear))) {
                //Call selectDate function with date to select and set dateNotFound flag to false.
                selectDate(expDate, driver);
                dateNotFound = false;
            }
            //If current selected month and year are less than expected month and year then go Inside this condition.
            else if (monthList.indexOf(calMonth) + 1 < expMonth && (expYear == Integer.parseInt(calYear)) || expYear > Integer.parseInt(calYear)) {
                //Click on next button of date picker.
                driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[2]/span")).click();
            } else if (monthList.indexOf(calMonth) + 1 > expMonth && (expYear == Integer.parseInt(calYear)) || expYear < Integer.parseInt(calYear)) {
                //Click on previous button of date picker.
                driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[1]/span")).click();
            }
        }
    }

    private void selectDate(int date, WebDriver driver) {
        WebElement datePicker = driver.findElement(By.id("ui-datepicker-div"));
        List<WebElement> noOfColumns = datePicker.findElements(By.tagName("td"));

        for (WebElement cell : noOfColumns) {
            if (cell.getText().equals(date)) {
                cell.findElement(By.linkText(String.valueOf(date))).click();
                break;
            }
        }
    }
}
