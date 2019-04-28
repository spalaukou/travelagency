package model.logic.service;

import model.logic.service.implementation.ShowAllToursServiceImpl;
import model.logic.service.implementation.UserServiceImpl;

/**
 * @author Stanislau Palaukou on 27.04.2019
 * @project TravelAgency
 */

public class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    private final ShowAllToursService showAllToursService = new ShowAllToursServiceImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public UserService getUserService() {
        return userService;
    }

    public ShowAllToursService getShowAllToursService() {
        return showAllToursService;
    }
}
