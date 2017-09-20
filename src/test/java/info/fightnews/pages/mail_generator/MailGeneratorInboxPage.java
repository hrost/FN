package info.fightnews.pages.mail_generator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import info.fightnews.pages.BasePage;
import info.fightnews.pages.EditProfilePage;
import ru.yandex.qatools.allure.annotations.Step;
import info.fightnews.utils.TimeUtils;

import java.util.ArrayList;

import static info.fightnews.utils.TimeUtils.waitForElementDisplayed;
import static info.fightnews.webtestbase.WebDriverFactory.getDriver;

/**
 * Created by mlukianenko on 5/17/17.
 */
public class MailGeneratorInboxPage extends BasePage{

    @FindBy(xpath = "//*[@id='ifmail']")
    private WebElement iframe;

    @FindBy(xpath = "//*[@id='mailmillieu']//a")
    private WebElement confirmLink;

    @Step("{method}")
    public EditProfilePage confirmRegistration () {
        waitForElementDisplayed(iframe);
        getDriver().switchTo().frame(iframe);
        TimeUtils.waitForElementDisplayed(confirmLink);
        confirmLink.click();
        ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(0));
        getDriver().close();
        getDriver().switchTo().window(tabs2.get(1));

        return new EditProfilePage();
    }
}
