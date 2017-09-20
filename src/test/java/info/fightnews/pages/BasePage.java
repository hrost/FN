package info.fightnews.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import info.fightnews.utils.JScriptInvocation;

import static info.fightnews.utils.TimeUtils.*;
import static info.fightnews.webtestbase.WebDriverFactory.getDriver;

/**
 * Created by mlukianenko on 5/11/17.
 */
public abstract class BasePage {

    public BasePage() {

        PageFactory.initElements(getDriver(), this);
    }

    public void waitPageLoaded(WebElement element) {
        waitForElementDisplayed(element);
        //Remove Social networks share popup from DOM
        JScriptInvocation.executeJS("var elements = document.getElementsByClassName('ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable ui-resizable'); while(elements.length > 0){ elements[0].parentNode.removeChild(elements[0]); }", getDriver());

    }

}



