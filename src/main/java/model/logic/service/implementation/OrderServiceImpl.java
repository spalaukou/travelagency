package model.logic.service.implementation;

import model.entity.Order;
import model.logic.dal.dao.DAOFactory;
import model.logic.dal.dao.OrderDAO;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.TourConnectionPoolException;
import model.logic.service.OrderService;

import java.util.List;

/**
 * @author Stanislau Palaukou on 06.05.2019
 * @project TravelAgency
 */

public class OrderServiceImpl implements OrderService {
    private DAOFactory daoFactory = DAOFactory.getInstance();
    private OrderDAO orderDAO = daoFactory.getOrderDAO();

    @Override
    public void createOrder(String userID, String tourID, int totalPrice, int balance) throws TourConnectionPoolException, DAOSQLException {
        orderDAO.createOrder(userID, tourID, totalPrice, balance);
    }

    @Override
    public void cancelOrder() {
        orderDAO.cancelOrder();
    }

    @Override
    public List<Order> getOrdersByID(String userID) {
        List<Order> orders = null;

        try {
            orders = orderDAO.getOrdersByID(userID);
        } catch (DAOSQLException e) {
            //log
        }

        return orders;
    }
}
