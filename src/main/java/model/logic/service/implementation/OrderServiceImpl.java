package model.logic.service.implementation;

import model.entity.Order;
import model.logic.dal.dao.DAOFactory;
import model.logic.dal.dao.OrderDAO;
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
    public void createOrder(String login, String tourID) {
        orderDAO.createOrder(login, tourID);

    }

    @Override
    public void cancelOrder() {

    }

    @Override
    public List<Order> getOrdersByLogin(String login) {
        List<Order> orders = null;

        orderDAO.getOrdersByLogin(login);

        return orders;
    }
}
