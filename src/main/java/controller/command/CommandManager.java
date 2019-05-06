package controller.command;

import controller.command.implementation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Stanislau Palaukou on 25.04.2019
 * @project TravelAgency
 */

public class CommandManager {

    public enum CommandType {
        DEFAULT,

        SIGN_IN, SIGN_UP, SIGN_OUT,

        CHANGE_LOCALE,

        SHOW_TOURS,
        SHOW_ORDERS,

        BUY_TOUR,
        CANCEL_TOUR
    }

    private CommandManager() {
    }

    private static final Map<CommandType, Command> map;

    static {
        map = new HashMap<>();
        map.put(CommandType.DEFAULT, new EmptyCommand());
        map.put(CommandType.SIGN_IN, new SignInCommand());
        map.put(CommandType.SIGN_UP, new SignUpCommand());
        map.put(CommandType.SIGN_OUT, new SignOutCommand());
        map.put(CommandType.CHANGE_LOCALE, new ChangeLocaleCommand());
        map.put(CommandType.SHOW_TOURS, new ShowToursCommand());
        map.put(CommandType.SHOW_ORDERS, new ShowOrdersCommand());
        map.put(CommandType.BUY_TOUR, new BuyTourCommand());
        map.put(CommandType.CANCEL_TOUR, new CancelTourCommand());
    }

    public static Command getCommand(String cmd) {
        CommandType type;

        type = CommandType.valueOf(cmd.toUpperCase());

        return map.get(type);
    }
}
