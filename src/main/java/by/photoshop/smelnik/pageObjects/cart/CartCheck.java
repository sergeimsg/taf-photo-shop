package by.photoshop.smelnik.pageObjects.cart;

import by.photoshop.smelnik.driver.SingletoneDriver;
import by.photoshop.smelnik.pageObjects.baseSettings.CookiePage;
import by.photoshop.smelnik.pageObjects.baseSettings.HomePage;
import by.photoshop.smelnik.pageObjects.baseSettings.PopUpPage;
import by.photoshop.smelnik.utils.Waiter;
import io.restassured.http.Cookies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartCheck {
        private WebDriver driver;
        private WebDriverWait webDriverWait;

    public CartCheck() {
        this.driver = SingletoneDriver.getDriver();
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    public void addPurchase(){
        By purchseXPath = By.xpath(CartXPath.ADD_TO_CART);
        WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(purchseXPath));
        webElement.click();
    }

    public void goToCart(){
        By goToCartXpath = By.xpath(CartXPath.GO_TO_CART);
        WebElement webElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(goToCartXpath));
        webElement.click();
    }

    public String checkInCart(){
       By purchaseXPath = By.xpath(CartXPath.CART_CHECK);
       WebElement webElement =  webDriverWait.until(ExpectedConditions.presenceOfElementLocated(purchaseXPath));
       return  webElement.getText();
    }
}
