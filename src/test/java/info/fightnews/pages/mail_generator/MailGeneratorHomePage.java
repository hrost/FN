package info.fightnews.pages.mail_generator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import info.fightnews.pages.BasePage;
import ru.yandex.qatools.allure.annotations.Step;

import static info.fightnews.utils.TimeUtils.waitForElementDisplayed;

/**
 * Created by mlukianenko on 5/17/17.
 */
public class MailGeneratorHomePage extends BasePage{

    @FindBy(xpath = "//*[@id='login']")
    @CacheLookup
    private WebElement randomEmail;

    @FindBy(xpath = "//input[@value='Check Inbox']")
    @CacheLookup
    private WebElement checkInboxBtn;

    @FindBy(xpath = "//*[@id='ifmail']")
    @CacheLookup
    private WebElement iframe;

    @Step("{method} for user: {0}")
    public MailGeneratorInboxPage goToInbox(String email) {
        waitForElementDisplayed(randomEmail);
        randomEmail.sendKeys(email);
        checkInboxBtn.click();
        waitForElementDisplayed(iframe);
        return new MailGeneratorInboxPage();
    }
}
