package by.photoshop.smelnik.api.responsLogin;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Map;


public class Responses {
        public static String getCSRFToken(Response response){
            Document doc = Jsoup.parse(response.asString());
            Element metaTag =doc.select("input[name=_token]").first();
            return metaTag !=null ? metaTag.attr("value") :"";
        }

        public static Cookies getCookies(Response response){
            return new Cookies(
            new Cookie.Builder("XSRF-TOKEN", response.getCookies().get("XSRF-TOKEN")).build(),
                    new Cookie.Builder("beseller_session", response.getCookies().get("beseller_session")).build()
                    );
        }

        public static int getStatusCode(Response response){
            return response.getStatusCode();
        }


    public static Response performPostAuthantificationRequest(Map<String, Object> formParams, String csrfToken, Cookies cookies) {
        return RestAssured
                .given()
                .headers(new Login().getHeaders())
                .cookies(cookies)
                .formParams(formParams)
                .formParam("_token", csrfToken)
                .when()
                .post("/user/auth");
    }
}
