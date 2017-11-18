package com.torikraju.Selenium._Handling_Tabs;

import com.torikraju.Selenium.webDreiverControl.WebDriverControl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Handle_Tab {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new WebDriverControl().intialization("firefox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void window_handle_test() throws Throwable {

        driver.get("http://icicibank.com");
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String mainWindow = iterator.next();
        System.out.println("Main tab id: " + mainWindow);


        List<WebElement> elements = driver.findElements(By.id("push-modal-close"));
        for (WebElement element : elements) {
            if (element.getLocation().getX() != 0) {
                element.click();
            }
        }

        WebElement termsAndCondition = driver.findElement(By.linkText("Terms & Conditions"));
        termsAndCondition.click();

        WebElement personalBanking = driver.findElement(By.xpath("//span[text()='Personal Banking']"));
        personalBanking.click();

        WebElement ATM_Cards = driver.findElement(By.linkText("ATM Cards"));
        ATM_Cards.click();

        System.out.println("-------After the new tab is opened--------");

        windows = driver.getWindowHandles();
        iterator = windows.iterator();
        String atmCardWindw = iterator.next();
        System.out.println("Second tab id: " + atmCardWindw);

        driver.switchTo().window(atmCardWindw);
        System.out.println(driver.getTitle());


    }

    @After
    public void close() {
        driver.close();
    }


}
