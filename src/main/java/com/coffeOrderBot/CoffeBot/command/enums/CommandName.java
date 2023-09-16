package com.coffeOrderBot.CoffeBot.command.enums;

public enum CommandName {
    START("/start"),
    ORDER_FAVORITE_DRINK("Заказать любимый напиток"),
    HELP("Помощь"),
    FEEDBACK("Оставить отзыв"),
    SET_FAVORITE_DRINK("Изменить любимый напиток"),
    START_FOR_OWNER("/password");



    private final String commandName;


    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
