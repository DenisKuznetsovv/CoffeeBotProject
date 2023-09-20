package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.model.Client;
import com.coffeOrderBot.CoffeBot.model.ClientRepository;
import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

public class OrderFavoriteDrinkCommand implements Command {

    private ClientRepository repository;

    private final SendMessageService sendMessageService;


    public OrderFavoriteDrinkCommand(SendMessageService sendMessageService, ClientRepository repository) {
        this.repository = repository;
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();
        Optional<Client> clientOptional = repository.findById(chatId);
        Client client = clientOptional.orElse(new Client());


        sendMessageService.sendMessage(String.valueOf(-1001939600944L), "Кофееее заказааан!!!! From:" +
                client.getOrderInformation());

    }
}
