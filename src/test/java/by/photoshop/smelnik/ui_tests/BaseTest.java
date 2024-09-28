package by.photoshop.smelnik.ui_tests;

import by.photoshop.smelnik.driver.SingletoneDriver;
import by.photoshop.smelnik.pageObjects.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    private WebDriver driver;

    public BaseTest() {
        this.driver = SingletoneDriver.getDriver();
    }

    @BeforeEach
    public void startPage(){
        HomePage homePage = new HomePage();
        homePage.startHomePage();
    }

    @AfterEach
    public void tearDown(){
        SingletoneDriver.closeDriver();
    }

}
