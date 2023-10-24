package com.coffeOrderBot.CoffeBot.settings;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import static com.coffeOrderBot.CoffeBot.settings.enums.CommandName.*;

import java.util.List;

public interface LIST_OF_COMMAND_FOR_CUSTOMERS {
    List<BotCommand> listOfCommands = List.of(
            new BotCommand(START.getCommandName(), START.getDescription()),
            new BotCommand(ORDER_FAVORITE_DRINK.getCommandName(), ORDER_FAVORITE_DRINK.getDescription()),
            new BotCommand(SET_FAVORITE_DRINK.getCommandName(), SET_FAVORITE_DRINK.getDescription()),
            new BotCommand(HELP.getCommandName(), HELP.getDescription())
    );
}
