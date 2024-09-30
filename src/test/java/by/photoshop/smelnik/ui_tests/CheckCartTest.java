package by.photoshop.smelnik.ui_tests;

import by.photoshop.smelnik.pageObjects.baseSettings.CookiePage;
import by.photoshop.smelnik.pageObjects.baseSettings.PopUpPage;
import by.photoshop.smelnik.pageObjects.cart.CartCheck;
import by.photoshop.smelnik.pageObjects.searchTest.SearchPage;
import by.photoshop.smelnik.pageObjects.searchTest.SearchQueries;
import by.photoshop.smelnik.utils.Waiter;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckCartTest extends BaseTest{
    @BeforeEach
    public void closeCookiesPopUp(){
        CookiePage cookiePage = new CookiePage();
        cookiePage.rejectCookieWindow();
        PopUpPage popUpPage = new PopUpPage();
        popUpPage.closePopUp();
    }

    @Test
    public void testCheckOrder(){
        SearchPage searchPage = new SearchPage();
        searchPage.enterSearchQuery();
        searchPage.submitSearchQuery();
        CartCheck cartCheck = new CartCheck();
        cartCheck.addPurchase();
        Waiter.wait(5);
        cartCheck.goToCart();
        Assertions.assertEquals(SearchQueries.SEARCH_RESULT1, cartCheck.checkInCart());
    }
}
