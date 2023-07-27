package com.test.cases;

import basetests.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LogInPage;

import java.util.concurrent.TimeUnit;

public class LogInTest extends BaseTest {
    @Test
    public void LoginSucess(){
        driver.get(Baseurl);
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS);

        LogInPage logInPage=new LogInPage(driver);
        logInPage.setUsername("standard_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickButton();
        Assertions.assertTrue(logInPage.isLoggedIn());
    }

    @Test
    public void LoginUnsucessful(){
        driver.get(Baseurl);
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS);

        LogInPage logInPage=new LogInPage(driver);
        logInPage.setUsername("locked_out_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickButton();
        WebElement errorContainer=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]"));
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.",errorContainer.getText());
    }
    @Test
    public void LoginWithEmptyFields(){
        driver.get(Baseurl);
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS);

        LogInPage logInPage=new LogInPage(driver);
        logInPage.Login_EmptyFields();

        String message="Epic sadface: Username is required";
        WebElement errorMessage= driver.findElement(By.xpath("//h3[@data-test='error']"));
        String actual=errorMessage.getText();
        Assertions.assertEquals(message,actual);
    }

    @Test
    public void logOutWithSucess(){
        driver.get(Baseurl);
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS);

        LogInPage logInPage=new LogInPage(driver);
        logInPage.setUsername("standard_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickButton();
        logInPage.LogOut();
        Assertions.assertFalse(logInPage.idLoggedOut());
    }
}
