package model.logic.service.implementation;

import model.entity.Order;
import model.logic.dal.dao.DAOFactory;
import model.logic.dal.dao.OrderDAO;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.DataSourceException;
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
    public float createOrder(String userID, String tourID, int totalPrice, int balance)
            throws DataSourceException, ServiceSQLException {
        float newDiscount;

        try {
            newDiscount = orderDAO.createOrder(userID, tourID, totalPrice, balance);
        } catch (TourConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return newDiscount;
    }

    @Override
    public float cancelOrder(String userID, String orderID, int totalPrice, int balance)
            throws DataSourceException, ServiceSQLException {
        float newDiscount;

        try {
            newDiscount = orderDAO.cancelOrder(userID, orderID, totalPrice, balance);
        } catch (TourConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return newDiscount;
    }

    @Override
    public List<Order> getOrdersByID(String userID) throws ServiceSQLException, DataSourceException {
        List<Order> orders = null;

        try {
            orders = orderDAO.getOrdersByID(userID);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        } catch (TourConnectionPoolException e) {
            throw new DataSourceException(e);
        }

        return orders;
    }
}
