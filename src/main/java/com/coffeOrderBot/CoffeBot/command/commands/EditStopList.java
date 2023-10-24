package com.coffeOrderBot.CoffeBot.command.commands;

import com.coffeOrderBot.CoffeBot.model.DrinkMenuRepository;
import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class EditStopList implements Command{

     private SendMessageService sendMessageService;

     private DrinkMenuRepository drinkRepository;

    @Override
    public void execute(Update update) {

    }
}
