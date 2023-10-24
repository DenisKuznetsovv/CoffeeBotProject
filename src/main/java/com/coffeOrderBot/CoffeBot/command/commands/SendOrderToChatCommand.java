package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SendOrderToChatCommand implements Command {

    private SendMessageService sendMessageService;

    public SendOrderToChatCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        System.out.println("Diagnostic message-=");
        sendMessageService.sendOrder("Новый заказ:\n" + update.getPreCheckoutQuery().getInvoicePayload());
    }
}
