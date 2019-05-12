package controller.command;

import controller.command.implementation.*;
import model.ConstantContainer;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Class contains command types, command container and
 * method that returns the required command.
 *
 * @author Stanislau Palaukou on 25.04.2019
 * @project TravelAgency
 */

public class CommandManager {

    private static final Logger LOGGER = Logger.getLogger(CommandManager.class);

    /**
     * Enumeration of exists Command types.
     */
    public enum CommandType {
        DEFAULT,

        SIGN_IN, SIGN_UP, SIGN_OUT,

        CHANGE_LOCALE,

        SHOW_TOURS,
        SHOW_ORDERS,

        BUY_TOUR,
        CANCEL_TOUR,

        ADD_TOUR,
        UPDATE_TOUR
    }

    private CommandManager() {
    }

    /**
     * Command Container. Commands are created in advance in static block.
     */
    private static final Map<CommandType, Command> commandContainer;

    static {
        commandContainer = new HashMap<>();
        commandContainer.put(CommandType.DEFAULT, new EmptyCommand());
        commandContainer.put(CommandType.SIGN_IN, new SignInCommand());
        commandContainer.put(CommandType.SIGN_UP, new SignUpCommand());
        commandContainer.put(CommandType.SIGN_OUT, new SignOutCommand());
        commandContainer.put(CommandType.CHANGE_LOCALE, new ChangeLocaleCommand());
        commandContainer.put(CommandType.SHOW_TOURS, new ShowToursCommand());
        commandContainer.put(CommandType.SHOW_ORDERS, new ShowOrdersCommand());
        commandContainer.put(CommandType.BUY_TOUR, new BuyTourCommand());
        commandContainer.put(CommandType.CANCEL_TOUR, new CancelTourCommand());
        commandContainer.put(CommandType.ADD_TOUR, new AddTourCommand());
        commandContainer.put(CommandType.UPDATE_TOUR, new UpdateTourCommand());
    }

    /**
     * Getter for the Command which should be called.
     *
     * @param cmd
     * @return Command that is called. If the requested command
     * does not exists, the default command is returned.
     */
    public static Command getCommand(String cmd) {
        CommandType type;

        try {

            type = CommandType.valueOf(cmd.toUpperCase());

        } catch (IllegalArgumentException e) {
            LOGGER.error(ConstantContainer.COMMAND_ERR_MSG, e);
            type = CommandType.DEFAULT;
        }

        return commandContainer.get(type);
    }
}
