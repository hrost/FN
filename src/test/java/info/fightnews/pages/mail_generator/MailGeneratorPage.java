package info.fightnews.pages.mail_generator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import info.fightnews.pages.BasePage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by mlukianenko on 5/16/17.
 */
public class MailGeneratorPage extends BasePage {
    @FindBy(xpath = "//*[@id='login']")
    @CacheLookup
    private WebElement randomEmail;

    @Step("{method}")
    public String getEmailAddress() {
        String emailAdress = randomEmail.getAttribute("value");
        return emailAdress;
    }

}
