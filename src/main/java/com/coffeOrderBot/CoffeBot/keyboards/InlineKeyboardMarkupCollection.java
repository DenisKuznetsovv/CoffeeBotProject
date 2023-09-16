package com.coffeOrderBot.CoffeBot.keyboards;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import static com.coffeOrderBot.CoffeBot.command.enums.CommandName.*;
import static com.coffeOrderBot.CoffeBot.command.enums.DrinkButtons.*;
import static com.coffeOrderBot.CoffeBot.command.enums.VolumeButtons.*;

import java.util.ArrayList;
import java.util.List;


public class InlineKeyboardMarkupCollection {

    public static InlineKeyboardMarkup setFavoriteDrink() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton setDrinkButton = new InlineKeyboardButton();

        setDrinkButton.setText("Выбрать любимый напиток");
        setDrinkButton.setCallbackData(SET_FAVORITE_DRINK.getCommandName());

        row.add(setDrinkButton);
        rowsInLine.add(row);
        inlineKeyboardMarkup.setKeyboard(rowsInLine);

        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup helpButton(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton helpButton = new InlineKeyboardButton();

        helpButton.setText("Показать команды");
        helpButton.setCallbackData("/help");

        row.add(helpButton);
        rowsInLine.add(row);
        inlineKeyboardMarkup.setKeyboard(rowsInLine);

        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup setDrink() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInlineKeyboard = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();

        button.setText(CAPPUCCINO.getButtonText());
        button.setCallbackData(CAPPUCCINO.getCallbackData());
        row.add(button);
        button = new InlineKeyboardButton();

        button.setText(AMERICANO.getButtonText());
        button.setCallbackData(AMERICANO.getCallbackData());
        row.add(button);
        rowsInlineKeyboard.add(row);
        row = new ArrayList<>();
        button = new InlineKeyboardButton();


        button.setText(LATTE.getButtonText());
        button.setCallbackData(LATTE.getCallbackData());
        row.add(button);
        button = new InlineKeyboardButton();


        button.setText(RAF_COFFEE.getButtonText());
        button.setCallbackData(RAF_COFFEE.getCallbackData());
        row.add(button);
        rowsInlineKeyboard.add(row);
        row = new ArrayList<>();
        button = new InlineKeyboardButton();


        button.setText(ESPRESSO.getButtonText());
        button.setCallbackData(ESPRESSO.getCallbackData());
        row.add(button);
        button = new InlineKeyboardButton();

        button.setText(TEA.getButtonText());
        button.setCallbackData(TEA.getCallbackData());
        row.add(button);
        rowsInlineKeyboard.add(row);
        row = new ArrayList<>();
        button = new InlineKeyboardButton();

        button.setText(AUTHOR_DRINKS.getButtonText());
        button.setCallbackData(AUTHOR_DRINKS.getCallbackData());
        row.add(button);
        rowsInlineKeyboard.add(row);


        inlineKeyboardMarkup.setKeyboard(rowsInlineKeyboard);


        return inlineKeyboardMarkup;
    }
    public static InlineKeyboardMarkup setVolume(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInlineKeyboard = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();

        button.setText(L_020.getButtonText());
        button.setCallbackData(L_020.getCallback());
        row.add(button);
        rowsInlineKeyboard.add(row);
        button = new InlineKeyboardButton();
        row = new ArrayList<>();


        button.setText(L_025.getButtonText());
        button.setCallbackData(L_025.getCallback());
        row.add(button);
        rowsInlineKeyboard.add(row);
        button = new InlineKeyboardButton();
        row = new ArrayList<>();

        button.setText(L_030.getButtonText());
        button.setCallbackData(L_030.getCallback());
        row.add(button);
        rowsInlineKeyboard.add(row);
        button = new InlineKeyboardButton();
        row = new ArrayList<>();

        button.setText(L_035.getButtonText());
        button.setCallbackData(L_035.getCallback());
        row.add(button);
        rowsInlineKeyboard.add(row);
        button = new InlineKeyboardButton();
        row = new ArrayList<>();

        button.setText(L_040.getButtonText());
        button.setCallbackData(L_040.getCallback());
        row.add(button);

        inlineKeyboardMarkup.setKeyboard(rowsInlineKeyboard);

        return inlineKeyboardMarkup;
    }
}