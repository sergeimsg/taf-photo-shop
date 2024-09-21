package by.photoshop.smelnik.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletoneDriver {
    private static WebDriver driver;

    private SingletoneDriver() {
    }

    public static WebDriver getDriver() {
        if (driver == null){
            driver = new ChromeDriver();
        }
            driver.manage().window().maximize();
        return driver;
    }

    public void closeDriver(){
        driver.quit();
        driver = null;
    }
}
