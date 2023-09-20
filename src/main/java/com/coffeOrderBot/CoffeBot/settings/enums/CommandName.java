package com.coffeOrderBot.CoffeBot.settings.enums;

public enum CommandName {
    START("/start"),
    ORDER_FAVORITE_DRINK("/order"),
    HELP("/help"),
    FEEDBACK("/feedback"),
    SET_FAVORITE_DRINK("/set_favorite_drink"),
    START_FOR_OWNER("/password");



    private final String commandName;


    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
