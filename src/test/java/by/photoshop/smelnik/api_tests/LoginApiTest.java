package by.photoshop.smelnik.api_tests;

import by.photoshop.smelnik.pageObjects.HomePage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class LoginApiTest {

    private Faker faker = new Faker();
    @Test
    public void testResponse(){

        when()
                .get(HomePage.BASE_URL)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void testEmptyLogiFields(){
        when()
                .post("https://www.onliner.by/sdapi/user.api/login")
                .then()
                .log().all()
                .body("message", equalTo("Validation failed"))
                .body("errors.login[0]", equalTo("Укажите ник или e-mail"))
                .body("errors.password[0]", equalTo("Укажите пароль"));
    }

    @Test
    public void testEmptyPasswordField(){
        when()
                .post("https://www.onliner.by/sdapi/user.api/login?login=" + faker.internet().emailAddress()+"&password=")
                .then()
                .log().all()
                .body("message", equalTo("Validation failed"))
                .body("errors.password[0]", equalTo("Укажите пароль"));
    }

    @Test
    public void testEmpryLoginField(){
        when()
                .post("https://www.onliner.by/sdapi/user.api/login?login=&password="+faker.internet().password(5,8))
                .then()
               // .log().all()
                .body("errors.login[0]", equalTo("Укажите ник или e-mail"));
    }

    @Test
    public void testWrongFields(){
        when()
                .post("https://www.onliner.by/sdapi/user.api/login?login="+faker.internet().emailAddress()+"&password="+faker.internet().password(5,8))
                .then()
                //.log().all()
                .body("errors.key[0]", equalTo("invalid_login_or_password"))
                .body("errors.message[0]", equalTo("Неверный логин или пароль"));
    }

    @Test
    public void testCorrectFields(){
        when()
                .post("https://www.onliner.by/sdapi/user.api/login?login=sergei-msg@tut.by&password=rapid2132")
                .then()
                //.log().all()
                .body("id", equalTo("guard.captcha_required"))
                .body("detail", equalTo("Пройдите проверку captcha"));
    }

}
