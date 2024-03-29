package com.coffeeOrderBot.CoffeeBot.command.commands;

import com.coffeeOrderBot.CoffeeBot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SetChatIdForOwnerCommand implements Command {

    private final SendMessageService sendMessageService;

    public SetChatIdForOwnerCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        sendMessageService.setChatIdForOrders(chatId);
    }
}
