package com.coffeOrderBot.CoffeBot.bot;

import com.coffeOrderBot.CoffeBot.command.CallbackContainer;
import com.coffeOrderBot.CoffeBot.command.CommandContainer;
import com.coffeOrderBot.CoffeBot.config.BotConfig;
import com.coffeOrderBot.CoffeBot.model.ClientRepository;
import com.coffeOrderBot.CoffeBot.model.DrinkRepository;
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

import static com.coffeOrderBot.CoffeBot.settings.LIST_OF_COMMAND.*;

@Log4j2
@Component
public class Bot extends TelegramLongPollingBot {

    private ClientRepository clientRepository;

    private DrinkRepository drinkRepository;

    private final BotConfig CONFIG;

    private final CommandContainer COMMAND_CONTAINER;

    private final CallbackContainer CALLBACK_CONTAINER;


    @Autowired
    public Bot(BotConfig config, ClientRepository clientRepository, CommandContainer commandContainer,
               CallbackContainer callbackContainer, DrinkRepository drinkRepository) {
        this.clientRepository = clientRepository;
        this.drinkRepository = drinkRepository;
        this.CONFIG = config;
        this.COMMAND_CONTAINER = commandContainer;
        this.CALLBACK_CONTAINER = callbackContainer;
        try {
            this.execute(new SetMyCommands(listOfCommands, new BotCommandScopeDefault(), null));
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
            }
        }
        if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            System.out.println("Callback: " + callbackData);
            CALLBACK_CONTAINER.retrieveCallback(callbackData).execute(update);
        }
        if (update.hasPreCheckoutQuery()){
            PreCheckoutQuery preCheckoutQuery = update.getPreCheckoutQuery();
            //Здесь добавить if(проверку по стоп-листу)
            this.execute(new AnswerPreCheckoutQuery(preCheckoutQuery.getId(), true));
            new SendOrderToChat().execute();

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

