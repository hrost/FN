package info.fightnews.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by mlukianenko on 5/23/17.
 */
public class PostPage extends BasePage{

    @FindBy(xpath="//*[@class='container']/h1")
    private WebElement article;
    @FindBy(xpath="//div[@class='breadcrumb']//a[2]")
    private WebElement category;
    @FindBy(xpath="//*[@class='author']")
    private WebElement source;
    @FindBy(xpath="//*[@id='primary']//p[text()='Добавил ']/a")
    private WebElement author;
    @FindBy(xpath="//*[@class='text_panel']")
    private WebElement description;
    @FindBy(xpath="//*[@class='tagcloud']/a")
    private WebElement tag;

    public PostPage() {
        waitPageLoaded(author);
    }

    public String getArticle() {
        return article.getText();
    }

    public String getCategory() {
        return category.getText();
    }

    public String getSource() {
        return source.getText();
    }

    public String getAuthor() {
        return author.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public String getTag() {
        return tag.getText();
    }
}