package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourCartPage {

    private WebDriver driver;

    private By checkOutButton=By.id("checkout");

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
    }

        public boolean cartContainerDisplayed() {
            try {

                WebElement homeElement = driver.findElement(By.id("shopping_cart_container"));
                return homeElement.isDisplayed();
            }
            catch (org.openqa.selenium.NoSuchElementException e) {
                return false;
            }
        }

        public CheckOutInfo checkOut(){
        driver.findElement(checkOutButton).click();
        return new CheckOutInfo(driver);
        }

    }

