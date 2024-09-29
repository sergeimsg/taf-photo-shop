package by.photoshop.smelnik.pageObjects.baseSettings;

import by.photoshop.smelnik.driver.SingletoneDriver;
import by.photoshop.smelnik.utils.Waiter;
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
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void closePopUp(){
        By popUpWindowXPath = By.xpath(PopUpWindowXpath.CLOSE_POPUP_WINDOW);
        Waiter.wait(2);
        if (driver.findElement(popUpWindowXPath).isDisplayed()){
            WebElement popUpWindowWebElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(popUpWindowXPath));
            popUpWindowWebElement.click();
        }

    }
}
