package by.photoshop.smelnik.api_tests;

import by.photoshop.smelnik.api.responsLogin.Login;
import by.photoshop.smelnik.api.responsLogin.ApiPathes;
import by.photoshop.smelnik.api.responsLogin.Responses;
import by.photoshop.smelnik.api.formsParameters.Parameters;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class LoginApiTest extends BaseApiTest {

    @Test
    public void testSimpleAuthentificate() {
        RestAssured.baseURI = ApiPathes.BASE_URL;
        Response response = given()
                .formParams(Parameters.getRandomEmailPasword())
                .formParam("_token", csrfToken).when().post(ApiPathes.URI_PATH_USER_AUTHANTIFICATION);
        Assertions.assertEquals(HttpStatus.SC_MOVED_TEMPORARILY, response.statusCode(), "Should be redirected");
    }

    @Test
    public void testGetUserDataCheckJSON() {
        Response response = given()
                .baseUri(ApiPathes.BASE_URL)
                .when()
                .get(ApiPathes.URI_PATH_USER);
        response.then().body("auth_msg", equalTo(""));
    }

    @Test
    public void testLoginRedirect() {
        Response response1 = given()
                .headers(new Login().getHeaders())
                .cookies(cookies)
                .formParams(Parameters.getCorrectLoginData())
                .formParam(ApiPathes.TOKEN_NAME, csrfToken)
                .redirects().follow(false)
                .expect().statusCode(HttpStatus.SC_MOVED_TEMPORARILY)
                .when()
                .post(ApiPathes.URI_PATH_USER_AUTHANTIFICATION);

        Response resp2 =
                given()
                        .cookies(Responses.getCookies(response1))
                        .expect()
                        .statusCode(HttpStatus.SC_OK)
                        .when()
                        .get(ApiPathes.BASE_URL);
        int statusCode = Responses.getStatusCode(resp2);
        Assertions.assertEquals(HttpStatus.SC_OK, statusCode, "Should be 200 code" );
    }

    @Test
    public void testUserGet() {
        RestAssured.baseURI = ApiPathes.BASE_URL;
        Response response = when().get(ApiPathes.URI_PATH_CHECK_CSS);
        response.then()
                .body("auth_msg", equalTo(""));
        int statusCode = response.statusCode();
        Assertions.assertEquals(HttpStatus.SC_OK, statusCode);
    }

    @Test
    public void testGetUserWithAnyTparameters() {
        RestAssured.baseURI = ApiPathes.BASE_URL;
        Response response = given()
                .headers(new Login().getHeaders())
                .cookies(cookies)
                .when()
                .get(ApiPathes.URI_PATH_USER_AUTHANTIFICATION_ADD + ApiPathes.URI_PATH_USER_AUTHANTIFICATION_ADD_ANT_T);
        Assertions.assertEquals( HttpStatus.SC_NOT_FOUND, response.statusCode(), "Not Found");
    }
}
