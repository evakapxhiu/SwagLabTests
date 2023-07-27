package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage  {
    private WebDriver driver;

    private By usernameField=By.id("user-name");
    private By passField=By.id("password");

    private By button=By.id("login-button");

    private By menuBar=By.id("react-burger-menu-btn");

    private By logOutButton=By.id("logout_sidebar_link");

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passField).sendKeys(password);
    }

    public void clickButton(){
        driver.findElement(button).click();
    }


    public boolean isLoggedIn() {
        try {

            WebElement homeElement = driver.findElement(By.id("inventory_container"));
            return homeElement.isDisplayed();
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public void Login_EmptyFields(){
        driver.findElement(button).click();
    }

    public void LogOut(){
        driver.findElement(menuBar).click();
        driver.findElement(logOutButton).click();
    }

    public boolean idLoggedOut() {
        try {

            WebElement homeElement = driver.findElement(By.id("inventory_container"));
            return homeElement.isDisplayed();
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
