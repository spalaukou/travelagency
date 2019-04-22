package servlet.command;

import java.util.ResourceBundle;

/**
 * @author Stanislau Palaukou on 22.04.2019
 * @project TravelAgency
 */

public class ConfigurationManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config.properties");
    // класс извлекает информацию из файла config.properties
    private ConfigurationManager() { }
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}