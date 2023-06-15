package com.opencart.managers;

import com.github.javafaker.Faker;

public class DataFakerManager {

    private static Faker fakerObject = new Faker();

    public static String getRandomEmail() {
        return fakerObject.internet().emailAddress();
    }

    public static String getRandomName() {
        return fakerObject.funnyName().name();
    }

    public static String getRandomPassword(int min, int max) {
        return fakerObject.internet().password(min, max);
    }

    public static String getRandomEmail(String prefix, String sufix) {
        String randomMidPartString = String.valueOf(fakerObject.random().nextInt(1, 999999));
        return prefix + randomMidPartString + sufix;
    }
}
