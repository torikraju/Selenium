package com.torikraju.Screenshot;

import WebDriverSetup.WebDriverHelper;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CaptureScreenshot {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new WebDriverHelper().intialization("firefox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void Capture_Screenshot_Test() throws IOException {
        driver.get("http://google.com");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("resources/Screenshot/screenShot_" + getString(4) + ".jpg"));

    }

    @After
    public void close() {
        driver.close();
    }

    public String getString(int numberOfCharcter) {
        String combination = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstwxyz1234567890";
        StringBuilder string = new StringBuilder();
        Random rnd = new Random();
        while (string.length() < numberOfCharcter) { // length of the random string.
            int index = (int) (rnd.nextFloat() * combination.length());
            string.append(combination.charAt(index));
        }
        String result = string.toString();
        return result;
    }


}
