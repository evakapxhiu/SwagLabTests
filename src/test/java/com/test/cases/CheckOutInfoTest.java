package com.test.cases;

import basetests.BaseTest;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import pages.CheckOutInfo;
import pages.LogInPage;
import pages.ProductPage;

import java.util.concurrent.TimeUnit;

public class CheckOutInfoTest extends BaseTest {
    @Test
    public void checkOutInfoTest(){
        driver.get(Baseurl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LogInPage logInPage = new LogInPage(driver);
        logInPage.setUsername("standard_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickButton();
        ProductPage prodPage = new ProductPage(driver);
        prodPage.addToCartButton();
        CheckOutInfo myInfo=prodPage.cartList().checkOut();
        myInfo.putFirstName("Eva");
        myInfo.putLastName("Kapxhiu");
        myInfo.putzipCode("2222");
        myInfo.clickContinue();
        Assert.assertTrue(myInfo.PaymentInfo());
        myInfo.finishORder();
        Assert.assertTrue(myInfo.thankYouMessage());
    }

}
