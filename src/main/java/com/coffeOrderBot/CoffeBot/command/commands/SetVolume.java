package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.model.Client;
import com.coffeOrderBot.CoffeBot.model.ClientRepository;
import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import com.coffeOrderBot.CoffeBot.keyboards.ReplyKeyboardMarkupCollection;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
public class SetVolume implements Command {

    private ClientRepository repository;

    private final SendMessageService sendMessageService;

    public SetVolume(SendMessageService sendMessageService, ClientRepository repository) {
        this.sendMessageService = sendMessageService;
        this.repository = repository;
    }

    @SneakyThrows
    @Override
    public void execute(Update update) {
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        Optional<Client> clientOptional = repository.findById(chatId);
        try {
            Client client = clientOptional.get();
            client.setVolume(update.getCallbackQuery().getData());
            repository.save(client);
        } catch (NullPointerException | NoSuchElementException e) {
            log.warn("Exception: " + e.getMessage() + " ||\n From: " + Arrays.toString(e.getStackTrace()));
        }
        sendMessageService.sendMessage(String.valueOf(chatId), "Остается только добавить комментарий к заказу. ");
        Thread.sleep(2000);

        sendMessageService.sendMessage(String.valueOf(chatId), "Его можно написать в свободной форме в любой момент и он сохранится. Например написать:" + " \"С корицей и погорячее\" или \"Буду через пять минут готовьте сразу, пусть не много остынет\"");
        Thread.sleep(2000);

        sendMessageService.sendMessageWithReplyKeyboardMarkup(String.valueOf(chatId), "Конец регистрации, наколдую вам пару кнопок для заказа напитка и его изменения", ReplyKeyboardMarkupCollection.getBasicKeyboard());
    }
}
