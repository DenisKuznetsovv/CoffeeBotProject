package com.coffeOrderBot.CoffeBot.settings.enums;

public enum VolumeButtons {
    L_020("200 мл", "200ml"),
    L_025("250 мл", "250ml"),
    L_030("300 мл", "300ml"),
    L_035("350 мл", "350ml"),
    L_040("400 мл", "400ml");

    private final String buttonText;
    private final String callback;

    VolumeButtons(String buttonText, String callback) {
        this.buttonText = buttonText;
        this.callback = callback;
    }

    public String getButtonText() {
        return buttonText;
    }

    public String getCallback() {
        return callback;
    }
}
