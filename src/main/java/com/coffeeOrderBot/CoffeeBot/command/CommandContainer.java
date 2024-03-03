package com.coffeeOrderBot.CoffeeBot.command;

import com.coffeeOrderBot.CoffeeBot.command.commands.*;
import com.coffeeOrderBot.CoffeeBot.model.ClientRepository;
import com.coffeeOrderBot.CoffeeBot.model.DrinkMenuRepository;
import com.coffeeOrderBot.CoffeeBot.service.SendMessageService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.coffeeOrderBot.CoffeeBot.settings.enums.CommandName.*;

@Component
public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;
    private final Command setComment;

    @Autowired
    public CommandContainer(SendMessageService sendMessageService, ClientRepository clientRepository, DrinkMenuRepository drinkRepository) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendMessageService, clientRepository, drinkRepository))
                .put(START_FOR_OWNER.getCommandName(), new SetChatIdForOwnerCommand(sendMessageService))
                .put(ORDER_FAVORITE_DRINK.getCommandName(), new OrderFavoriteDrinkCommand(sendMessageService, clientRepository, drinkRepository))
                .put(HELP.getCommandName(), new HelpCommand(sendMessageService))
                .put(FEEDBACK.getCommandName(), new FeedbackCommand(sendMessageService))
                .put(SET_FAVORITE_DRINK.getCommandName(), new SelectFavoriteDrinkCommand(sendMessageService, clientRepository, drinkRepository))
                .put(SEND_ORDER_TO_CHAT.getCommandName(), new SendOrderToChatCommand(sendMessageService))
                .build();

        unknownCommand = new UnknownCommand(sendMessageService);
        setComment = new SetCommentCommand(sendMessageService, clientRepository);

    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }

    public Command getSetComment() {
        return setComment;
    }
}
