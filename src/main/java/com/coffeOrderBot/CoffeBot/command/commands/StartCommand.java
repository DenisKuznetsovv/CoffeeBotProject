package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.model.Client;
import com.coffeOrderBot.CoffeBot.model.ClientRepository;
import com.coffeOrderBot.CoffeBot.model.Drink;
import com.coffeOrderBot.CoffeBot.model.DrinkRepository;
import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.sql.Timestamp;
import java.util.Optional;

@Log4j2
public class StartCommand implements Command {

    private ClientRepository repository;

    private DrinkRepository drinkRepository;

    private final SendMessageService sendMessageService;

    private static final String START_MESSAGE_1 = "Привет!" +
            " Этот бот создан чтобы воплотить мечту почти каждого кофемана.";
    private static final String START_MESSAGE_2 = "Ниже ты можешь выбрать параметры любимого напитка, чтобы" +
            " в следующий раз по пути в любимую кофейню сделать заказ буквально одной кнопкой и заблаговременно";
    private static final String START_MESSAGE_3 = "А теперь давай узнаем твой любимый напиток. ";


    public StartCommand(SendMessageService sendMessageService, ClientRepository clientRepository, DrinkRepository drinkRepository) {
        this.sendMessageService = sendMessageService;
        this.repository = clientRepository;
        this.drinkRepository = drinkRepository;
    }

    public void execute(Update update) {
        registerUser(update);

        Optional<Drink> optional = drinkRepository.findById(2);
        Drink drink = optional.get();
        System.out.println(drink);
    }

    @SneakyThrows
    private void registerUser(Update update) {
        Long chatId = update.getMessage().getChatId();
        if (repository.findById(chatId).isEmpty()) {
            log.info("Новый пользователь: " + update.getMessage().getChat().getUserName() + "||"
                    + update.getMessage().getChat().getFirstName());
            sendMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE_1);
//            Thread.sleep(2000);
            sendMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE_2);
//            Thread.sleep(2000);
            sendMessageService.sendMessage(update.getMessage().getChatId().toString()
                    , START_MESSAGE_3);
            Client client = new Client();
            client.setId(chatId);
            client.setFirstName(update.getMessage().getChat().getFirstName());
            client.setSecondName(update.getMessage().getChat().getLastName());
            client.setUserName(update.getMessage().getChat().getUserName());
            client.setRegisterDay(new Timestamp(System.currentTimeMillis()));

            repository.save(client);
            new SetFavoriteDrinkCommand(sendMessageService, repository).execute(update);
        } else {
            Optional<Client> optional = repository.findById(chatId);
            Client client = optional.get();
            sendMessageService.sendMessage(update.getMessage().getChatId().toString(), "Ваш сохраненный любимый напиток:\n" +
            client.getInformOfDrink());
        }
    }
}
