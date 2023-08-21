package com.test.cases;

import basetests.BaseTest;
import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CheckOutInfo;
import pages.LogInPage;
import pages.ProductPage;
import pages.YourCartPage;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductTest extends BaseTest {


    @Test
    public void checkBackPackPro() {
        driver.get(Baseurl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        LogInPage logInPage = new LogInPage(driver);
        logInPage.setUsername("standard_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickButton();
        ProductPage prodPage = new ProductPage(driver);
        prodPage.checkBackPackProduct();
        Assertions.assertTrue(prodPage.isClicked());
    }

    @Test
    public void addTocart() {
        driver.get(Baseurl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        LogInPage logInPage = new LogInPage(driver);
        logInPage.setUsername("standard_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickButton();
        ProductPage prodPage = new ProductPage(driver);
        prodPage.addToCartButton();
        Assertions.assertTrue(prodPage.isAdded());
    }

    @Test
    public void removeFromCart(){
        driver.get(Baseurl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LogInPage logInPage = new LogInPage(driver);
        logInPage.setUsername("standard_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickButton();
        ProductPage prodPage = new ProductPage(driver);
        prodPage.addToCartButton();
        prodPage.removeButton();
        Assertions.assertTrue(prodPage.isRemoved());
    }

    @Test
    public void cartContainer() {
        driver.get(Baseurl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        LogInPage logInPage = new LogInPage(driver);
        logInPage.setUsername("standard_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickButton();
        ProductPage prodPage = new ProductPage(driver);
        prodPage.addToCartButton();
        YourCartPage yourCartPage = prodPage.cartList();
        Assertions.assertTrue(yourCartPage.cartContainerDisplayed());
    }

    @Test
    public void yourInformation() {
        driver.get(Baseurl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        LogInPage logInPage = new LogInPage(driver);
        logInPage.setUsername("standard_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickButton();
        ProductPage prodPage = new ProductPage(driver);
        prodPage.addToCartButton();
        CheckOutInfo myInfo = prodPage.cartList().checkOut();
        Assertions.assertTrue(myInfo.checkOutInfoContainer());
    }

    @Test
    public void dropDownOption() {
        driver.get(Baseurl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LogInPage logInPage = new LogInPage(driver);
        logInPage.setUsername("standard_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickButton();
        ProductPage prodPage = new ProductPage(driver);
        String option = "Price (low to high)";
        prodPage.selectDropDown(option);
        var selectedOpt = prodPage.getSelectedOption();
        Assertions.assertEquals(selectedOpt.size(), 1, "Something");
        Assertions.assertTrue(selectedOpt.contains(option), "Option not selected");
        List<Double> prices = prodPage.getAllPrices();
        for (int i = 0; i < prices.size()-1; i++) {
            Assertions.assertTrue(prices.get(i) <= prices.get(i + 1));
        }
    }
    @Test
    public void getAllTheProducts(){
        driver.get(Baseurl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        LogInPage logInPage = new LogInPage(driver);
        logInPage.setUsername("standard_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickButton();
        ProductPage productsPage = new ProductPage(driver);
        var webTitleProducts = productsPage.getWebTitleProducts();
        var webDescriptionProducts = productsPage.getWebDescriptionProducts();
        var webPriceProducts = productsPage.getWebPriceProducts();
        var factualProducts = productsPage.productsWeExpected();
        for (ProductPage.Products prod : factualProducts) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_item")));
            Assertions.assertTrue(webTitleProducts.contains(prod.title()));
            Assertions.assertTrue(webDescriptionProducts.contains(prod.desc()));
            Assertions.assertTrue(webPriceProducts.contains(prod.price()));
        }
    }
    @Test
    public void scrollUntilTheFooterIsInView(){
        driver.get(Baseurl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        LogInPage logInPage = new LogInPage(driver);
        logInPage.setUsername("standard_user");
        logInPage.setPassword("secret_sauce");
        logInPage.clickButton();
        ProductPage prodPage = new ProductPage(driver);
//        prodPage.scrollToFooter();
        prodPage.scrollToFooter1();
    }
}
