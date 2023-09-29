package smule.utility;

import smule.base.BaseClass;
import com.github.javafaker.Faker;

public class FakerClass extends BaseClass {

    public static String generateBio() {
        Faker faker = new Faker();
        String bio = faker.music().instrument();
        return bio;
    }
}