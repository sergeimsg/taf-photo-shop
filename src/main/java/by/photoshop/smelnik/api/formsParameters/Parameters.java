package by.photoshop.smelnik.api.formsParameters;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class Parameters {
    private static Faker faker = new Faker();

    protected Map<String, Object> formsToRequest = new HashMap<>();

    public static Map<String, Object> getCorrectLoginData() {
        return new FormParameters().setLogin("login").setType("email_password").setEmail("sergei-msg@tut.by").setPassword("Rapid2132").build();
    }

    public static Map<String, Object> getRandomEmailPasword() {
        return new FormParameters().setLogin("login").setType("email_password").setEmail(faker.internet().emailAddress())
                .setPassword(faker.internet().password(5, 10)).build();
    }

    public static Map<String, Object> getAnyEmailEmptyPasword() {
        return new FormParameters().setLogin("login").setType("email_password").setEmail(faker.internet().emailAddress())
                .setPassword("").build();
    }

    public static Map<String, Object> getEmptyEmailRandomPasword() {
        return new FormParameters().setLogin("login").setType("email_password").setEmail("")
                .setPassword(faker.internet().password(5, 10)).build();
    }


}
