package com.coffeOrderBot.CoffeBot.service.keyboards;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ReplyKeyboardMarkupCollection {

    public static ReplyKeyboardMarkup getBasicKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("Заказать любимый напиток");
        row.add("Кто сегодня бариста?");

        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add("Оставить отзыв");
        row.add("Изменить любимый напиток");

        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows);
        return keyboardMarkup;
    }
}
