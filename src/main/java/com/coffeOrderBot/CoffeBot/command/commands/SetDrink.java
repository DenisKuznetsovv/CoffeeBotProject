package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.model.Client;
import com.coffeOrderBot.CoffeBot.model.ClientRepository;
import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import com.coffeOrderBot.CoffeBot.keyboards.InlineKeyboardMarkupCollection;
import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
public class SetDrink implements Command {

    private ClientRepository repository;

    private final SendMessageService sendMessageService;

    public SetDrink(SendMessageService sendMessageService, ClientRepository repository) {
        this.repository = repository;
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        Long chatID = update.getCallbackQuery().getMessage().getChatId();;
        Optional<Client> clientOptional = repository.findById(chatID);
        try{
            Client clientForRepo = clientOptional.get();
            clientForRepo.setFavorite_drink(update.getCallbackQuery().getData());
            repository.save(clientForRepo);
        } catch (NullPointerException | NoSuchElementException e){
            log.warn("Exception: " + e.getMessage() + " ||\n From: " + Arrays.toString(e.getStackTrace()));
        }

        sendMessageService.sendMessageWithInlineKeyboardMarkup(String.valueOf(chatID),
                "Выберите объем:", InlineKeyboardMarkupCollection.setVolume());
    }
}
