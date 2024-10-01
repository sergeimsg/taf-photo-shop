package by.photoshop.smelnik.api;


import by.photoshop.smelnik.api.responsLogin.Login;
import by.photoshop.smelnik.api.responsLogin.Responses;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;

public class BaseApiTest {
    protected String csrfToken;
    protected Cookies cookies;

    @BeforeEach
    public void getCSRFcookies() {
        Response response = new Login().performGetRequest();
        csrfToken = Responses.getCSRFToken(response);
        cookies = Responses.getCookies(response);
    }

}
