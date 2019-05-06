package model.logic.dal.dao.implementation;

import model.entity.Order;
import model.logic.dal.dao.OrderDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stanislau Palaukou on 07.05.2019
 * @project TravelAgency
 */

public class OrderDAOImpl implements OrderDAO {

    @Override
    public void createOrder(String login, String tourID) {

    }

    @Override
    public void cancelOrder() {

    }

    @Override
    public List<Order> getOrdersByLogin(String login) {
        List<Order> orders = new ArrayList<>();

        return orders;
    }
}
