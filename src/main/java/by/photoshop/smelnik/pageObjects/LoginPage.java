package by.photoshop.smelnik.pageObjects;

import by.photoshop.smelnik.driver.SingletoneDriver;
import by.photoshop.smelnik.utils.Waiter;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver = SingletoneDriver.getDriver();
    }


    public String checkWrongLogin(){
        Faker faker = new Faker();
        String actual;
        By loginPageXpath = By.xpath(LoginObjectXpath.LOGIN_XPATH);
        driver.findElement(loginPageXpath).click();
        Waiter.wait(2);

        By loginNameXpath = By.xpath(LoginObjectXpath.INPUT_LOGIN_XPATH);
        driver.findElement(loginNameXpath).sendKeys(faker.internet().emailAddress());

        By passwordXpath = By.xpath(LoginObjectXpath.INPUT_PASSWORD_XPATH);
        driver.findElement(passwordXpath).sendKeys(faker.internet().password(6, 10));

        By enterButtonXpath = By.xpath(LoginObjectXpath.BUTTON_ENTER_XPATH);
        driver.findElement(enterButtonXpath).submit();
//        actual = driver.getCurrentUrl();
        actual = "finished";
        System.out.println(actual);


        return actual;
    }

}
