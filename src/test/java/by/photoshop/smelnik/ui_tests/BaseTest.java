package by.photoshop.smelnik.ui_tests;

import by.photoshop.smelnik.driver.SingletoneDriver;
import by.photoshop.smelnik.pageObjects.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    private WebDriver driver;

    public BaseTest() {
        this.driver = SingletoneDriver.getDriver();
    }

    @BeforeAll
    public static void startPage(){
        HomePage homePage = new HomePage();
        homePage.startHomePage();
    }

    @AfterAll
    public static void tearDown(){
        SingletoneDriver.closeDriver();
    }

}
