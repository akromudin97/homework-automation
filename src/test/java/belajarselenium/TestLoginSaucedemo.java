package belajarselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class testlogin {
    @Test //tag untuk running script dibawah ini
    public void open_browser(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.firefoxdriver().setup();
    }
}
