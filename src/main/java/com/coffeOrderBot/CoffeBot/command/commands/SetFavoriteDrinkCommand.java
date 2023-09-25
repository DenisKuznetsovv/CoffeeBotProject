package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.model.ClientRepository;
import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import com.coffeOrderBot.CoffeBot.settings.InlineKeyboardMarkupCollection;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.coffeOrderBot.CoffeBot.settings.enums.Emoji.*;

public class SetFavoriteDrinkCommand implements Command {

    private final ClientRepository repository;

    private final SendMessageService sendMessageService;

    public SetFavoriteDrinkCommand(SendMessageService sendMessageService, ClientRepository repository) {
        this.sendMessageService = sendMessageService;
        this.repository = repository;
    }

    @Override
    public void execute(Update update) {
        String message = COFFEE.getEmoji() + "Меню кофейни:";
        String chatId = String.valueOf(update.getMessage().getChatId());
        sendMessageService.sendMessageWithInlineKeyboardMarkup(chatId, message, InlineKeyboardMarkupCollection.setDrink());

    }
}
