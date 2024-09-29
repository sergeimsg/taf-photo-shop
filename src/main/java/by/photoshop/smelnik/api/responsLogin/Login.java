package by.photoshop.smelnik.api.responsLogin;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Login {
       public Headers getHeaders() {
        return new Headers(new Header(
                "user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36"),
                new Header("content-type", "application/x-www-form-urlencoded; charset=UTF-8"),
                new Header("accept",
                        "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"));
    }

    public Response performGetRequest() {
        RestAssured.baseURI = Names.BASE_URL;
        Response response = RestAssured
                .given()
                .headers(getHeaders())
                .when()
                .get(Names.URI_PATH);
        return response;
    }

}
