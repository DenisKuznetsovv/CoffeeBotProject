package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.command.commands.Command;
import com.coffeOrderBot.CoffeBot.service.keyboards.InlineKeyboardMarkupCollection;
import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SetFavoriteDrinkCommand implements Command {

    private final SendMessageService sendMessageService;

    public SetFavoriteDrinkCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        String message = "Меню кофейни";
        sendMessageService.sendMessageWithInlineKeyboardMarkup(String.valueOf(update.getCallbackQuery().getMessage().getChatId())
                ,message
                ,InlineKeyboardMarkupCollection.getMenu());
    }
}
