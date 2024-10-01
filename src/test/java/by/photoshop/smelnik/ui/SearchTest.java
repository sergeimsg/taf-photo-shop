package by.photoshop.smelnik.ui;

import by.photoshop.smelnik.ui.data.DelayAndLength;
import by.photoshop.smelnik.ui.pages.cookies.CookiePage;
import by.photoshop.smelnik.ui.pages.popup.PopUpPage;
import by.photoshop.smelnik.ui.pages.search.SearchPage;
import by.photoshop.smelnik.ui.pages.search.SearchQueries;
import by.photoshop.smelnik.ui.utils.Waiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseTest {
    @BeforeEach
    public void closeCookiesPopup() {
        CookiePage cookiePage = new CookiePage();
        cookiePage.rejectCookieWindow();
        PopUpPage popUpPage = new PopUpPage();
        popUpPage.closePopUp();
    }

    @Test
    public void testSearchGoods() {
        SearchPage searchPage = new SearchPage();
        searchPage.enterSearchQuery();
        searchPage.submitSearchQuery();
        Waiter.wait(DelayAndLength.MIN_DURATION);
        Assertions.assertEquals(SearchQueries.SEARCH_RESULT1, searchPage.findSearchResult1());
    }
}
