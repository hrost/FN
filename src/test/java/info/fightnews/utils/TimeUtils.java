package info.fightnews.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static info.fightnews.webtestbase.WebDriverFactory.getDriver;

/**
 * Created by mlukianenko on 5/15/17.
 */
public class TimeUtils {
    private static final int GLOBAL_WAIT = 10;

    public static void waitForElementDisplayed(final WebElement element, int... timeoutInSeconds) {

        new WebDriverWait(getDriver(), timeoutInSeconds.length > 0 ? timeoutInSeconds[0]:GLOBAL_WAIT).until(new ExpectedCondition<Boolean>(){

            @Override
            public Boolean apply(WebDriver driver) {
                return element.isDisplayed();
            }
        });
    }
}
