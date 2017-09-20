package info.fightnews.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by mlukianenko on 5/18/17.
 */
public class ProfilePage extends BasePage{

    @FindBy(xpath = "//a[@class='dt-sc-button small']")
    @CacheLookup
    private WebElement editProfileBtn;

    @FindBy(xpath = "//div[@class='entry-metadata']/h2")
    @CacheLookup
    private WebElement userName;

    @FindBy(xpath = "//div[@class='entry-metadata']/p[1]")
    @CacheLookup
    private WebElement dateOfRegistration;

    @CacheLookup
    @FindBy(xpath = "//div[@class='entry-metadata']/p[3]")
    private WebElement age;

    @CacheLookup
    @FindBy(xpath = "//div[@class='entry-metadata']/p[2]")
    private WebElement city;

    @CacheLookup
    @FindBy(xpath = "//div[@class='entry-metadata']/p[4]")
    private WebElement caption;

    @CacheLookup
    @FindBy(xpath = "//div[@class='entry-metadata']/p[5]")
    private WebElement favoriteBoxers;

    @CacheLookup
    @FindBy(xpath = "//div[@class='text_panel']/p[2]")
    private WebElement info;

    public ProfilePage() {
        waitPageLoaded(editProfileBtn);

    }

    public String getUserName() {
    return userName.getText();
    }

    public String getAge() {
        return age.getText();
    }

    public String getCity() {
        return city.getText();
    }

    public String getCaption() {
        return caption.getText();
    }

    public String getFavoriteBoxers() {
        return favoriteBoxers.getText();
    }

    public String getInfo() {
        return info.getText();
    }

    public String getDateOfRegistration() {
        return dateOfRegistration.getText();
    }
}
