package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.model.Client;
import com.coffeOrderBot.CoffeBot.model.ClientRepository;
import com.coffeOrderBot.CoffeBot.service.keyboards.InlineKeyboardMarkupCollection;
import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.sql.Timestamp;
import java.util.Arrays;

@Log4j2
public class StartCommand implements Command {

    private ClientRepository repository;

    private final SendMessageService sendMessageService;

    private static final String START_MESSAGE_1 = "Привет!" +
            " Этот бот создан чтобы воплотить мечту почти каждого кофемана.";
    private static final String START_MESSAGE_2 = "Ниже ты можешь выбрать параметры любимого напитка, чтобы" +
            " в следующий раз по пути в любимую кофейню сделать заказ буквально одной кнопкой и заблаговременно";


    public StartCommand(SendMessageService sendMessageService, ClientRepository repository) {
        this.sendMessageService = sendMessageService;
        this.repository = repository;
    }

    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE_1);

        log.info("Новый пользователь: " + update.getMessage().getChat().getUserName());
        registerUser(update.getMessage());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.warn("Exception: " + e.getMessage() + " || From: " + Arrays.toString(e.getStackTrace()));
            e.printStackTrace();
        }
        sendMessageService.sendMessageWithInlineKeyboardMarkup(update.getMessage().getChatId().toString(), START_MESSAGE_2
                , InlineKeyboardMarkupCollection.setFavoriteDrink());

    }

    private void registerUser(Message msg) {
        if (repository.findById(msg.getChatId()).isEmpty()) {

            Client client = new Client();
            client.setId(msg.getChatId());
            client.setFirstName(msg.getChat().getFirstName());
            client.setUserName(msg.getChat().getUserName());
            client.setRegisterDay(new Timestamp(System.currentTimeMillis()));

            repository.save(client);
        }
    }
}
