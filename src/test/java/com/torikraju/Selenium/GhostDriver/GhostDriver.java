package com.torikraju.Selenium.GhostDriver;

import WebDriverSetup.WebDriverHelper;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GhostDriver {

    private WebDriver driver;


    @Test
    public void PhantomJs_Test() {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(true);

        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, new WebDriverHelper().getPhantomJsLocation());
        driver = new PhantomJSDriver(capabilities);

        driver.get("http://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);

        List<WebElement> list = driver.findElements(By.tagName("a"));

        for (WebElement element : list) {
            if (element.getLocation().getX() != 0 && !element.getText().isEmpty())
                System.out.println(element.getText());
        }

        driver.close();

    }


}
