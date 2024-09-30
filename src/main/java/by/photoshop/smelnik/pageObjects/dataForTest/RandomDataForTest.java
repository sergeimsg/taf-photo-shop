package by.photoshop.smelnik.pageObjects.dataForTest;

import com.github.javafaker.Faker;

public class RandomDataForTest {
    private static Faker faker = new Faker();

    public static String getPassword() {
        return faker.internet().password(6, 10);
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getUsername() {
        return faker.name().username();
    }
}
