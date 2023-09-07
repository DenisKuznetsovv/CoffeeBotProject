package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ShowBaristaCommand implements Command {

    private final SendMessageService sendMessageService;

    public ShowBaristaCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        //Отправляет фотографию бариста на смене.
    }
}
