package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.model.Client;
import com.coffeOrderBot.CoffeBot.model.ClientRepository;
import com.coffeOrderBot.CoffeBot.model.DrinkMenuRepository;
import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.payments.LabeledPrice;

import java.util.List;
import java.util.Optional;

public class OrderFavoriteDrinkCommand implements Command {

    private ClientRepository clientRepository;

    private final DrinkMenuRepository drinkMenuRepository;

    private final SendMessageService sendMessageService;




    public OrderFavoriteDrinkCommand(SendMessageService sendMessageService, ClientRepository repository,
                                     DrinkMenuRepository drinkMenuRepository) {
        this.clientRepository = repository;
        this.sendMessageService = sendMessageService;
        this.drinkMenuRepository = drinkMenuRepository;
    }

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();
        Optional<Client> clientOptional = clientRepository.findById(chatId);
        Client client = clientOptional.orElse(new Client());

        List<LabeledPrice> prices = List.of(
                new LabeledPrice("Цена напитка", 1000000)
        );

        sendMessageService.sendInvoice(String.valueOf(chatId), client.getFavorite_drink(), client.getVolume(),client.getOrderInformation(), prices);
    }
}
