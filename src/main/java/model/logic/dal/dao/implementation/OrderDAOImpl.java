package model.logic.dal.dao.implementation;

import model.ConstantContainer;
import model.entity.*;
import model.entity.builder.BuilderFactory;
import model.entity.builder.EntityBuilder;
import model.logic.dal.dao.OrderDAO;
import model.logic.dal.db_connection.DBRequestContainer;
import model.logic.dal.db_connection.connection_pool.TourConnectionPool;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.logical.DataSourceException;
import model.logic.exception.technical.TourConnectionPoolException;
import model.logic.service.ServiceFactory;
import model.logic.service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Stanislau Palaukou on 07.05.2019
 * @project TravelAgency
 */

public class OrderDAOImpl implements OrderDAO {

    @Override
    public float createOrder(String userID, String tourID, int totalPrice, int balance)
            throws TourConnectionPoolException, DAOSQLException {

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection = tourConnectionPool.getConnection();
        float newDiscount = ConstantContainer.WRONG_DISCOUNT;

        if (connection != null) {
            try (PreparedStatement statement =
                         connection.prepareStatement(DBRequestContainer.CREATE_ORDER_REQUEST)) {

                statement.setString(1, userID);
                statement.setString(2, tourID);
                statement.setString(3, String.valueOf(totalPrice));

                statement.executeUpdate();

                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                UserService userService = serviceFactory.getUserService();

                userService.setBalance(userID, balance - totalPrice);
                newDiscount = userService.setDiscount(userID);

            } catch (SQLException | ServiceSQLException e) {
                throw new DAOSQLException(e);
            } catch (DataSourceException e) {
                throw new TourConnectionPoolException(e);
            } finally {
                tourConnectionPool.returnConnection(connection);
            }
        }
        return newDiscount;
    }

    @Override
    public float cancelOrder(String userID, String orderID, int totalPrice, int balance)
            throws TourConnectionPoolException, DAOSQLException {

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection = tourConnectionPool.getConnection();
        float newDiscount = ConstantContainer.WRONG_DISCOUNT;

        if (connection != null) {
            try (PreparedStatement statement =
                         connection.prepareStatement(DBRequestContainer.CANCEL_ORDER_REQUEST)) {

                statement.setString(1, orderID);

                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                UserService userService = serviceFactory.getUserService();

                userService.setBalance(userID, balance + totalPrice);
                newDiscount = userService.setDiscount(userID);

                statement.executeUpdate();

            } catch (SQLException | ServiceSQLException e) {
                throw new DAOSQLException(e);
            } catch (DataSourceException e) {
                throw new TourConnectionPoolException(e);
            } finally {
                tourConnectionPool.returnConnection(connection);
            }
        }
        return newDiscount;
    }

    @Override
    public List<Order> getOrdersByID(String userID) throws DAOSQLException, TourConnectionPoolException {
        List<Order> orders;

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();

            Connection connection = tourConnectionPool.getConnection();

            try (PreparedStatement statement =
                         connection.prepareStatement(DBRequestContainer.GET_ORDERS_BY_ID_REQUEST)) {

                statement.setString(1, userID);
                ResultSet resultSet = statement.executeQuery();

                orders = createOrderList(resultSet);

            } catch (SQLException e) {
                throw new DAOSQLException(e);
            } finally {
                tourConnectionPool.returnConnection(connection);
            }

        return orders;
    }

    private List<Order> createOrderList(ResultSet resultSet) throws SQLException {
        List<Order> orders = new ArrayList<>();
        BuilderFactory builderFactory = BuilderFactory.getInstance();
        EntityBuilder<Order> orderBuilder = builderFactory.getOrderBuilder();

        while (resultSet.next()) {
            Order order = orderBuilder.build(resultSet);

            orders.add(order);
        }
        return orders;
    }
}
