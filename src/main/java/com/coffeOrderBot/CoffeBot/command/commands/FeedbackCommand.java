package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class FeedbackCommand implements Command {

    private final SendMessageService sendMessageService;

    public FeedbackCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        //Оценка заказа по пятибалльной шкале, при получении 5ти звезд ссылки на ресурсы, при оценке 2-1 отзыв менеджеру
        //
    }
}
