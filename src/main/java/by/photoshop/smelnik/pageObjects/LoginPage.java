package by.photoshop.smelnik.pageObjects;

import by.photoshop.smelnik.driver.SingletoneDriver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private Faker faker;
    WebDriverWait webDriverWait;

    public LoginPage() {
        this.driver = SingletoneDriver.getDriver();
        faker = new Faker();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void openLoginWindow() {
        By loginPageXpath = By.xpath(LoginObjectXpath.LOGIN_XPATH);
        WebElement loginWindowWebElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(loginPageXpath));
        loginWindowWebElement.click();
    }

    public void enterRandomLogin(){
        By loginRandomNameXpath = By.xpath(LoginObjectXpath.INPUT_LOGIN_XPATH);
        driver.findElement(loginRandomNameXpath).sendKeys(faker.internet().emailAddress());
    }

    public void enterRightLogin(){
        By loginNameXpath = By.xpath(LoginObjectXpath.INPUT_LOGIN_XPATH);
        WebElement loginWebElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(loginNameXpath));
        loginWebElement.sendKeys(LoginObjectXpath.RIGHT_LOGIN);
    }

    public void enterRightPassword(){
        By passwordXpath = By.xpath(LoginObjectXpath.INPUT_PASSWORD_XPATH);
        driver.findElement(passwordXpath).sendKeys(LoginObjectXpath.RIGHT_PASSWORD);
    }

    public void enterRandomPassword(){
        By passwordXpath = By.xpath(LoginObjectXpath.INPUT_PASSWORD_XPATH);
        driver.findElement(passwordXpath).sendKeys(faker.internet().password(6, 10));
    }

    public void submitLoginForm(){
        By enterButtonXpath = By.xpath(LoginObjectXpath.BUTTON_ENTER_XPATH);
        driver.findElement(enterButtonXpath).submit();
    }

    public String returnURl(){
         return driver.getCurrentUrl();
    }
}
