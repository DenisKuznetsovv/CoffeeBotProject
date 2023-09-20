package com.coffeOrderBot.CoffeBot.command;

import com.coffeOrderBot.CoffeBot.command.commands.SetFavoriteDrinkCommand;
import com.coffeOrderBot.CoffeBot.command.commands.*;
import com.coffeOrderBot.CoffeBot.model.ClientRepository;
import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.coffeOrderBot.CoffeBot.settings.enums.CommandName.*;

@Component
public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;
    private final Command setComment;

    @Autowired
    public CommandContainer(SendMessageService sendMessageService, ClientRepository repository) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendMessageService, repository))
                .put(START_FOR_OWNER.getCommandName(), new StartForOwner(sendMessageService))
                .put(ORDER_FAVORITE_DRINK.getCommandName(), new OrderFavoriteDrinkCommand(sendMessageService, repository))
                .put(HELP.getCommandName(), new HelpCommand(sendMessageService))
                .put(FEEDBACK.getCommandName(), new FeedbackCommand(sendMessageService))
                .put(SET_FAVORITE_DRINK.getCommandName(), new SetFavoriteDrinkCommand(sendMessageService, repository))
                .build();

        unknownCommand = new UnknownCommand(sendMessageService);
        setComment = new SetComment(sendMessageService, repository);

    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }

//    public Command getSetComment(){
//        return setComment;
//    }


}
