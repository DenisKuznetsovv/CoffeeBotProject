package com.coffeOrderBot.CoffeBot.bot;

import com.coffeOrderBot.CoffeBot.command.CallbackContainer;
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

    private final CommandContainer COMMAND_CONTAINER;

    private final CallbackContainer CALLBACK_CONTAINER;


    @Autowired
    public Bot(BotConfig config, ClientRepository repository, CommandContainer commandContainer, CallbackContainer callbackContainer) {
        this.CONFIG = config;
        this.repository = repository;
        this.COMMAND_CONTAINER = commandContainer;
        this.CALLBACK_CONTAINER = callbackContainer;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText().trim();
            System.out.println("Message: " + messageText);
            if (messageText.startsWith("/")) {
                String commandIdentifier = messageText.split(" ")[0].toLowerCase();
                COMMAND_CONTAINER.retrieveCommand(commandIdentifier).execute(update);
            }
        }
        if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            System.out.println("Callback" + callbackData);
            CALLBACK_CONTAINER.retrieveCallback(callbackData).execute(update);
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

