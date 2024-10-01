package by.photoshop.smelnik.ui;

import by.photoshop.smelnik.ui.data.LoginData;
import by.photoshop.smelnik.ui.pages.cookies.CookiePage;
import by.photoshop.smelnik.ui.pages.home.HomePage;
import by.photoshop.smelnik.ui.pages.login.LoginPage;
import by.photoshop.smelnik.ui.pages.popup.PopUpPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    @BeforeEach
    public void closeCookiesPopUp() {
        CookiePage cookiePage = new CookiePage();
        cookiePage.rejectCookieWindow();
        PopUpPage popUpPage = new PopUpPage();
        popUpPage.closePopUp();
    }

    @Test
    public void testWrongLoginData() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginWindow();
        loginPage.enterRandomLogin();
        loginPage.enterRandomPassword();
        loginPage.submitLoginForm();
        Assertions.assertEquals(HomePage.BASE_URL, loginPage.returnURl());
    }

    @Test
    public void testCorrectLoginData() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginWindow();
        loginPage.enterRightLogin();
        loginPage.enterRightPassword();
        loginPage.submitLoginForm();
        Assertions.assertEquals(HomePage.BASE_URL, loginPage.returnURl());
        Assertions.assertEquals(LoginData.RIGHT_LOGIN, loginPage.returnLoginName());
    }
}
