package com.coffeeOrderBot.CoffeeBot.settings.enums;

public enum CommandName {
    START("/start", "Старт бота"),
    ORDER_FAVORITE_DRINK("/order", "Заказать любимый напиток"),
    HELP("/help", "Помощь"),
    FEEDBACK("/feedback", "Отзывы"),
    SET_FAVORITE_DRINK("/set_favorite_drink", "Изменить любимый напиток"),
    SEND_ORDER_TO_CHAT("/sendOrderToChat", "Отправить сообщение в чат"),
    START_FOR_OWNER("/password", "Старт для владельца");



    private final String commandName;
    private final String description;


    CommandName(String commandName, String description) {
        this.commandName = commandName;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getCommandName() {
        return commandName;
    }
}
