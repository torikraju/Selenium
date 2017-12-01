package WebDriverSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSetup {

    private WebDriver webDriver;

    String OS = System.getProperty("os.name");

    public WebDriver intialization(String browserName) {

        if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", getGeckoDriverLocation());
            webDriver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", getChromeDriverLocation());
            webDriver = new ChromeDriver();
        } else {
            System.out.println("browserName = [" + browserName + "] is not valid");
        }

        return webDriver;
    }

    public String getGeckoDriverLocation() {
        if (OS.startsWith("Linux")) {
            return "resources/drivers/geckodriver";
        } else if (OS.startsWith("Windows")) {
            return "resources/drivers/geckodriver.exe";
        } else {
            return null;
        }
    }

    public String getChromeDriverLocation() {
        if (OS.startsWith("Linux")) {
            return "resources/drivers/chromedriver";
        } else if (OS.startsWith("Windows")) {
            return "resources/drivers/chromedriver.exe";
        } else {
            return null;
        }
    }

}
