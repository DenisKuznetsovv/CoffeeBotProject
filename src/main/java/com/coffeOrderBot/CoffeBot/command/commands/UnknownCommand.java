package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import com.coffeOrderBot.CoffeBot.settings.InlineKeyboardMarkupCollection;
import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.meta.api.objects.Update;

@Log4j2
public class UnknownCommand implements Command {

    private final SendMessageService sendMessageService;

    public UnknownCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        log.debug("Набрана неизвестная команда: " + update.getMessage().getText());
        String unknownCommandMessage = "Неизвестная команда мы ее записали и сделаем все возможное чтобы внедрить" +
                " ниже можете посмотреть список всех команд";
        sendMessageService.sendMessageWithInlineKeyboardMarkup(update.getMessage().getChatId().toString(), unknownCommandMessage
        , InlineKeyboardMarkupCollection.helpButton());
    }
}
