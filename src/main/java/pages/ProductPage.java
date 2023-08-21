package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductPage {

    private WebDriver driver;

    private By backPack=By.id("item_4_title_link");

    private By addButton=By.id("add-to-cart-sauce-labs-backpack");

    private By shoppingCartIcon=By.className("shopping_cart_link");
    private By dropDown=By.className("product_sort_container");
    private By removeButton=By.id("remove-sauce-labs-backpack");

    private By footer=By.className("footer");
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
    public void addToCartButton(){
        driver.findElement(addButton).click();
    }
    public boolean isAdded() {
        try {

            WebElement homeElement = driver.findElement(By.id("remove-sauce-labs-backpack"));
            return homeElement.isDisplayed();
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public void removeButton(){
            driver.findElement(removeButton).click();

    }
    public boolean isRemoved() {
        try {

            WebElement homeElement = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
            return homeElement.isDisplayed();
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public YourCartPage cartList (){
        driver.findElement(shoppingCartIcon).click();
        return new YourCartPage(driver);

    }
    private Select findDropEle(){
        return new Select(driver.findElement(dropDown));
    }
    public void selectDropDown(String option){
        findDropEle().selectByVisibleText(option);
    }
    public List<String> getSelectedOption(){
        List<WebElement> selectedEl = findDropEle().getAllSelectedOptions();
        return selectedEl.stream().map(e->e.getText()).collect(Collectors.toList());
    }
    public List<Double> getAllPrices() {
        List<WebElement> pricesElements = driver.findElements(By.className("inventory_item_price"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        FluentWait wait=new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(5))
//                .pollingEvery(Duration.ofSeconds(1))
//                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_item")));
        return pricesElements
                .stream()
                .map(WebElement::getText)
                .map(price -> Double.parseDouble(price.replaceAll("[^0-9]", "")))
                .toList();
    }

    public record Products(String title,String desc,Double price){

    }
    public List<Products> productsWeExpected(){
        List<Products> expctedProd=new ArrayList<>();
        try {
            List<String> lines= Files.readAllLines(Paths.get("src/test/products.txt"));
                for (String line : lines) {
                    String[] parts = line.split(";");
                    if (parts.length == 3) {
                        String name = parts[0].trim();
                        String description = parts[1].trim();
                        Double price = Double.parseDouble(parts[2].trim());
                        expctedProd.add(new Products(name, description, price));
                    }
                }
            }catch (IOException e){
            e.printStackTrace();
        }
        return expctedProd;
    }

    public List<String> getWebTitleProducts() {
        List<WebElement> webTitleProductElements = driver.findElements(By.className("inventory_item_name"));

        return webTitleProductElements
                .stream()
                .map(el -> el.getText().trim())
                .toList();
    }

    public List<String> getWebDescriptionProducts () {
        List<WebElement> webDescriptionProductElements = driver.findElements(By.className("inventory_item_desc"));

        return webDescriptionProductElements
                .stream()
                .map(el -> el.getText().trim())
                .toList();
    }

    public List<Double> getWebPriceProducts() {
        List<WebElement> webPriceProductElements = driver.findElements(By.className("inventory_item_price"));

        return webPriceProductElements
                .stream()
                .map(WebElement::getText)
                .map(price -> Double.parseDouble(price.trim().replaceAll("[^0-9.]", "")))
                .toList();
    }
    public void scrollToFooter(){
        WebElement footerElements=driver.findElement(footer);
        footerElements.isDisplayed();
        String script="arguments[0].scrollIntoView";
        ((JavascriptExecutor)driver).executeScript(script,footerElements);
    }
    public void scrollToFooter1(){
        WebElement footerElements=driver.findElement(footer);
        footerElements.isDisplayed();
        String script="window.scrollTo(0,document.body.scrollHeight)";
        ((JavascriptExecutor)driver).executeScript(script,footerElements);

    }
}
