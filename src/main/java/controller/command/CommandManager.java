package controller.command;

import controller.command.implementation.EmptyCommand;
import controller.command.implementation.SignUpCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Stanislau Palaukou on 25.04.2019
 * @project TravelAgency
 */

public class CommandManager {

    public enum CommandType {
        DEFAULT, SIGN_UP, ALL_TOURS;
    }

    private static final Map<CommandType, Command> map;

    static {
        map = new HashMap<>();
        map.put(CommandType.DEFAULT, new EmptyCommand());
        map.put(CommandType.SIGN_UP, new SignUpCommand());
    }

    public static Command getCommand(String cmd) {
        CommandType type;

        type = CommandType.valueOf(cmd.toUpperCase());

        return map.get(type);
    }
}
