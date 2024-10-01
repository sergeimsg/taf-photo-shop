package by.photoshop.smelnik.ui;

import by.photoshop.smelnik.ui.data.DelayAndLength;
import by.photoshop.smelnik.ui.pages.cart.CartCheck;
import by.photoshop.smelnik.ui.pages.cookies.CookiePage;
import by.photoshop.smelnik.ui.pages.popup.PopUpPage;
import by.photoshop.smelnik.ui.pages.search.SearchPage;
import by.photoshop.smelnik.ui.pages.search.SearchQueries;
import by.photoshop.smelnik.ui.utils.Waiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckCartTest extends BaseTest {
    @BeforeEach
    public void closeCookiesPopUp() {
        CookiePage cookiePage = new CookiePage();
        cookiePage.rejectCookieWindow();
        PopUpPage popUpPage = new PopUpPage();
        popUpPage.closePopUp();
    }

    @Test
    public void testCheckOrder() {
        SearchPage searchPage = new SearchPage();
        searchPage.enterSearchQuery();
        searchPage.submitSearchQuery();
        CartCheck cartCheck = new CartCheck();
        cartCheck.addPurchase();
        Waiter.wait(DelayAndLength.MIN_DURATION);
        cartCheck.goToCart();
        Assertions.assertEquals(SearchQueries.SEARCH_RESULT1, cartCheck.checkInCart());
    }
}
