package com.coffeOrderBot.CoffeBot.settings.enums;

import com.vdurmont.emoji.EmojiParser;

public enum Emoji {

    TIMER_CLOCK(EmojiParser.parseToUnicode(":timer_clock:")),
    TEMP(EmojiParser.parseToUnicode(":thermometer:")),
    TIME(EmojiParser.parseToUnicode("⌛")),
    COFFEE(EmojiParser.parseToUnicode(":coffee:"));



    private final String emoji;

    public String getEmoji() {
        return emoji;
    }

    Emoji(String parseToUnicode) {
        this.emoji = parseToUnicode;
    }
}
