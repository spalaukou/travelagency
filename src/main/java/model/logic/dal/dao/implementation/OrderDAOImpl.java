package model.logic.dal.dao.implementation;

import model.ConstantContainer;
import model.entity.*;
import model.entity.builder.BuilderFactory;
import model.entity.builder.EntityBuilder;
import model.logic.dal.dao.OrderDAO;
import model.logic.dal.db_connection.DBConstantContainer;
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
 * Implementation of Order DAO.
 *
 * @author Stanislau Palaukou on 07.05.2019
 * @project TravelAgency
 */

public class OrderDAOImpl implements OrderDAO {

    /**
     * Executes DataBase query and creates a new Order by requested parameters.
     * Calls methods to set new User balance and discount.
     *
     * @param userID
     * @param tourID
     * @param totalPrice
     * @param balance
     * @return new User discount.
     * @throws TourConnectionPoolException
     * @throws DAOSQLException
     */
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

                userService.setBalance(connection, userID, balance - totalPrice);
                newDiscount = userService.setDiscount(connection, userID);

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

    /**
     * Executes DataBase query and cancels the Order by Order ID.
     * Calls methods to set new User balance and discount.
     *
     * @param userID
     * @param orderID
     * @param totalPrice
     * @param balance
     * @return new User discount.
     * @throws TourConnectionPoolException
     * @throws DAOSQLException
     */
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

                userService.setBalance(connection, userID, balance + totalPrice);

                statement.executeUpdate();

                newDiscount = userService.setDiscount(connection, userID);

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

    /**
     * Executes DataBase query and gets Order ID by requested Order ID.
     *
     * @param orderID
     * @return a good Order ID if it exists, or wrong Order ID if not.
     * @throws TourConnectionPoolException
     * @throws DAOSQLException
     */
    @Override
    public int getID(String orderID) throws TourConnectionPoolException, DAOSQLException {
        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection = tourConnectionPool.getConnection();
        int ID = ConstantContainer.WRONG_ID;

        if (connection != null) {
            try (PreparedStatement statement =
                         connection.prepareStatement(DBRequestContainer.GET_ORDER_ID_REQUEST)) {

                statement.setString(1, orderID);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    ID = resultSet.getInt(DBConstantContainer.ORDER_ID_ORDER);
                }

            } catch (SQLException e) {
                throw new DAOSQLException(e);
            } finally {
                tourConnectionPool.returnConnection(connection);
            }
        }
        return ID;
    }

    /**
     * Executes DataBase query and gets Orders by requested User ID.
     *
     * @param userID
     * @return List of Orders
     * @throws DAOSQLException
     * @throws TourConnectionPoolException
     */
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

    /**
     * Creates a list of Orders by calling the Order Builder.
     *
     * @param resultSet
     * @return List of Orders
     * @throws SQLException
     */
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
