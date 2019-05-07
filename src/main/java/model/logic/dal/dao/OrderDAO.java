package model.logic.dal.dao;

import model.entity.Order;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.TourConnectionPoolException;

import java.util.List;

/**
 * @author Stanislau Palaukou on 07.05.2019
 * @project TravelAgency
 */

public interface OrderDAO {

    public void createOrder(String userID, String tourID, int totalPrice, int balance) throws TourConnectionPoolException, DAOSQLException;

    public void cancelOrder();

    public List<Order> getOrdersByID(String userID) throws DAOSQLException;
}
