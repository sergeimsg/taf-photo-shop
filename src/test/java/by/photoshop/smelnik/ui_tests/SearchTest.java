package by.photoshop.smelnik.ui_tests;

import by.photoshop.smelnik.pageObjects.baseSettings.CookiePage;
import by.photoshop.smelnik.pageObjects.baseSettings.PopUpPage;
import by.photoshop.smelnik.pageObjects.searchTest.SearchPage;
import by.photoshop.smelnik.pageObjects.searchTest.SearchQueriesNames;
import by.photoshop.smelnik.utils.Waiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseTest {

    @Test
    public void testWrongLoginData() {
        SearchPage searchPage = new SearchPage();
        CookiePage cookiePage = new CookiePage();
        cookiePage.rejectCookieWindow();
        PopUpPage popUpPage = new PopUpPage();
        popUpPage.closePopUp();
        searchPage.enterSearchQuery();
        searchPage.submitSearchQuery();
        Waiter.wait(4);
        Assertions.assertEquals(SearchQueriesNames.SEARCH_RESULT1, searchPage.findSearchResult1());
    }
}
