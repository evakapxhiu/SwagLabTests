package utils;

import org.openqa.selenium.WebDriver;

public class WindowsManager {

    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowsManager(WebDriver driver) {
        this.driver = driver;
        navigate=driver.navigate();
    }
    public void goBack(){
        navigate.back();
    }

    public void goForward(){
        navigate.refresh();
    }

    public void refresh(){
        navigate.refresh();
    }

    public void goTo(String url){
        navigate.to(url);
    }
}
