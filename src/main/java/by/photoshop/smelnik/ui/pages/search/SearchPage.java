package by.photoshop.smelnik.ui.pages.search;

import by.photoshop.smelnik.ui.data.DelayAndLength;
import by.photoshop.smelnik.ui.driver.SingletoneDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public SearchPage() {
        this.driver = SingletoneDriver.getDriver();
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(DelayAndLength.MAX_DURATION));
    }

    public void enterSearchQuery() {
        By searchQueryNameXpath = By.xpath(SearchQueriesXPath.SEARCH_FIELD_BASE_PAGE);
        driver.findElement(searchQueryNameXpath).sendKeys(SearchQueries.SEARCH_QUERY1);
    }

    public void submitSearchQuery() {
        By enterSearchButtonXpath = By.xpath(SearchQueriesXPath.SEARCH_BUTTON_START_BASE_PAGE);
        driver.findElement(enterSearchButtonXpath).click();
    }

    public String findSearchResult1() {
        By searchResultXPath = By.xpath(SearchQueriesXPath.SEARCH_RESULT1);
        return driver.findElement(searchResultXPath).getText();
    }
}
