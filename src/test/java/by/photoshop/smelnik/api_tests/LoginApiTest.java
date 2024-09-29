package by.photoshop.smelnik.api_tests;

import by.photoshop.smelnik.api.responsLogin.Login;
import by.photoshop.smelnik.api.responsLogin.Names;
import by.photoshop.smelnik.api.responsLogin.Responses;
import by.photoshop.smelnik.api.formsParameters.Parameters;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class LoginApiTest extends BaseApiTest {



    @Test
    public void testSimpleAuthentificate(){
        RestAssured.baseURI = Names.BASE_URL;
        Response response = given()
                .formParams(Parameters.getCorrectLoginData())
                .formParam("_token", csrfToken).when().post(Names.URI_PATH_USER_AUTHANTIFICATION);
        Assertions.assertEquals(response.statusCode(), Names.REDIRECT_CODE);
    }

    @Test
    public void testGetUserDataCheckJSON() {
        Response response = given().baseUri(Names.BASE_URL).
                when().
                get(Names.URI_PATH_USER);
        response.then().body("auth_msg", equalTo(""));
    }

    @Test
    public void testLoginRedirect() {
        Response response1 = given()
                .headers(new Login().getHeaders())
                .cookies(cookies)
                .formParams(Parameters.getCorrectLoginData())
                .formParam(Names.TOKEN_NAME, csrfToken)
                .redirects().follow(false)
                .expect().statusCode(Names.REDIRECT_CODE)
                .when()
                .post(Names.URI_PATH_USER_AUTHANTIFICATION);

        Response resp2 =
                given().
                        cookies(Responses.getCookies(response1)).
                        expect().
                        statusCode(Names.ACCEPTED_CODE).
                        when().
                        get(Names.BASE_URL);
        int statusCode = Responses.getStatusCode(resp2);
        Assertions.assertEquals(statusCode, Names.ACCEPTED_CODE);
    }


    @Test
    public void testUserGet() {
        RestAssured.baseURI = Names.BASE_URL;
        Response response = when().get(Names.URI_PATH_CHECK_CSS);
        response.then()
                .body("auth_msg", equalTo(""));
        int statusCode = response.statusCode();
        Assertions.assertEquals(statusCode, Names.ACCEPTED_CODE);
    }


    @Test
    public void testGetUserWithAnyTparameters() {
        RestAssured.baseURI=Names.BASE_URL;
        Response response = given()
                .headers(new Login().getHeaders())
                .cookies(cookies)
                .when()
                .get(Names.URI_PATH_USER_AUTHANTIFICATION_ADD+Names.URI_PATH_USER_AUTHANTIFICATION_ADD_ANT_T);
        Assertions.assertEquals(response.statusCode(), Names.ERROR_CODE);
    }

}
