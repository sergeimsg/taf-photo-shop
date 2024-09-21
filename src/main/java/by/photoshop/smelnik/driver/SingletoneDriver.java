package by.photoshop.smelnik.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SingletoneDriver {
    private static WebDriver driver;
    private static WebDriverWait webDriverWait;

    private SingletoneDriver() {
    }

    public static WebDriver getDriver() {
        if (driver == null){
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
