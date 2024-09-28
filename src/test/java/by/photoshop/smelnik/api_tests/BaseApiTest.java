package by.photoshop.smelnik.api_tests;


import by.photoshop.smelnik.api_tests.utils.Names;
import by.photoshop.smelnik.api_tests.utils.forms.FormParameters;
import by.photoshop.smelnik.api_tests.utils.Login;
import by.photoshop.smelnik.api_tests.utils.Responses;
import by.photoshop.smelnik.api_tests.utils.forms.Parameters;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class BaseApiTest {
    protected String csrfToken;
    protected Cookies cookies;

    @BeforeEach
    public void getCSRF() {
        Response response = new Login().performGetRequest();
        csrfToken = Responses.getCSRFToken(response);
        cookies = Responses.getCookies(response);
    }

}
