package com.coffeeOrderBot.CoffeeBot.command.commands;

import com.coffeeOrderBot.CoffeeBot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpCommand implements Command {

    private final SendMessageService sendMessageService;
    private final String message = "Основные команды";

    public HelpCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {

    }



}
