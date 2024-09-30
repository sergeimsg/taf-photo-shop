package by.photoshop.smelnik.pageObjects.baseSettings;

import by.photoshop.smelnik.driver.SingletoneDriver;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public static final String BASE_URL = "https://photo-shop.by/";

    public HomePage() {
        this.driver = SingletoneDriver.getDriver();
    }

    public void startHomePage() {
        driver.get(BASE_URL);
    }


}
