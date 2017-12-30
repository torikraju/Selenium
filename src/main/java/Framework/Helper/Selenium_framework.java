package Framework.Helper;

import Framework.Loader.ConfigLoader;
import Framework.Loader.SystemConstant;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Selenium_framework {

    public WebDriver driver;

    private void init(String driverType) {
        if (driverType.equals("chrome")) {
            System.setProperty(SystemConstant.CHROME_DRIVER, ConfigLoader.getPropertiesById(SystemConstant.LOCAL_CHROME_DRIVER_LOCATION, SystemConstant.CHROME_DRIVER));
        } else if (driverType.equals("firefox")) {
            System.setProperty(SystemConstant.GECKO_DRIVER, ConfigLoader.getPropertiesById(SystemConstant.LOCAL_GECKO_DRIVER_LOCATION, SystemConstant.GECKO_DRIVER));
        }
    }

    public void setup() {
        final String driverType = ConfigLoader.getPropertiesById(SystemConstant.DRIVER_TYPE);
        init(driverType);

        if (driverType.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (driverType.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

    }

    public void exit() {
        driver.quit();
    }

    public void close() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void browseURL(String url) {
        if (url != null && !url.equals("")) {
            driver.manage().window().maximize();
            waitNSecond(5);
            driver.get(url);
        }
    }

    public void browseURL(String url, int waitTime) {
        if (url != null && !url.equals("")) {
            driver.manage().window().maximize();
            waitNSecond(waitTime);
            driver.get(url);
        }
    }

    public void browseLocalHTML(String relativePath) {
        String htmlLocation = "file:" + System.getProperty("user.dir") + "/" + relativePath;
        driver.manage().window().maximize();
        waitNSecond(5);
        driver.get(htmlLocation);
    }

    public void browseLocalHTML(String relativePath, int waitTime) {
        String htmlLocation = "file:" + System.getProperty("user.dir") + "/" + relativePath;
        driver.manage().window().maximize();
        waitNSecond(waitTime);
        driver.get(htmlLocation);
    }


    public void waitNSecond(int n) {
        driver.manage().timeouts().implicitlyWait(n, SECONDS);
    }


    public WebElement find(String elementName, String userMessage) {
        if (elementName == null || elementName.equals("")) {
            return null;
        } else {
            return driver.findElement(getBy(elementName, userMessage));
        }
    }

    public WebElement find(String elementName) {
        return find(elementName, null);
    }

    public WebElement find(WebElement webElement, String elementName, String userMessage) {
        if (elementName == null || elementName.equals("")) {
            return webElement;
        } else {
            return webElement.findElement(getBy(elementName, userMessage));
        }
    }

    public WebElement find(WebElement webElement, String elementName) {
        return find(webElement, elementName, null);
    }

    public List<WebElement> findAll(String elementName, String userMessage) {
        if (elementName == null || elementName.equals("")) {
            return null;
        } else {
            return driver.findElements(getBy(elementName, userMessage));
        }
    }

    public List<WebElement> findAll(String elementName) {
        return findAll(elementName, null);
    }


    public List<WebElement> findAll(WebElement webElement, String elementName, String userMessage) {
        if (elementName == null || elementName.equals("")) {
            return null;
        } else {
            return webElement.findElements(getBy(elementName, userMessage));
        }
    }

    public List<WebElement> findAll(WebElement webElement, String elementName) {
        return findAll(webElement, elementName, null);
    }


    public void findAndSetValue(String elementName, String value) {
        findAndSetValue(elementName, value, null);
    }

    public void findAndSetValue(String elementName, String value, String message) {
        WebElement webElement = find(elementName, message);
        scrollToElement(webElement);
        webElement.sendKeys(value);
    }

    public void findAndTriggerClick(String elementName) {
        findAndTriggerClick(elementName, null);
    }

    public void findAndTriggerClick(String elementName, String message) {
        WebElement webElement = find(elementName, message);
        scrollToElement(webElement);
        webElement.click();
    }

    public void findAndTriggerClick(WebElement webElement, String elementName) {
        findAndTriggerClick(webElement, elementName, null);
    }

    public void findAndTriggerClick(WebElement webElement, String elementName, String message) {
        WebElement currentElement = find(webElement, elementName, message);
        scrollToElement(currentElement);
        currentElement.click();
    }

    public String findAndGetText(String elementName) {
        return findAndGetText(elementName, null);
    }

    public String findAndGetText(String elementName, String message) {
        WebElement webElement = find(elementName, message);
        return webElement.getText();
    }

    public String findAndGetText(WebElement webElement, String elementName, String message) {
        WebElement currentElement = find(webElement, elementName, message);
        return currentElement.getText();
    }

    public String findAndGetText(WebElement webElement, String elementName) {
        return findAndGetText(webElement, elementName, null);
    }

    public String findAndGetAttributeValue(String elementName, String attributeName) {
        return findAndGetAttributeValue(elementName, attributeName, null);
    }

    public String findAndGetAttributeValue(String elementName, String attributeName, String message) {
        WebElement webElement = find(elementName, message);
        return webElement.getAttribute(attributeName);
    }

    public String findAndGetAttributeValue(WebElement webElement, String elementName, String attributeName) {
        return findAndGetAttributeValue(webElement, elementName, attributeName, null);
    }

    public String findAndGetAttributeValue(WebElement webElement, String elementName, String attributeName, String message) {
        webElement = find(webElement, elementName, message);
        return webElement.getAttribute(attributeName);
    }

    public void scrollToElement(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement);
        actions.perform();
    }

    public void pageLoadTimeout(int waitTime) {
        driver.manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
    }


    private void findExceptionHandler(Exception e, String userMessage) {
        String message = e.getMessage();
        if (SystemConstant.isDebug) {
            e.printStackTrace();
        }
        if (userMessage != null || !userMessage.equals("")) {
            message = userMessage;
        }
        Assert.fail(message);
    }

    private By getBy(String elementName, String userMessage) {
        try {
            String genericName = elementName.substring(1);
            if (elementName.startsWith("/")) {
                return By.xpath(elementName);
            } else if (elementName.startsWith(".")) {
                return By.className(genericName);
            } else if (elementName.startsWith("#")) {
                return By.id(genericName);
            } else if (elementName.startsWith("%")) {
                return By.tagName(genericName);
            } else if (elementName.startsWith("@")) {
                return By.linkText(genericName);
            } else if (elementName.startsWith("|")) {
                return By.cssSelector(genericName);
            } else if (elementName.startsWith("*")) {
                return By.partialLinkText(genericName);
            } else {
                return By.name(elementName);
            }

        } catch (Exception e) {
            findExceptionHandler(e, userMessage);
            return null;
        }
    }



}
