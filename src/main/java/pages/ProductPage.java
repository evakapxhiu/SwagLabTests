package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ProductPage {

    private WebDriver driver;

    private By backPack=By.id("item_4_title_link");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkBackPackProduct(){
        driver.findElement(backPack).click();
    }
    public boolean isClicked() {
        try {

            WebElement homeElement = driver.findElement(By.id("page_wrapper"));
            return homeElement.isDisplayed();
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public List<String> productDisplayed(){
        List<WebElement> prodDisplayed= findDropEle().getAllSelectedOptions();
        return selectedEl.stream().map(e->e.getText()).collect(Collectors.toList());
    }
}
