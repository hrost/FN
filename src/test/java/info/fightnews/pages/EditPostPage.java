package info.fightnews.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;

import static info.fightnews.webtestbase.WebDriverFactory.getDriver;

/**
 * Created by mlukianenko on 5/22/17.
 */
public class EditPostPage extends BasePage{

    @FindBy (xpath = "//*[@id='form_pid']")
    private WebElement categoryInput;

    @FindBy (xpath = "//*[@id='form_title']")
    private WebElement articleInput;

    @FindBy (xpath = "//*[@placeholder='Выберите файл / вставьте ссылку']")
    private WebElement imageUrlInput;

    @FindBy (xpath = "//*[@id='form_source']")
    private WebElement sourceInput;

    @FindBy (xpath = "//*[@id='form_text_ifr']")
    private WebElement descriptionInput;

    @FindBy (xpath = "//*[@id='form_tags']")
    private WebElement tagInput;

    @FindBy (xpath = "//*[@id='add_review']//input[@name='add_review']")
    private WebElement addPostLowerBtn;

    public EditPostPage() {waitPageLoaded(categoryInput);}

    @Step("{method} with category={0}, article={1}, imagePath={2}, source={3}, description={4}, tag={5}")
    public PostPage addPost(String category, String article, String imagePath,
                        String source, String description, String tag){
        Select select =  new Select(categoryInput);
        for (WebElement element: select.getOptions()) {
            if (element.getText().contains(category)) {
                select.selectByVisibleText(element.getText());
            }
        }
        articleInput.sendKeys(article);
        imageUrlInput.sendKeys(imagePath);
        sourceInput.sendKeys(source);
        getDriver().switchTo().frame(descriptionInput);
        getDriver().findElement(By.xpath("//*[@id='tinymce']")).click();
        getDriver().findElement(By.xpath("//*[@id='tinymce']")).sendKeys(description);
        getDriver().switchTo().defaultContent();
        tagInput.sendKeys(tag);
        addPostLowerBtn.click();
        return new PostPage();
    }
}
