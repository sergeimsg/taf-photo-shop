package by.photoshop.smelnik.ui_tests;

import by.photoshop.smelnik.pageObjects.HomePage;
import by.photoshop.smelnik.pageObjects.LoginPage;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{


    @Test
    public void startHomePage(){
        LoginPage loginPage = new LoginPage();
        loginPage.checkWrongLogin();

    }

}
