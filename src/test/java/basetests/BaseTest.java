package basetests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import pages.AboutPage;

import static basetests.Driver.getChromeDriver;

public class BaseTest {
    public static final String Baseurl = "https://www.saucedemo.com/";
    public static WebDriver driver;

    AboutPage aboutPage=new AboutPage(driver);

    @BeforeEach
    void setup(){
        driver = getChromeDriver();
    }

    @AfterEach
    void cleanup(){driver.close();
    }
}
