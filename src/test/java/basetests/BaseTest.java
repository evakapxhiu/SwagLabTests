package basetests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static basetests.Driver.getChromeDriver;

public class BaseTest {
    public static final String Baseurl = "https://www.saucedemo.com/";
    public static WebDriver driver;

    @BeforeEach
    void setup(){
        driver = getChromeDriver();
    }

//    @AfterEach
//    void cleanup(){driver.close();
//    }
}
