package com.coffeeOrderBot.CoffeeBot.command.commands;

import com.coffeeOrderBot.CoffeeBot.model.DrinkMenuRepository;
import com.coffeeOrderBot.CoffeeBot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class EditStopList implements Command{

     private SendMessageService sendMessageService;

     private DrinkMenuRepository drinkRepository;

    @Override
    public void execute(Update update) {

    }
}
