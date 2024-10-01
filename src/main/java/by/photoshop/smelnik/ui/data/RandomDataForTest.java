package by.photoshop.smelnik.ui.data;

import com.github.javafaker.Faker;

public class RandomDataForTest {
    private static Faker faker = new Faker();

    public static String getPassword() {
        return faker.internet().password(DelayAndLength.MIN_PASSWORD, DelayAndLength.MAX_PASSWORD);
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getUsername() {
        return faker.name().username();
    }
}
