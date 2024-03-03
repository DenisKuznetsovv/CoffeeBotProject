package com.coffeeOrderBot.CoffeeBot.settings.enums;

import com.vdurmont.emoji.EmojiParser;

public enum Emoji {

    TIMER_CLOCK(EmojiParser.parseToUnicode(":timer_clock:")),
    TEMP(EmojiParser.parseToUnicode(":thermometer:")),
    TIME(EmojiParser.parseToUnicode("⌛")),
    COFFEE(EmojiParser.parseToUnicode(":coffee:")),
    CHECK_MARK_BUTTON(EmojiParser.parseToUnicode(":check_mark_button: "));



    private final String emoji;

    public String getEmoji() {
        return emoji;
    }

    Emoji(String parseToUnicode) {
        this.emoji = parseToUnicode;
    }
}
