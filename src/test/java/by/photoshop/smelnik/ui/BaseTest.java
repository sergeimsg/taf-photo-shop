package by.photoshop.smelnik.ui;

import by.photoshop.smelnik.ui.driver.SingletoneDriver;
import by.photoshop.smelnik.ui.pages.home.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    public void startPage() {
        HomePage homePage = new HomePage();
        homePage.startHomePage();
    }

    @AfterEach
    public void tearDown() {
        SingletoneDriver.closeDriver();
    }

}
