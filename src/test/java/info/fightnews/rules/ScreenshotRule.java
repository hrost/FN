package info.fightnews.rules;

import org.aspectj.util.FileUtil;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static info.fightnews.webtestbase.WebDriverFactory.getDriver;

/**
 * Created by mlukianenko on 5/30/17.
 */
public class ScreenshotRule extends TestWatcher {

        @Override
        protected void failed(Throwable e, Description description) {
            try {
                File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
                String baseFileName = description.getClassName() + "-" + description.getMethodName() + "-";
                StringBuilder fileName = new StringBuilder(baseFileName);
                fileName.append(new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new Date())).append(".png");
                File targetPath = new File("target/screenshots/" + fileName);
                FileUtil.copyFile(file, targetPath);
                System.out.println("Screenshot saved to: " + targetPath.toURI());
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            //makeScreenshotOnFailure();
        }
}
