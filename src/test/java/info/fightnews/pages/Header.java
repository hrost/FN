package info.fightnews.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static info.fightnews.webtestbase.WebDriverFactory.*;

/**
 * Created by mlukianenko on 5/15/17.
 */
public class Header extends BasePage{
    @FindBy(xpath="//*[@title='Регистрация']")
    @CacheLookup
    private WebElement registration;

    @FindBy(xpath="//*[@class='top-right']//a[@title='Вход']")
    @CacheLookup
    private WebElement enter;

    @FindBy(id="s")
    @CacheLookup
    private WebElement searchBox;

    @FindBy(xpath = "//*[@class='top-right']/ul/li[1]/a")
    @CacheLookup
    private WebElement nameOnTop;

    @FindBy(xpath = "//*[@href='/new-post/']")
    @CacheLookup
    private WebElement addPostBtn;


    public Header() {
        waitPageLoaded(searchBox);
    }

    @Step("Go to LoginPage")
    public LoginPage goToLoginForm() {
        enter.click();
        return new LoginPage();
    }

    @Step("Go to RegisterPage")
    public RegisterPage goToRegistration() {
        waitPageLoaded(registration);
        registration.click();
        return new RegisterPage();
    }

    @Step("Go to Category = {0}")
    public CategoryPage goToCategory(String category) {
        WebElement categoryLink = getDriver().findElement(By.xpath("//*[@id='main-menu']//a[text()='" + category +"']"));
        categoryLink.click();
        return new CategoryPage();
    }

    @Step("Get user name from Header")
    public String getNameFromHeader() {
        String nameFromHeader = nameOnTop.getText();
        return nameFromHeader;
    }

    @Step("Go to 'Create Post' page")
    public EditPostPage goToCreatePost() {
        addPostBtn.click();
        return new EditPostPage();
    }
}
