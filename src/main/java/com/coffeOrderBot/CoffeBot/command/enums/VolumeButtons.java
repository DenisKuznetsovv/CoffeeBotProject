package com.coffeOrderBot.CoffeBot.command.enums;

public enum VolumeButtons {
    L_020("0.20"),
    L_025("0.25"),
    L_030("0.30"),
    L_035("0.35"),
    L_040("0.40");

    private final String buttonText;

    VolumeButtons(String buttonText) {
        this.buttonText = buttonText;
    }
}
