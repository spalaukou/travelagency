package model.logic.service;

import model.logic.service.implementation.OrderServiceImpl;
import model.logic.service.implementation.TourServiceImpl;
import model.logic.service.implementation.UserServiceImpl;

/**
 * The Factory, that provides entity services.
 *
 * @author Stanislau Palaukou on 27.04.2019
 * @project TravelAgency
 */

public class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    private final TourService tourService = new TourServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public UserService getUserService() {
        return userService;
    }

    public TourService getTourService() {
        return tourService;
    }

    public OrderService getOrderService() {
        return orderService;
    }
}
