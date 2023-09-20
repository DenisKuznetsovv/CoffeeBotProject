package com.coffeOrderBot.CoffeBot.settings;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import static com.coffeOrderBot.CoffeBot.settings.enums.CommandName.*;

import java.util.List;

public interface LIST_OF_COMMAND {
    List<BotCommand> listOfCommands = List.of(
            new BotCommand(START.getCommandName(), "Старт бота"),
            new BotCommand(ORDER_FAVORITE_DRINK.getCommandName(), "Заказать любимый напиток"),
            new BotCommand(SET_FAVORITE_DRINK.getCommandName(), "Изменить любимый напиток"),
            new BotCommand(HELP.getCommandName(), "Помощь")
    );
}
