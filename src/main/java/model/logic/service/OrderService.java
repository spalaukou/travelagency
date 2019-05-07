package model.logic.service;

import model.entity.Order;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.TourConnectionPoolException;

import java.util.List;

/**
 * @author Stanislau Palaukou on 06.05.2019
 * @project TravelAgency
 */

public interface OrderService {

    void createOrder(String userID, String tourID, int totalPrice, int balance) throws TourConnectionPoolException, DAOSQLException;

    void cancelOrder();

    List<Order> getOrdersByID(String userID);

}
