package info.fightnews.tests;

import org.junit.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import info.fightnews.pages.Header;
import info.fightnews.pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Attachment;
import info.fightnews.rules.ScreenshotRule;

import static info.fightnews.utils.LoadProperties.getConfig;
import static info.fightnews.webtestbase.WebDriverFactory.*;

public class BaseTest {

    @BeforeClass
    public static void init() {
        startBrowser();
        LoginPage loginPage = new Header().goToLoginForm();
        loginPage.doLogin(getConfig().getProperty("email"), getConfig().getProperty("password"));
    }

    @AfterClass
    public static void tearDown() {
        finishBrowser();
    }

    @Before
    public void openHome() {
        openHomeUrl();
    }

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule();

    @Attachment("Screenshot on failure")
    public byte[] makeScreenshotOnFailure() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
