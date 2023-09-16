package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartForOwner implements Command {

    private final SendMessageService sendMessageService;

    public StartForOwner(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        sendMessageService.sendMessage(chatId, "Привет из чата!!!");
    }
}
