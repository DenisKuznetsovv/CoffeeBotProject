package com.coffeOrderBot.CoffeBot.bot;

import com.coffeOrderBot.CoffeBot.command.CommandContainer;
import com.coffeOrderBot.CoffeBot.config.BotConfig;
import com.coffeOrderBot.CoffeBot.model.ClientRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Log4j2
@Component
public class Bot extends TelegramLongPollingBot {

    private ClientRepository repository;

    private final BotConfig CONFIG;

    private final CommandContainer COMMAND_CONTAINER/* = new CommandContainer(new SendMessageServiceImpl(this), repository)*/;

    @Autowired
    public Bot(BotConfig config, ClientRepository repository, CommandContainer container) {
        this.CONFIG = config;
        this.repository = repository;
        this.COMMAND_CONTAINER = container;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText().trim();
            if (messageText.startsWith("/")) {
                String commandIdentifier = messageText.split(" ")[0].toLowerCase();
                COMMAND_CONTAINER.retrieveCommand(commandIdentifier).execute(update);
            }
        }
        if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            System.out.println(callbackData);
            COMMAND_CONTAINER.retrieveCommand(callbackData).execute(update);
        }
    }

    @Override
    public String getBotUsername() {
        return CONFIG.getName();
    }

    @Override
    public String getBotToken() {
        return CONFIG.getToken();
    }

}
