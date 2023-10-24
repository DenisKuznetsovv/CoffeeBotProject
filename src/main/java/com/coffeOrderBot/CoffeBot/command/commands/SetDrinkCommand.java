package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.model.Client;
import com.coffeOrderBot.CoffeBot.model.ClientRepository;
import com.coffeOrderBot.CoffeBot.model.DrinkMenu;
import com.coffeOrderBot.CoffeBot.model.DrinkMenuRepository;
import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.*;

@Log4j2
public class SetDrinkCommand implements Command {

    private ClientRepository clientRepository;

    private DrinkMenuRepository drinkMenuRepository;

    private final SendMessageService sendMessageService;

    public SetDrinkCommand(SendMessageService sendMessageService, ClientRepository repository, DrinkMenuRepository drinkMenuRepository) {
        this.clientRepository = repository;
        this.sendMessageService = sendMessageService;
        this.drinkMenuRepository = drinkMenuRepository;
    }

    @Override
    public void execute(Update update) {
        Long chatID = update.getCallbackQuery().getMessage().getChatId();

        Optional<Client> clientOptional = clientRepository.findById(chatID);
        Client clientForRepo = null;
        try {
            clientForRepo = clientOptional.get();
            clientForRepo.setFavorite_drink(update.getCallbackQuery().getData());
            clientRepository.save(clientForRepo);
        } catch (NullPointerException | NoSuchElementException e) {
            log.warn("Exception: " + e.getMessage() + " ||\n From: " + Arrays.toString(e.getStackTrace()));
        }

        assert clientForRepo != null;
        sendMessageService.sendMessageWithInlineKeyboardMarkup(String.valueOf(chatID),
                "Выберите объем:", getVolumeList(clientForRepo.getFavorite_drink()));
    }

    private InlineKeyboardMarkup getVolumeList(String drinkName) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInlineKeyboard = new ArrayList<>();
        List<InlineKeyboardButton> row;
        InlineKeyboardButton button;

        List<DrinkMenu> drinkMenuList = drinkMenuRepository.findByName(drinkName);

        for (DrinkMenu drink : drinkMenuList) {
            row = new ArrayList<>();
            button = new InlineKeyboardButton();
            button.setText(drink.getVolume());
            button.setCallbackData(drink.getVolume());
            row.add(button);
            rowsInlineKeyboard.add(row);


        }
        inlineKeyboardMarkup.setKeyboard(rowsInlineKeyboard);
        return inlineKeyboardMarkup;
    }
}
