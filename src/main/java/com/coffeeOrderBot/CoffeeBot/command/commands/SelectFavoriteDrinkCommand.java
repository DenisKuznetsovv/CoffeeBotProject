package com.coffeeOrderBot.CoffeeBot.command.commands;

import com.coffeeOrderBot.CoffeeBot.model.ClientRepository;
import com.coffeeOrderBot.CoffeeBot.model.DrinkMenuRepository;
import com.coffeeOrderBot.CoffeeBot.service.SendMessageService;
import com.coffeeOrderBot.CoffeeBot.settings.InlineKeyboardMarkupCollection;
import com.coffeeOrderBot.CoffeeBot.settings.enums.Emoji;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SelectFavoriteDrinkCommand implements Command {

    private final ClientRepository clientRepository;

    private final DrinkMenuRepository drinkMenuRepository;

    private final SendMessageService sendMessageService;

    public SelectFavoriteDrinkCommand(SendMessageService sendMessageService, ClientRepository repository,
                                      DrinkMenuRepository drinkMenuRepository) {
        this.sendMessageService = sendMessageService;
        this.clientRepository = repository;
        this.drinkMenuRepository = drinkMenuRepository;
    }

    @Override
    public void execute(Update update) {
        String message = Emoji.COFFEE.getEmoji() + "Меню кофейни:";
        String chatId = String.valueOf(update.getMessage().getChatId());

        sendMessageService.sendMessageWithInlineKeyboardMarkup(chatId, message, InlineKeyboardMarkupCollection.setDrink());
    }
}
