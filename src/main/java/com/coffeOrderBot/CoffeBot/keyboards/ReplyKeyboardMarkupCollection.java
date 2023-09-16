package com.coffeOrderBot.CoffeBot.keyboards;

import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ReplyKeyboardMarkupCollection {

    public static ReplyKeyboardMarkup getBasicKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add(EmojiParser.parseToUnicode(":coffee: Заказать любимый напиток"));

        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add("Оставить отзыв");
        row.add("Изменить любимый напиток");
        row.add("Помощь");

        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows);
        return keyboardMarkup;
    }
}
