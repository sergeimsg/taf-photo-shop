package by.photoshop.smelnik.ui_tests;

import by.photoshop.smelnik.pageObjects.CookiePage;
import by.photoshop.smelnik.pageObjects.LoginPage;
import by.photoshop.smelnik.pageObjects.PopUpPage;
import by.photoshop.smelnik.utils.Waiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{


    @Test
    public void testWrongLoginData(){
        LoginPage loginPage = new LoginPage();
        CookiePage cookiePage = new CookiePage();
        cookiePage.rejectCookieWindow();
        PopUpPage popUpPage = new PopUpPage();
        popUpPage.closePopUp();
        loginPage.openLoginWindow();
        loginPage.enterRandomLogin();
        loginPage.enterRandomPassword();
        loginPage.submitLoginForm();
        Assertions.assertEquals("https://photo-shop.by/", loginPage.returnURl());

    }

    @Test
    public void testCorrectLoginData(){
        LoginPage loginPage = new LoginPage();
        CookiePage cookiePage = new CookiePage();
        cookiePage.rejectCookieWindow();
        PopUpPage popUpPage = new PopUpPage();
        popUpPage.closePopUp();
        loginPage.openLoginWindow();
        loginPage.enterRightLogin();
        loginPage.enterRightPassword();
        loginPage.submitLoginForm();
        Assertions.assertEquals("https://photo-shop.by/", loginPage.returnURl());
    }

}
