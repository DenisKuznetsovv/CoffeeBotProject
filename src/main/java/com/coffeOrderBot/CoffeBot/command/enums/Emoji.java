package com.coffeOrderBot.CoffeBot.command.enums;

import com.vdurmont.emoji.EmojiParser;

public enum Emoji {

    COFFEE(EmojiParser.parseToUnicode(":coffee:"));



    private final String parseToUnicode;

    Emoji(String parseToUnicode) {
        this.parseToUnicode = parseToUnicode;
    }
}
