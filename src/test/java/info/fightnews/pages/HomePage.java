package info.fightnews.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by mlukianenko on 5/11/17.
 */
public class HomePage extends BasePage{
    @FindBy(xpath="//*[@href='/new-post/']")
    private WebElement addPostBtn;

    @FindBy(id="primary")
    private WebElement slider;

    public HomePage() {waitPageLoaded(slider);}

}

