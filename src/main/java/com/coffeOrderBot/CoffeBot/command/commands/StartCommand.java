package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.model.Client;
import com.coffeOrderBot.CoffeBot.model.ClientRepository;
import com.coffeOrderBot.CoffeBot.model.DrinkMenuRepository;
import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.meta.api.objects.Update;
import static com.coffeOrderBot.CoffeBot.settings.enums.Emoji.*;

import java.sql.Timestamp;
import java.util.Optional;

@Log4j2
public class StartCommand implements Command {

    private ClientRepository clientRepository;

    private DrinkMenuRepository drinkRepository;

    private final SendMessageService sendMessageService;

    private static final String START_MESSAGE_1 = "Привет!" +
            " Этот бот создан чтобы воплотить мечту почти каждого кофемана.";
    private static final String START_MESSAGE_2 = "Ниже ты можешь выбрать параметры любимого напитка, чтобы" +
            " в следующий раз по пути в любимую кофейню сделать заказ буквально одной кнопкой и заблаговременно";
    private static final String START_MESSAGE_3 = "А теперь давай узнаем твой любимый напиток. ";


    public StartCommand(SendMessageService sendMessageService, ClientRepository clientRepository, DrinkMenuRepository drinkRepository) {
        this.sendMessageService = sendMessageService;
        this.clientRepository = clientRepository;
        this.drinkRepository = drinkRepository;
    }

    public void execute(Update update) {
        registerUser(update);
    }

    @SneakyThrows
    private void registerUser(Update update) {
        Long chatId = update.getMessage().getChatId();
        if (!clientRepository.existsById(chatId)) {
            log.info("Новый пользователь: " + update.getMessage().getChat().getUserName() + "||"
                    + update.getMessage().getChat().getFirstName());
            sendMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE_1);
//            Thread.sleep(2000);
            sendMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE_2);
//            Thread.sleep(2000);
            sendMessageService.sendMessage(update.getMessage().getChatId().toString()
                    , START_MESSAGE_3);
            Client client = new Client();
            client.setClient_id(chatId);
            client.setFirstName(update.getMessage().getChat().getFirstName());
            client.setSecondName(update.getMessage().getChat().getLastName());
            client.setUserName(update.getMessage().getChat().getUserName());
            client.setRegisterDay(new Timestamp(System.currentTimeMillis()));

            clientRepository.save(client);
            new SelectFavoriteDrinkCommand(sendMessageService, clientRepository, drinkRepository).execute(update);
        } else {
            Optional<Client> optional = clientRepository.findById(chatId);
            Client client = optional.get();
            sendMessageService.sendMessage(update.getMessage().getChatId().toString(), "Кажется мы уже знакомы. " +
                    "Ваш любимый напиток:\n" +
            COFFEE + " " + client.getInformOfDrink());
        }
    }
}
