package info.fightnews.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


/**
 * Created by mlukianenko on 5/11/17.
 */
public class    LoginPage extends BasePage {

    @FindBy(xpath="//*[@id='form_email']")
    @CacheLookup
    private WebElement userEmailInput;

    @FindBy(xpath="//*[@id='form_pass']")
    @CacheLookup
    private WebElement passwordInput;

    @FindBy(xpath="//*[@id='loginform']/input")
    @CacheLookup
    private WebElement loginBtn;

    @FindBy(xpath="//*[@class='top-right']//li[1]/a")
    @CacheLookup
    private WebElement userNameOnTop;

    public LoginPage() {
        waitPageLoaded(loginBtn);
    }

    public HomePage doLogin(String email, String password) {
        userEmailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginBtn.click();
        return new HomePage();
    }

}
