package com.torikraju.Selenium._SSL_Certificate;

import WebDriverSetup.WebDriverHelper;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.concurrent.TimeUnit;

public class SSL_Certificate_Error_Handling {

    //Check in google what is default ACCEPT_SSL_CERTS in WebDriver

    private WebDriver driver;


    @Test
    public void SSL_Certificate_Error_Handling_Test_firefox() throws Throwable {


        System.setProperty("webdriver.gecko.driver", new WebDriverHelper().getGeckoDriverLocation());
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, false);
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);

        driver.get("https://cacert.org/");

        Thread.sleep(2000);
        driver.close();

    }

    @Test
    public void SSL_Certificate_Error_Handling_Test_chome() throws Throwable {

        //  DesiredCapabilities capability = DesiredCapabilities.chrome();
        //  capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        System.setProperty("webdriver.chrome.driver", new WebDriverHelper().getChromeDriverLocation());


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        driver = new ChromeDriver(chromeOptions);


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);


        driver.get("https://cacert.org/");

        Thread.sleep(2000);
        driver.close();

    }


}
