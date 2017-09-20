package info.fightnews.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static info.fightnews.webtestbase.WebDriverFactory.getDriver;

/**
 * Created by mlukianenko on 5/15/17.
 */
public class CategoryPage extends BasePage{
    @FindBy(xpath = "//div[@class='bread']")
    @CacheLookup
    private WebElement linkToMainPage;

    public CategoryPage() {
        waitPageLoaded(linkToMainPage);
    }

    public String getAuthorForCratedPost(String postName) {
        WebElement userName = getDriver().findElement(By.xpath("//*[@class='entry-metadata']//a[contains(text(),'" + postName + "')]/../.." + "//p/a"));
        return userName.getText();
    }

    public String getArticleForCratedPost(String postName) {
        WebElement article = getDriver().findElement(By.xpath("//*[@class='entry-metadata']//a[contains(text(),'" + postName + "')]/../.." + "//h5/a"));
        return article.getText();
    }

}
