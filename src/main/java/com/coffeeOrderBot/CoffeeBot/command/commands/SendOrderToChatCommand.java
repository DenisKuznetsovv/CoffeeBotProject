package com.coffeeOrderBot.CoffeeBot.command.commands;

import com.coffeeOrderBot.CoffeeBot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SendOrderToChatCommand implements Command {

    private SendMessageService sendMessageService;

    public SendOrderToChatCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendOrder("Новый заказ:\n" + update.getPreCheckoutQuery().getInvoicePayload());
    }
}
