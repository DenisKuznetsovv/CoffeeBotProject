package com.coffeOrderBot.CoffeBot.settings.enums;

public enum DrinkButtons {
    AMERICANO("Американо", "AMERICANO"),
    CAPPUCCINO("Капучино", "CAPUCHINO"),
    ESPRESSO("Эспрессо", "ESPRESSO"),
    LATTE("Латте", "LATTE"),
    RAF_COFFEE("Раф-кофе", "RAFF"),
    AUTHOR_DRINKS("Авторские напитки", "AU_DRINKS"),
    TEA("Чай", "TEA");


    private final String buttonText;
    private final String callbackData;

    DrinkButtons(String buttonText, String callbackData) {
        this.buttonText = buttonText;
        this.callbackData = callbackData;
    }

    public String getButtonText() {
        return buttonText;
    }

    public String getCallbackData() {
        return callbackData;
    }
}
