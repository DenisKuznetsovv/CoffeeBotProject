package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.model.ClientRepository;
import com.coffeOrderBot.CoffeBot.model.DrinkMenu;
import com.coffeOrderBot.CoffeBot.model.DrinkMenuRepository;
import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import com.coffeOrderBot.CoffeBot.settings.InlineKeyboardMarkupCollection;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static com.coffeOrderBot.CoffeBot.settings.enums.Emoji.*;

public class SelectFavoriteDrinkCommand implements Command {

    private final ClientRepository clientRepository;

    private final DrinkMenuRepository drinkMenuRepository;

    private final SendMessageService sendMessageService;

    public SelectFavoriteDrinkCommand(SendMessageService sendMessageService, ClientRepository repository,
                                      DrinkMenuRepository drinkMenuRepository) {
        this.sendMessageService = sendMessageService;
        this.clientRepository = repository;
        this.drinkMenuRepository = drinkMenuRepository;
    }

    @Override
    public void execute(Update update) {
        String message = COFFEE.getEmoji() + "Меню кофейни:";
        String chatId = String.valueOf(update.getMessage().getChatId());
//        List<DrinkMenu> list = drinkMenuRepository.findAllMenuType();
//
//        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
//        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
//        List<InlineKeyboardButton> row = new ArrayList<>();
//        InlineKeyboardButton button = new InlineKeyboardButton();
//
//        for (DrinkMenu drink : list){
//            System.out.println(drink.getMenuType());
//        }

        sendMessageService.sendMessageWithInlineKeyboardMarkup(chatId, message, InlineKeyboardMarkupCollection.setDrink());
    }
}
