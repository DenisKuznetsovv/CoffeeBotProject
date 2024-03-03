package com.coffeeOrderBot.CoffeeBot.bot;

import com.coffeeOrderBot.CoffeeBot.command.CallbackContainer;
import com.coffeeOrderBot.CoffeeBot.command.CommandContainer;
import com.coffeeOrderBot.CoffeeBot.config.BotConfig;
import com.coffeeOrderBot.CoffeeBot.model.ClientRepository;
import com.coffeeOrderBot.CoffeeBot.model.DrinkMenuRepository;
import com.coffeeOrderBot.CoffeeBot.settings.LIST_OF_COMMAND_FOR_CUSTOMERS;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerPreCheckoutQuery;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.payments.PreCheckoutQuery;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;

@Log4j2
@Component
public class Bot extends TelegramLongPollingBot {

    private ClientRepository clientRepository;

    private DrinkMenuRepository drinkRepository;

    private final BotConfig CONFIG;

    private final CommandContainer COMMAND_CONTAINER;

    private final CallbackContainer CALLBACK_CONTAINER;

    @SneakyThrows
    @Autowired
    public Bot(BotConfig config, ClientRepository clientRepository, CommandContainer commandContainer,
               CallbackContainer callbackContainer, DrinkMenuRepository drinkRepository) {
        this.clientRepository = clientRepository;
        this.drinkRepository = drinkRepository;
        this.CONFIG = config;
        this.COMMAND_CONTAINER = commandContainer;
        this.CALLBACK_CONTAINER = callbackContainer;
        try {
            this.execute(new SetMyCommands(LIST_OF_COMMAND_FOR_CUSTOMERS.listOfCommands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            log.warn("Exception: " + e.getMessage() + "\n From: " + Arrays.toString(e.getStackTrace()));
        }

    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText().trim();
            System.out.println("Message: " + messageText);
            if (messageText.startsWith("/")) {
                String commandIdentifier = messageText.split(" ")[0].toLowerCase();
                COMMAND_CONTAINER.retrieveCommand(commandIdentifier).execute(update);
            } else {
                COMMAND_CONTAINER.getSetComment().execute(update);
            }
        }
        if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            System.out.println("Callback: " + callbackData);
            CALLBACK_CONTAINER.retrieveCallback(callbackData).execute(update);
        }
        if (update.hasPreCheckoutQuery()) {
            PreCheckoutQuery preCheckoutQuery = update.getPreCheckoutQuery();
            this.execute(new AnswerPreCheckoutQuery(preCheckoutQuery.getId(), true));
            COMMAND_CONTAINER.retrieveCommand("/sendOrderToChat").execute(update);
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

