package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutInfo {
    private WebDriver driver;

    private By firstNAme=By.id("first-name");
    private By lastName=By.id("last-name");

    private By zipCode=By.id("postal-code");

    private By continueButton=By.id("continue");

    private By finishButton=By.id("finish");

    public CheckOutInfo(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkOutInfoContainer() {
        try {

            WebElement homeElement = driver.findElement(By.id("checkout_info_container"));
            return homeElement.isDisplayed();
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

 public void putFirstName(String fn){
        driver.findElement(firstNAme).sendKeys(fn);
 }
    public void putLastName(String ln){
        driver.findElement(lastName).sendKeys(ln);
    }

    public void putzipCode(String zc){
        driver.findElement(zipCode).sendKeys(zc);
    }

    public void clickContinue(){
        driver.findElement(continueButton).click();
    }

    public boolean PaymentInfo() {
        try {

            WebElement homeElement = driver.findElement(By.className("summary_info"));
            return homeElement.isDisplayed();
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void finishORder(){
        driver.findElement(finishButton).click();
    }
    public boolean thankYouMessage() {
        try {

            WebElement homeElement = driver.findElement(By.id("checkout_complete_container"));
            return homeElement.isDisplayed();
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
