package by.photoshop.smelnik.ui.pages.login;

import by.photoshop.smelnik.ui.data.DelayAndLength;
import by.photoshop.smelnik.ui.data.LoginData;
import by.photoshop.smelnik.ui.data.RandomDataForTest;
import by.photoshop.smelnik.ui.driver.SingletoneDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    WebDriverWait webDriverWait;

    public LoginPage() {
        this.driver = SingletoneDriver.getDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(DelayAndLength.MAX_DURATION));
    }

    public void openLoginWindow() {
        By loginPageXpath = By.xpath(LoginObjectXpath.LOGIN_XPATH);
        WebElement loginWindowWebElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(loginPageXpath));
        loginWindowWebElement.click();
    }

    public void enterRandomLogin() {
        By loginRandomNameXpath = By.xpath(LoginObjectXpath.INPUT_LOGIN_XPATH);
        driver.findElement(loginRandomNameXpath).sendKeys(RandomDataForTest.getEmail());
    }

    public void enterRightLogin() {
        By loginNameXpath = By.xpath(LoginObjectXpath.INPUT_LOGIN_XPATH);
        WebElement loginWebElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(loginNameXpath));
        loginWebElement.sendKeys(LoginData.RIGHT_LOGIN);
    }

    public void enterRightPassword() {
        By passwordXpath = By.xpath(LoginObjectXpath.INPUT_PASSWORD_XPATH);
        driver.findElement(passwordXpath).sendKeys(LoginData.RIGHT_PASSWORD);
    }

    public void enterRandomPassword() {
        By passwordXpath = By.xpath(LoginObjectXpath.INPUT_PASSWORD_XPATH);
        driver.findElement(passwordXpath).sendKeys(RandomDataForTest.getPassword());
    }

    public void submitLoginForm() {
        By enterButtonXpath = By.xpath(LoginObjectXpath.BUTTON_ENTER_XPATH);
        driver.findElement(enterButtonXpath).submit();
    }

    public String returnURl() {
        return driver.getCurrentUrl();
    }

    public String returnLoginName() {
        By loginNameXPath = By.xpath(LoginObjectXpath.CHECK_LOGIN_XPATH);
        WebElement loginNameWebElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(loginNameXPath));
        return loginNameWebElement.getText();
    }
}
