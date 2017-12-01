package WebDriverSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSetup {

    private WebDriver webDriver;

    public WebDriver intialization(String browserName) {
        if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver");
            webDriver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");
            webDriver = new ChromeDriver();
        } else {
            System.out.println("browserName = [" + browserName + "] is not valid");
            // return null;
        }

        return webDriver;
    }

}
