package com.torikraju.Selenium.webDreiverControl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverControl {

    private WebDriver webDriver;

    public WebDriver intialization(String browserName) {
        if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver.exe");
            webDriver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver.exe");
            webDriver = new ChromeDriver();
        } else {
            System.out.println("browserName = [" + browserName + "] is not valid");
        }

        return webDriver;
    }

}

