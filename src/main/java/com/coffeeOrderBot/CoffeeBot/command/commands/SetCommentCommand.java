package com.coffeeOrderBot.CoffeeBot.command.commands;

import com.coffeeOrderBot.CoffeeBot.model.Client;
import com.coffeeOrderBot.CoffeeBot.model.ClientRepository;
import com.coffeeOrderBot.CoffeeBot.service.SendMessageService;
import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
public class SetCommentCommand implements Command {

    private ClientRepository clientRepository;

    private final SendMessageService sendMessageService;

    public SetCommentCommand(SendMessageService sendMessageService, ClientRepository repository) {
        this.clientRepository = repository;
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();
        Optional<Client> clientOptional = clientRepository.findById(chatId);
        try {
            Client client = clientOptional.get();
            client.setComment(update.getMessage().getText());
            clientRepository.save(client);
            sendMessageService.sendMessage(String.valueOf(chatId), "Новый комментарий сохранен");
        } catch (NullPointerException | NoSuchElementException e) {
            e.printStackTrace();
            log.warn("Exception: " + e.getMessage() + "\n" + "From: " + Arrays.toString(e.getStackTrace()));
        }
    }
}
