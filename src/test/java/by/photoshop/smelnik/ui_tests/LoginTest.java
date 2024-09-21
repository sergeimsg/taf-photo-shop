package by.photoshop.smelnik.ui_tests;

import by.photoshop.smelnik.pageObjects.HomePage;
import org.junit.jupiter.api.Test;

public class LoginTest {


    @Test
    public void startHomePage(){
        HomePage homePage = new HomePage();
        homePage.startHomePage();
    }

}
