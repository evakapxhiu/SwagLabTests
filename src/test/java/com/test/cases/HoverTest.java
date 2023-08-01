package com.test.cases;

import basetests.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AboutPage;
import pages.LogInPage;
import pages.ProductPage;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HoverTest extends BaseTest {
    @Test
    public void testHover() {
        driver.get(Baseurl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        LogInPage logInPage = new LogInPage(driver);
        logInPage.setUsername("standard_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickButton();
        AboutPage aboutPage = new AboutPage(driver);
        aboutPage.menuIcon();
        aboutPage.hoverOverLinkText();
        WebElement tooltipElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div/div[1]/div[2]/div/div[1]/div[2]"));
        List<WebElement> links = tooltipElement.findElements(By.cssSelector(".MuiBox-root css-0"));
        for (WebElement link : links) {
            link.click();
            Assertions.assertTrue(tooltipElement.isDisplayed());
            driver.navigate().back();
        }
    }
}
