package com.coffeOrderBot.CoffeBot.command;

import com.coffeOrderBot.CoffeBot.command.commands.*;
import com.coffeOrderBot.CoffeBot.model.ClientRepository;
import com.coffeOrderBot.CoffeBot.model.DrinkMenuRepository;
import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.coffeOrderBot.CoffeBot.settings.enums.DrinkButtons.*;
import static com.coffeOrderBot.CoffeBot.settings.enums.VolumeButtons.*;

@Component
public class CallbackContainer {

    private final Command unknownCommand;
    private final ImmutableMap<String, Command> callbackMap;

    @Autowired
    public CallbackContainer(SendMessageService sendMessageService, ClientRepository repository, DrinkMenuRepository drinkMenuRepository) {
        callbackMap = ImmutableMap.<String, Command>builder()
//                .put(SET_FAVORITE_DRINK.getCommandName(), new SetFavoriteDrinkCommand(sendMessageService, repository))
                .put(CAPPUCCINO.getCallbackData(), new SetDrinkCommand(sendMessageService, repository, drinkMenuRepository))
                .put(AMERICANO.getCallbackData(), new SetDrinkCommand(sendMessageService, repository, drinkMenuRepository))
                .put(LATTE.getCallbackData(), new SetDrinkCommand(sendMessageService, repository, drinkMenuRepository))
                .put(ESPRESSO.getCallbackData(), new SetDrinkCommand(sendMessageService, repository, drinkMenuRepository))
                .put(RAF_COFFEE.getCallbackData(), new SetDrinkCommand(sendMessageService, repository, drinkMenuRepository))
                .put(TEA.getCallbackData(), new SetDrinkCommand(sendMessageService, repository, drinkMenuRepository))
                .put(AUTHOR_DRINKS.getCallbackData(), new SetDrinkCommand(sendMessageService, repository, drinkMenuRepository))
//                .put(L_020.getCallback(), new SetVolumeCommand(sendMessageService, repository))
//                .put(L_025.getCallback(), new SetVolumeCommand(sendMessageService, repository))
//                .put(L_030.getCallback(), new SetVolumeCommand(sendMessageService, repository))
//                .put(L_035.getCallback(), new SetVolumeCommand(sendMessageService, repository))
//                .put(L_040.getCallback(), new SetVolumeCommand(sendMessageService, repository))
                .build();

        unknownCommand = new UnknownCommand(sendMessageService);
    }

    public Command retrieveCallback(String callback){
        return callbackMap.getOrDefault(callback, unknownCommand);
    }
}
