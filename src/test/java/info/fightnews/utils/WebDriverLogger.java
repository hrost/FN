package info.fightnews.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * Created by mlukianenko on 5/31/17.
 */
public class WebDriverLogger implements WebDriverEventListener {

    private static Logger logger = Logger.getLogger(WebDriverLogger.class);
    public static Logger getLogger() {
        return logger;
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {

    }

    public void afterNavigateTo(String url, WebDriver driver) {
        logger.info("Navigated to '" + url + "'");
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info("Find element by " + "'" + by.toString() + "'");
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info("Element was found ");
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("Click on " + "'" + webElement.toString() + "'");
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("Element was clicked");
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        logger.info("Execute script: " + "'" + s + "'");
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        logger.info("Script was executed");
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        logger.info("Exeption '" + throwable + "' was thrown");
    }
}
