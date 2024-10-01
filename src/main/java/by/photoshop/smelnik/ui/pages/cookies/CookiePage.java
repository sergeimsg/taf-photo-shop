package by.photoshop.smelnik.ui.pages.cookies;

import by.photoshop.smelnik.ui.data.DelayAndLength;
import by.photoshop.smelnik.ui.driver.SingletoneDriver;
import by.photoshop.smelnik.ui.utils.Waiter;
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
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(DelayAndLength.DEFAULT_DURATION));
    }

    public void rejectCookieWindow() {
        By byCookieRejectXPath = By.xpath(CookieXPath.COOKIE_CLOSE_XPATH);
        Waiter.wait(DelayAndLength.MIN_DURATION);
        if (driver.findElement(byCookieRejectXPath).isDisplayed()) {
            WebElement cookieWebElementRejectWindow = webDriverWait.until(ExpectedConditions.elementToBeClickable(byCookieRejectXPath));
            cookieWebElementRejectWindow.click();
        }
    }
}
