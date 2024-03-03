package com.coffeeOrderBot.CoffeeBot.command.commands;

import com.coffeeOrderBot.CoffeeBot.model.Client;
import com.coffeeOrderBot.CoffeeBot.model.ClientRepository;
import com.coffeeOrderBot.CoffeeBot.service.SendMessageService;
import com.coffeeOrderBot.CoffeeBot.settings.ReplyKeyboardMarkupCollection;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
public class SetVolumeCommand implements Command {

    private ClientRepository clientRepository;

    private final SendMessageService sendMessageService;

    public SetVolumeCommand(SendMessageService sendMessageService, ClientRepository repository) {
        this.sendMessageService = sendMessageService;
        this.clientRepository = repository;
    }

    @SneakyThrows
    @Override
    public void execute(Update update) {
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        Optional<Client> clientOptional = clientRepository.findById(chatId);
        try {
            Client client = clientOptional.get();
            client.setVolume(update.getCallbackQuery().getData());
            clientRepository.save(client);
        } catch (NullPointerException | NoSuchElementException e) {
            log.warn("Exception: " + e.getMessage() + " ||\n From: " + Arrays.toString(e.getStackTrace()));
        }
        sendMessageService.sendMessage(String.valueOf(chatId), "Остается только добавить комментарий к заказу. ");
        Thread.sleep(2000);

        sendMessageService.sendMessage(String.valueOf(chatId), "Его можно написать в свободной форме. Например написать:" + " \"С корицей и погорячее\" или \"Буду через пять минут готовьте сразу, пусть не много остынет\"");
        Thread.sleep(2000);

        sendMessageService.sendMessageWithReplyKeyboardMarkup(String.valueOf(chatId)
                ,"Конец регистрации, оставлю для вас пару кнопок для комментариев."
                , ReplyKeyboardMarkupCollection.getBasicKeyboard());

    }
}
