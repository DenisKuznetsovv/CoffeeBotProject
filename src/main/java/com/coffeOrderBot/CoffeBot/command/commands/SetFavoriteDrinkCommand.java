package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.model.ClientRepository;
import com.coffeOrderBot.CoffeBot.keyboards.InlineKeyboardMarkupCollection;
import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SetFavoriteDrinkCommand implements Command {

    private final ClientRepository repository;

    private final SendMessageService sendMessageService;

    public SetFavoriteDrinkCommand(SendMessageService sendMessageService, ClientRepository repository) {
        this.sendMessageService = sendMessageService;
        this.repository = repository;
    }

    @Override
    public void execute(Update update) {
        String message = "Меню кофейни";
        sendMessageService.sendMessageWithInlineKeyboardMarkup(String.valueOf(update.getCallbackQuery().getMessage().getChatId())
                , message
                , InlineKeyboardMarkupCollection.setDrink());

    }
}
