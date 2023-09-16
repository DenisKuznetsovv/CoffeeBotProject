package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.model.Client;
import com.coffeOrderBot.CoffeBot.model.ClientRepository;
import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
public class SetComment implements Command {

    private ClientRepository repository;

    private final SendMessageService sendMessageService;

    public SetComment(SendMessageService sendMessageService, ClientRepository repository) {
        this.repository = repository;
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();
        Optional<Client> clientOptional = repository.findById(chatId);
        try {
            Client client = clientOptional.get();
            client.setComment(update.getMessage().getText());
            repository.save(client);
            sendMessageService.sendMessage(String.valueOf(chatId), "Новый комментарий сохранен");
        } catch (NullPointerException | NoSuchElementException e) {
            e.printStackTrace();
            log.warn("Exception: " + e.getMessage() + "\n" + "From: " + Arrays.toString(e.getStackTrace()));
        }
    }
}
