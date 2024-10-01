package by.photoshop.smelnik.ui.pages.home;

import by.photoshop.smelnik.ui.driver.SingletoneDriver;
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
