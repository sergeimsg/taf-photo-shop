package by.photoshop.smelnik.ui.pages.popup;

import by.photoshop.smelnik.ui.data.DelayAndLength;
import by.photoshop.smelnik.ui.driver.SingletoneDriver;
import by.photoshop.smelnik.ui.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopUpPage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public PopUpPage() {
        this.driver = SingletoneDriver.getDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(DelayAndLength.DEFAULT_DURATION));
    }

    public void closePopUp() {
        By popUpWindowXPath = By.xpath(PopUpWindowXpath.CLOSE_POPUP_WINDOW);
        Waiter.wait(DelayAndLength.MIN_DURATION);
        if (driver.findElement(popUpWindowXPath).isDisplayed()) {
            WebElement popUpWindowWebElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(popUpWindowXPath));
            popUpWindowWebElement.click();
        }

    }
}
