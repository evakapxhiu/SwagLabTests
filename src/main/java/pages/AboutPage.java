package pages;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class AboutPage {
    private WebDriver driver;

    private By menuElements= By.xpath("/html/body/div[1]/header/div/div/div[1]/div[2]/div");
    private By menuIcon=By.id("react-burger-menu-btn");
    private By aboutButton=By.id("about_sidebar_link");


    public AboutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void menuIcon(){
        driver.findElement(menuIcon).click();
        driver.findElement(aboutButton).click();
    }
    public void hoverOverLinkText(){
        try {
            WebElement elementToHover=driver.findElement(menuElements);
            Actions actions=new Actions(driver);
            actions.moveToElement(elementToHover).perform();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
//    public class MenuCaption{
//        private WebElement caption;
//
//        public MenuCaption(WebElement caption) {
//            this.caption = caption;
//        }
//        public boolean isCaptionDisplayed(){
//            return caption.isDisplayed();
//        }
//        public String getTtitle(){
//            return caption.findElement(element).getText();
//        }
//
//    }
}
