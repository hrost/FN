package info.fightnews.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by mlukianenko on 5/13/17.
 */
public class BrowserCapabilites {
    public static DesiredCapabilities capabilities = new DesiredCapabilities();


    public static WebDriver setCapabilites(String browser, WebDriver e_driver) {
        EventFiringWebDriver driver = null;
        switch (browser) {
            case "firefox":
                //e_driver = new FirefoxDriver(capabilities.firefox());
                try {
                    e_driver = new RemoteWebDriver(
                            new URL("http://localhost:4444/wd/hub"),
                            capabilities.firefox());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
                e_driver = new ChromeDriver(options);
                /*try {
                    e_driver = new RemoteWebDriver(
                            new URL("http://localhost:4444/wd/hub"),
                            capabilities.chrome());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }*/
        }
        driver = new EventFiringWebDriver(e_driver);
        driver.register(new WebDriverLogger());
        return driver;
    }
}