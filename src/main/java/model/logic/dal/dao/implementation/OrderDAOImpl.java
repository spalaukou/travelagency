package model.logic.dal.dao.implementation;

import model.ConstantContainer;
import model.entity.*;
import model.logic.dal.dao.DAOFactory;
import model.logic.dal.dao.OrderDAO;
import model.logic.dal.dao.UserDAO;
import model.logic.dal.db_connection.DBConstantContainer;
import model.logic.dal.db_connection.DBRequestContainer;
import model.logic.dal.db_connection.connection_pool.TourConnectionPool;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.TourConnectionPoolException;

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
    public float createOrder(String userID, String tourID, int totalPrice, int balance) throws TourConnectionPoolException, DAOSQLException {
        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection = tourConnectionPool.getConnection();
        UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
        float newDiscount = ConstantContainer.WRONG_DISCOUNT;

        if (connection != null) {
            try (PreparedStatement statement =
                         connection.prepareStatement(DBRequestContainer.CREATE_ORDER_REQUEST)) {

                statement.setString(1, userID);
                statement.setString(2, tourID);
                statement.setString(3, String.valueOf(totalPrice));

                statement.executeUpdate();

                userDAO.setBalance(userID, balance - totalPrice);
                newDiscount = userDAO.setDiscount(userID);

            } catch (SQLException e) {
                throw new DAOSQLException(e);
            } finally {
                tourConnectionPool.returnConnection(connection);
            }
        }
        return newDiscount;
    }

    @Override
    public float cancelOrder(String userID, String orderID, int totalPrice, int balance) throws TourConnectionPoolException, DAOSQLException {
        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection = tourConnectionPool.getConnection();
        UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
        float newDiscount = ConstantContainer.WRONG_DISCOUNT;

        if (connection != null) {
            try (PreparedStatement statement =
                         connection.prepareStatement(DBRequestContainer.CANCEL_ORDER_REQUEST)) {

                statement.setString(1, orderID);

                userDAO.setBalance(userID, balance + totalPrice);
                newDiscount = userDAO.setDiscount(userID);

                statement.executeUpdate();

            } catch (SQLException e) {
                throw new DAOSQLException(e);
            } finally {
                tourConnectionPool.returnConnection(connection);
            }
        }
        return newDiscount;
    }

    @Override
    public List<Order> getOrdersByID(String userID) throws DAOSQLException {
        List<Order> orders;

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();

        try {
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
        } catch (TourConnectionPoolException e) {
            throw new DAOSQLException(e);
        }

        return orders;
    }

    private List<Order> createOrderList(ResultSet resultSet) throws SQLException {
        List<Order> orders = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setId(resultSet.getInt(DBConstantContainer.ORDER_ID_ORDER));

            //user
            User user = new User();
            user.setId(resultSet.getInt(DBConstantContainer.ID_USER));
            user.setLogin(resultSet.getString(DBConstantContainer.USER_LOGIN));
            user.setDiscount(resultSet.getFloat(DBConstantContainer.USER_DISCOUNT));
            order.setUser(user);

            Tour tour = new Tour();
            tour.setId(resultSet.getInt(DBConstantContainer.TOUR_ID_TOUR));
            tour.setName(resultSet.getString(DBConstantContainer.TOUR_NAME));

            Hotel hotel = new Hotel();
            hotel.setId(resultSet.getInt(DBConstantContainer.HOTEL_ID_HOTEL));
            hotel.setName(resultSet.getString(DBConstantContainer.HOTEL_NAME));
            hotel.setCountry(resultSet.getString(DBConstantContainer.HOTEL_COUNTRY));
            hotel.setCity(resultSet.getString(DBConstantContainer.HOTEL_CITY));
            hotel.setStar(resultSet.getInt(DBConstantContainer.HOTEL_STAR));
            hotel.setMeal(resultSet.getString(DBConstantContainer.HOTEL_MEAL));
            hotel.setPerson(resultSet.getInt(DBConstantContainer.HOTEL_PERSON));
            tour.setHotel(hotel);

            tour.setNight(resultSet.getInt(DBConstantContainer.TOUR_NIGHT));

            Transport transport = new Transport();
            transport.setId(resultSet.getInt(DBConstantContainer.TRANSPORT_ID_TRANSPORT));
            transport.setType(resultSet.getString(DBConstantContainer.TRANSPORT_TYPE));
            tour.setTransport(transport);

            tour.setCost(resultSet.getInt(DBConstantContainer.TOUR_COST));
            tour.setHot(resultSet.getFloat(DBConstantContainer.TOUR_HOT));
//            tour.setTotalPrice((int) (tour.getCost() * tour.getHot() * user.getDiscount()));
            order.setTour(tour);

            order.setTotalPrice(resultSet.getInt(DBConstantContainer.ORDER_TOTAL_PRICE));

            orders.add(order);
        }
        return orders;
    }


}
