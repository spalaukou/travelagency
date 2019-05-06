package model.logic.service;

import model.entity.Order;

import java.util.List;

/**
 * @author Stanislau Palaukou on 06.05.2019
 * @project TravelAgency
 */

public interface OrderService {

    void createOrder(String login, String tourID);

    void cancelOrder();

    List<Order> getOrdersByLogin(String login);

}
