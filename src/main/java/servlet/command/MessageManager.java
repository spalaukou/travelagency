package servlet.command;

import java.util.ResourceBundle;

/**
 * @author Stanislau Palaukou on 22.04.2019
 * @project TravelAgency
 */

public class MessageManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("messages.properties");
    // класс извлекает информацию из файла messages.properties
    private MessageManager() { }
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
