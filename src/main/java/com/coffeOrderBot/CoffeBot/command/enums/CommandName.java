package com.coffeOrderBot.CoffeBot.command.enums;

public enum CommandName {
    START("/start"),
    ORDER_FAVORITE_DRINK("/orderFavoriteDrink"),
    SHOW_BARISTA("/showBarista"),
    HELP("/help"),
    FEEDBACK("/feedback"),
    SET_FAVORITE_DRINK("/setFavoriteDrink");


    private final String commandName;


    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
