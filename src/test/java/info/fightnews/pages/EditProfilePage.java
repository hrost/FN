package info.fightnews.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by mlukianenko on 5/16/17.
 */
public class EditProfilePage extends BasePage{

    @FindBy(xpath = "//*[@id='primary']//span[text()=' Редактировать профиль ']")
    @CacheLookup
    private WebElement editProfile;

    @FindBy(xpath = "//*[@id='form_age']")
    @CacheLookup
    private WebElement dateOfBirthForm;

    @FindBy(id = "form_city")
    @CacheLookup
    private WebElement cityForm;

    @FindBy(id = "form_tagline")
    @CacheLookup
    private WebElement captionForm;

    @FindBy(id = "form_favourite")
    @CacheLookup
    private WebElement favoriteBoxersForm;

    @FindBy(id = "form_more_info")
    @CacheLookup
    private WebElement infoForm;

    @FindBy(xpath = "//input[@class='dt-sc-button small']")
    @CacheLookup
    private WebElement saveBtn;

    public EditProfilePage() {
        waitPageLoaded(dateOfBirthForm);
    }

    @Step("{method}")
    public ProfilePage updateProfileInfo(String dateOfBirth, String city, String caption, String favoriteBoxers, String info) {
        dateOfBirthForm.sendKeys(dateOfBirth);
        cityForm.click();
        cityForm.sendKeys(city);
        captionForm.sendKeys(caption);
        favoriteBoxersForm.sendKeys(favoriteBoxers);
        infoForm.sendKeys(info);
        saveBtn.click();
        return new ProfilePage();

    }
}
