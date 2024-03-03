package com.coffeeOrderBot.CoffeeBot.settings.enums;

public enum MilkType {

    COW_MILK("Коровье", "cow"),
    COCONUT("Кокосовое", "coconut"),
    AMOUNT("Миндальное", "amount"),
    SOY("Соевое", "soy"),
    OAT("Овсяное", "oat"),
    BANANA("Банановое", "banana"),
    NO("Без молока","no")
    ;


    private String buttonText;
    private String callbackData;

    MilkType(String buttonText, String callbackData) {
        this.buttonText = buttonText;
        this.callbackData = callbackData;
    }
}
