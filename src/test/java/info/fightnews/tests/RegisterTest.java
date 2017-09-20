package info.fightnews.tests;

//import org.apache.xpath.operations.String;
import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;
import info.fightnews.pages.EditProfilePage;
import info.fightnews.pages.Header;
import info.fightnews.pages.ProfilePage;
import info.fightnews.pages.RegisterPage;
import info.fightnews.pages.mail_generator.MailGeneratorHomePage;
import info.fightnews.pages.mail_generator.MailGeneratorInboxPage;
import info.fightnews.pages.mail_generator.MailGeneratorPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static info.fightnews.utils.LoadProperties.getConfig;
import static info.fightnews.webtestbase.WebDriverFactory.*;
import static info.fightnews.webtestbase.WebDriverFactory.getDriver;
import static info.fightnews.webtestbase.WebDriverFactory.openHomeUrl;

/**
 * Created by mlukianenko on 5/15/17.
 */
public class RegisterTest extends BaseTest {

    @BeforeClass
        public static void init() {
        startBrowser();
    }

    String userName = "testUser" + randomAlphanumeric(10);

    @Test @Features("User should be able to register new user") @Stories("User can register")
    @Description("Register new user and verify it is created with correct data")

    public void testNewRegistration() {
        Header header = new Header();
        //Get input data for registration
        String userPass = "test";
        String avaUrl = getConfig().getProperty("avaUrl");
        getDriver().get(getConfig().getProperty("emailGeneratorUrl"));
        MailGeneratorPage mailGeneratorPage = new MailGeneratorPage();
        String emailAddress = mailGeneratorPage.getEmailAddress();
        //Register user
        openHomeUrl();
        RegisterPage registerPage = header.goToRegistration();
        registerPage.registerUser(userName, emailAddress, userPass, avaUrl);
        //Get link for confirmation and finish registration
        getDriver().get(getConfig().getProperty("emailGeneratorHomeUrl"));
        MailGeneratorHomePage mailGeneratorHomePage = new MailGeneratorHomePage();
        MailGeneratorInboxPage mailGeneratorInboxPage = mailGeneratorHomePage.goToInbox(emailAddress);

        EditProfilePage editProfilePage = mailGeneratorInboxPage.confirmRegistration();
        assertThat(header.getNameFromHeader()).isEqualTo(userName);

        int age = 20;
        String dateOfBirth = new SimpleDateFormat("dd.MM.yyyy").format(new DateTime(new Date()).minusYears(age).toDate());
        String dateOfRegistration = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        String city = "Moskow";
        String caption = "Bla bla bla";
        String favoriteBoxers = "Пак, Флойд, Чико и дугие";
        String info = "Александр Емельяненко: Кто не пьет, тот не встает";
        //Update user info after registration
        ProfilePage profilePage = editProfilePage.updateProfileInfo(dateOfBirth, city, caption, favoriteBoxers, info);

        assertThat(profilePage.getUserName()).isEqualTo(userName);
        assertThat(profilePage.getDateOfRegistration()).isEqualTo("На сайте с " + dateOfRegistration);
        assertThat(profilePage.getAge()).isEqualTo("Возраст: " + age);
        assertThat(profilePage.getCity()).isEqualTo("Город: " + city);
        assertThat(profilePage.getCaption()).isEqualTo(caption);
        assertThat(profilePage.getFavoriteBoxers()).isEqualTo("Любимые боксеры: " + favoriteBoxers);
        assertThat(profilePage.getInfo()).isEqualTo(info);

    }


}
