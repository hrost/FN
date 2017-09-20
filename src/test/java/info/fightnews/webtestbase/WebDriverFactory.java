package info.fightnews.webtestbase;

import org.openqa.selenium.WebDriver;
import info.fightnews.utils.BrowserCapabilites;
import info.fightnews.utils.JScriptInvocation;

import static info.fightnews.utils.LoadProperties.getConfig;

/**
 * Created by mlukianenko on 5/12/17.
 */
public class WebDriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Webdriver was not initialized");
        }
    }


    public static void startBrowser() {
        driver = BrowserCapabilites.setCapabilites(getConfig().getProperty("browser"), driver);
        driver.manage().window().maximize();
        driver.get(getConfig().getProperty("url"));
        if(getConfig().getProperty("browser").equals("firefox")) {
            driver.switchTo().alert().accept();
        }
        JScriptInvocation.executeJS("var elements = document.getElementsByClassName('ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable ui-resizable'); while(elements.length > 0){ elements[0].parentNode.removeChild(elements[0]); }", driver);
    }

    public static void finishBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void openHomeUrl() {
        driver.get(getConfig().getProperty("url"));
    }
}
