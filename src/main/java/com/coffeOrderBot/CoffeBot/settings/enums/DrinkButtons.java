package com.coffeOrderBot.CoffeBot.settings.enums;

public enum DrinkButtons {
    AMERICANO("Американо", "Americano"),
    CAPPUCCINO("Капучино", "Capuchino"),
    ESPRESSO("Эспрессо", "Espresso"),
    LATTE("Латте", "Latte"),
    RAF_COFFEE("Раф-кофе", "Raff"),
    CLASSIC_COFFEE("Классический кофе (Включая кофе на растительном молоке)", "Classic coffee"),
    AUTHOR_DRINKS("Авторские напитки", "Autor drinks"),
    TEA("Чай", "tea");


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
