package com.test.cases;

import basetests.BaseTest;
import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LogInPage;
import pages.ProductPage;

import java.util.concurrent.TimeUnit;

public class ProductTest extends BaseTest {

    @Test
    public void checkBackPackPro(){
        driver.get(Baseurl);
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS);
        LogInPage logInPage=new LogInPage(driver);
        logInPage.setUsername("standard_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickButton();
        ProductPage prodPage=new ProductPage(driver);
        prodPage.checkBackPackProduct();
        Assertions.assertTrue(prodPage.isClicked());
    }
}
