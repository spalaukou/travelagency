package model.logic.dal.dao;

import model.entity.Order;

import java.util.List;

/**
 * @author Stanislau Palaukou on 07.05.2019
 * @project TravelAgency
 */

public interface OrderDAO {

    public void createOrder(String login, String tourID);

    public void cancelOrder();

    public List<Order> getOrdersByLogin(String login);
}
