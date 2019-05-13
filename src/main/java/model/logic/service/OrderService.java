package model.logic.service;

import model.entity.Order;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.logical.DataSourceException;

import java.util.List;

/**
 * Interface for Order service implementation.
 *
 * @author Stanislau Palaukou on 06.05.2019
 * @project TravelAgency
 */

public interface OrderService {

    float createOrder(String userID, String tourID, int totalPrice, int balance)
            throws DataSourceException, ServiceSQLException;

    float cancelOrder(String userID, String orderID, int totalPrice, int balance)
            throws DataSourceException, ServiceSQLException;

    List<Order> getOrdersByID(String userID) throws ServiceSQLException, DataSourceException;

    int getID(String orderID) throws DataSourceException, ServiceSQLException;
}
