package com.coffeOrderBot.CoffeBot.settings;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import static com.coffeOrderBot.CoffeBot.settings.enums.Emoji.*;

import java.util.ArrayList;
import java.util.List;

public class ReplyKeyboardMarkupCollection {

    public static ReplyKeyboardMarkup getBasicKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> keyboardRows = new ArrayList<>();
//Добавить комментариев
        KeyboardRow row = new KeyboardRow();
        row.add(COFFEE.getEmoji() + "С корицей");

        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add(TEMP.getEmoji() + "Погорячее");
        row.add(TEMP.getEmoji() + "Негорячий");
        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add(TIME.getEmoji() + "Буду через 5 минут");
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows);
        return keyboardMarkup;
    }

    /*public static List<BotCommand> getMenu(){
        List<BotCommand> listOfCommands = new ArrayList<>();

        listOfCommands.add(new BotCommand(START.getCommandName(), "Старт бота"));
        listOfCommands.add(new BotCommand(ORDER_FAVORITE_DRINK.getCommandName(), "Заказать любимый напиток"));
        listOfCommands.add(new BotCommand(SET_FAVORITE_DRINK.getCommandName(), "Изменить любимый напиток"));
        listOfCommands.add(new BotCommand(HELP.getCommandName(), "Помощь"));

        return listOfCommands;

    }*/
}
