package com.coffeOrderBot.CoffeBot.command;

import com.coffeOrderBot.CoffeBot.command.commands.SetFavoriteDrinkCommand;
import com.coffeOrderBot.CoffeBot.command.commands.*;
import com.coffeOrderBot.CoffeBot.model.ClientRepository;
import com.coffeOrderBot.CoffeBot.service.SendMessageService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.coffeOrderBot.CoffeBot.command.enums.CommandName.*;

@Component
public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    @Autowired
    public CommandContainer(SendMessageService sendMessageService, ClientRepository repository) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendMessageService, repository))
                .put(ORDER_FAVORITE_DRINK.getCommandName(), new OrderFavoriteDrink(sendMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendMessageService))
                .put(FEEDBACK.getCommandName(), new FeedbackCommand(sendMessageService))
                .put(SHOW_BARISTA.getCommandName(), new ShowBaristaCommand(sendMessageService))
                .put(SET_FAVORITE_DRINK.getCommandName(), new SetFavoriteDrinkCommand(sendMessageService))
                .build();

        unknownCommand = new UnknownCommand(sendMessageService);
    }

    public Command retrieveCommand(String commandIdentifier){
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }


}
