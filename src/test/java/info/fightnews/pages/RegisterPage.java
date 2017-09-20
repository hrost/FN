package info.fightnews.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static info.fightnews.utils.TimeUtils.waitForElementDisplayed;

/**
 * Created by mlukianenko on 5/15/17.
 */
public class RegisterPage extends BasePage {
    @FindBy(xpath = "//*[@id='form_name_user']")
    @CacheLookup
    private WebElement name;

    @FindBy(xpath = "//*[@id='form_email']")
    @CacheLookup
    private WebElement email;

    @FindBy(xpath = "//*[@id='form_pass']")
    @CacheLookup
    private WebElement password;

    @FindBy(xpath = "//*[@id='form_re_pass']")
    @CacheLookup
    private WebElement repassword;

    @FindBy(xpath = "//*[@name='url_users_img[0]']")
    @CacheLookup
    private WebElement avatar;

    @FindBy(xpath = "//*[@id='reg_form']/input")
    @CacheLookup
    private WebElement registerBtn;

    @FindBy(xpath = "//*[@id='primary']//*[text()='Спасибо за регистрацию.']")
    @CacheLookup
    private WebElement confirmationText;

    RegisterPage() {
        waitPageLoaded(name);
    }

    @Step("{method} with following attributes: userName = {0}, UserEmail = {1}, UserPassword = {2}, avatarURL = {3}")
    public void registerUser(String userName, String UserEmail, String UserPassword, String avatarURL) {
        name.sendKeys(userName);
        email.sendKeys(UserEmail);
        password.sendKeys(UserPassword);
        repassword.sendKeys(UserPassword);
        avatar.sendKeys(avatarURL);
        registerBtn.click();
        waitForElementDisplayed(confirmationText);
    }
}