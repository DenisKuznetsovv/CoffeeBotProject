package com.coffeeOrderBot.CoffeeBot.command.commands;

import com.coffeeOrderBot.CoffeeBot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class FeedbackCommand implements Command {

    private final SendMessageService sendMessageService;

    public FeedbackCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {

    }
}
