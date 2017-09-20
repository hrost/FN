package info.fightnews.tests;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import info.fightnews.pages.*;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.io.File;

import static junit.framework.TestCase.assertEquals;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.assertj.core.api.Assertions.*;
import static info.fightnews.utils.LoadProperties.getConfig;
import static info.fightnews.webtestbase.WebDriverFactory.getDriver;

/**
 * Created by mlukianenko on 5/10/17.
 */
@RunWith(DataProviderRunner.class)
public class HomePageTest extends BaseTest {

    @DataProvider
    public static Object[][] dataProviderAdd() {
        return new Object[][]{
                {"Новости", "Новости бокса"},
                /*{"Статьи", "Статьи"},
                {"ММА", "Новости ММА"},
                {"Рейтинги","Рейтинги Бокс"},
                {"Рейтинги", "Рейтинги ММА"},
                {"Рейтинги", "Рейтинги Прогнозистов"},
                {"Видео", "Видео"},
                {"Фото", "Фото"},
                {"Биографии", "Биографии"},
                {"Аналитика", "Аналитика"},*/
        };
    }

    Header header = new Header();

    @Test @Features("User should be able to add post material") @Stories("User abilities")
    @UseDataProvider("dataProviderAdd")
    @Description("Add new post with selected category: {1} and verify it's created under {0} section")
    public void testAddPost(String section, String selectOption) {

        EditPostPage editPostPage = header.goToCreatePost();;
        String article = randomAlphabetic(30);
        //String imageUrl = new File("src/test/resources/boxing.jpg").getAbsolutePath();
        String imageUrl = "http://img04.deviantart.net/02da/i/2013/129/a/2/muhammad_ali_sketch_2b_by_t_douglas_painting-d64pzzv.jpg";
        String source = "http://www." + randomAlphabetic(10) + ".com";
        String description = randomAlphabetic(300);;
        String tag = randomAlphabetic(10);
        PostPage postPage = editPostPage.addPost(selectOption, article, imageUrl, source, description, tag);
        assertThat(postPage.getCategory()).isEqualTo(section);
        assertThat(postPage.getArticle()).isEqualTo(article);
        assertThat(postPage.getSource()).contains(source);
        assertThat(postPage.getDescription()).isEqualTo(description);
        assertThat(postPage.getTag()).isEqualToIgnoringCase(tag);
        assertThat(postPage.getAuthor()).isEqualTo(getConfig().getProperty("user"));

        CategoryPage categoryPage = header.goToCategory(section);
        assertThat(categoryPage.getAuthorForCratedPost(article)).isEqualTo(getConfig().getProperty("user"));
        assertThat(categoryPage.getArticleForCratedPost(article)).isEqualTo(article);
    }

}
