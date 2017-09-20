package info.fightnews.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by mlukianenko on 5/13/17.
 */
public class JScriptInvocation {


    public static void executeJS (String script, WebDriver driver) {
        if (driver instanceof JavascriptExecutor) {
            try {
            ((JavascriptExecutor) driver)
                    .executeScript(script);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
