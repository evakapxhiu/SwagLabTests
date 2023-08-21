package basetests;

import com.google.common.io.Files;
import com.test.cases.LogInTest;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import utils.EventReporter;
import utils.WindowsManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import static basetests.Driver.getChromeDriver;

public class BaseTest {
    public static final String Baseurl = "https://www.saucedemo.com/";
    public static EventFiringWebDriver driver;

//    AboutPage aboutPage=new AboutPage(driver);
    @BeforeEach
    void setup(){
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new EventReporter());
    }
    @BeforeMethod
    public  void takeScreenshot() {
        //Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File("src/main/resources/screenshots/evaaa.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
//    @AfterEach
//    void cleanup () {
//        driver.close();
//    }
    public WindowsManager getWindowManager(){
        return new WindowsManager(driver);
    }
}
