package by.photoshop.smelnik.pageObjects.baseSettings;

import by.photoshop.smelnik.driver.SingletoneDriver;
import by.photoshop.smelnik.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CookiePage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public CookiePage() {
        this.driver = SingletoneDriver.getDriver();
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void rejectCookieWindow() {
        By byCookieRejectXPath = By.xpath(CookieXPath.COOKIE_CLOSE_XPATH);
        Waiter.wait(2);
        if (driver.findElement(byCookieRejectXPath).isDisplayed()) {
            WebElement cookieWebElementRejectWindow = webDriverWait.until(ExpectedConditions.elementToBeClickable(byCookieRejectXPath));
            cookieWebElementRejectWindow.click();
        }
    }
}
