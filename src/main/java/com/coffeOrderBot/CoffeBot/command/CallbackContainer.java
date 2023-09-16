package com.coffeOrderBot.CoffeBot.command;

import com.coffeOrderBot.CoffeBot.command.commands.*;
import com.coffeOrderBot.CoffeBot.model.ClientRepository;
import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.coffeOrderBot.CoffeBot.command.enums.CommandName.*;
import static com.coffeOrderBot.CoffeBot.command.enums.DrinkButtons.*;
import static com.coffeOrderBot.CoffeBot.command.enums.VolumeButtons.*;

@Component
public class CallbackContainer {

    private final Command unknownCommand;
    private final ImmutableMap<String, Command> callbackMap;

    @Autowired
    public CallbackContainer(SendMessageService sendMessageService, ClientRepository repository) {
        callbackMap = ImmutableMap.<String, Command>builder()
                .put(SET_FAVORITE_DRINK.getCommandName(), new SetFavoriteDrinkCommand(sendMessageService, repository))
                .put(CAPPUCCINO.getCallbackData(), new SetDrink(sendMessageService, repository))
                .put(AMERICANO.getCallbackData(), new SetDrink(sendMessageService, repository))
                .put(LATTE.getCallbackData(), new SetDrink(sendMessageService, repository))
                .put(ESPRESSO.getCallbackData(), new SetDrink(sendMessageService, repository))
                .put(RAF_COFFEE.getCallbackData(), new SetDrink(sendMessageService, repository))
                .put(TEA.getCallbackData(), new SetDrink(sendMessageService, repository))
                .put(AUTHOR_DRINKS.getCallbackData(), new SetDrink(sendMessageService, repository))
                .put(L_020.getCallback(), new SetVolume(sendMessageService, repository))
                .put(L_025.getCallback(), new SetVolume(sendMessageService, repository))
                .put(L_030.getCallback(), new SetVolume(sendMessageService, repository))
                .put(L_035.getCallback(), new SetVolume(sendMessageService, repository))
                .put(L_040.getCallback(), new SetVolume(sendMessageService, repository))
                .build();

        unknownCommand = new UnknownCommand(sendMessageService);
    }

    public Command retrieveCallback(String callback){
        return callbackMap.getOrDefault(callback, unknownCommand);
    }
}
