package com.torikraju.Html5_Automate;

import WebDriverSetup.WebDriverHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Html5_Automation {

    private WebDriver driver;

    private String basicURL = "https://www.w3.org/2010/05/video/mediaevents.html";
    private String YTURL = "https://www.youtube.com/watch?v=-pqrKXfNR68";
    private JavascriptExecutor js;

    @Before
    public void setup() {
        driver = new WebDriverHelper().intialization("firefox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void basicURL_Test() throws Throwable {

        driver.get(basicURL);

        //play video
        js.executeScript("document.getElementById('video').play()");

        //wait for buffering
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(webDriver -> Float.parseFloat(driver.findElement(By.id("video")).getAttribute("currentTime")) > 0);


        //pause playing video
        js.executeScript("document.getElementById('video').pause()");
        Thread.sleep(2000);

        //check video is paused

        js.executeScript("document.getElementById('video').play()");

        // play video from starting
        js.executeScript("document.getElementById('video').currentTime=0");
        Thread.sleep(5000);

        //reload video
        js.executeScript("document.getElementById('video').load()");
        Thread.sleep(2000);

        //increase the voulume of  video
        js.executeScript("document.getElementById('video').volume=0.5");
        Thread.sleep(2000);

    }

    @Test
    public void YTURL_Test() throws Throwable {

        driver.get(YTURL);
        String locator = "document.getElementsByClassName('video-stream html5-main-video')[0]";

        //play video
        js.executeScript(locator + ".play()");


        //wait for buffering
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(webDriver -> Float.parseFloat(driver.findElement(By.xpath("//div[@class='html5-video-container']/video")).getAttribute("currentTime")) > 0);
        js.executeScript(locator + ".currentTime=10");

        wait.until(webDriver -> Float.parseFloat(driver.findElement(By.xpath("//div[@class='html5-video-container']/video")).getAttribute("currentTime")) > 30);
        js.executeScript(locator + ".pause()");

        System.out.printf("");


    }

    @After
    public void close() {
        driver.close();
    }


}
