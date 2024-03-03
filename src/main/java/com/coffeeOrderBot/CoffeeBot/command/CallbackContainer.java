package com.coffeeOrderBot.CoffeeBot.command;

import com.coffeeOrderBot.CoffeeBot.command.commands.Command;
import com.coffeeOrderBot.CoffeeBot.command.commands.SetDrinkCommand;
import com.coffeeOrderBot.CoffeeBot.command.commands.SetVolumeCommand;
import com.coffeeOrderBot.CoffeeBot.command.commands.UnknownCommand;
import com.coffeeOrderBot.CoffeeBot.model.ClientRepository;
import com.coffeeOrderBot.CoffeeBot.model.DrinkMenuRepository;
import com.coffeeOrderBot.CoffeeBot.service.SendMessageService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.coffeeOrderBot.CoffeeBot.settings.enums.DrinkButtons.*;
import static com.coffeeOrderBot.CoffeeBot.settings.enums.VolumeButtons.*;

@Component
public class CallbackContainer {

    private final Command unknownCommand;
    private final ImmutableMap<String, Command> callbackMap;

    @Autowired
    public CallbackContainer(SendMessageService sendMessageService, ClientRepository clientRepository, DrinkMenuRepository drinkMenuRepository) {
        callbackMap = ImmutableMap.<String, Command>builder()
                .put(CAPPUCCINO.getCallbackData(), new SetDrinkCommand(sendMessageService, clientRepository, drinkMenuRepository))
                .put(AMERICANO.getCallbackData(), new SetDrinkCommand(sendMessageService, clientRepository, drinkMenuRepository))
                .put(LATTE.getCallbackData(), new SetDrinkCommand(sendMessageService, clientRepository, drinkMenuRepository))
                .put(ESPRESSO.getCallbackData(), new SetDrinkCommand(sendMessageService, clientRepository, drinkMenuRepository))
                .put(RAF_COFFEE.getCallbackData(), new SetDrinkCommand(sendMessageService, clientRepository, drinkMenuRepository))
                .put(TEA.getCallbackData(), new SetDrinkCommand(sendMessageService, clientRepository, drinkMenuRepository))
                .put(AUTHOR_DRINKS.getCallbackData(), new SetDrinkCommand(sendMessageService, clientRepository, drinkMenuRepository))
                .put(L_020.getCallback(), new SetVolumeCommand(sendMessageService, clientRepository))
                .put(L_025.getCallback(), new SetVolumeCommand(sendMessageService, clientRepository))
                .put(L_030.getCallback(), new SetVolumeCommand(sendMessageService, clientRepository))
                .put(L_035.getCallback(), new SetVolumeCommand(sendMessageService, clientRepository))
                .put(L_040.getCallback(), new SetVolumeCommand(sendMessageService, clientRepository))
                .build();

        unknownCommand = new UnknownCommand(sendMessageService);
    }

    public Command retrieveCallback(String callback){
        return callbackMap.getOrDefault(callback, unknownCommand);
    }
}
