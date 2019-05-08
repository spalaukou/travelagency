package model.logic.dal.dao.implementation;

import model.entity.User;
import model.logic.dal.dao.UserDAO;
import model.logic.dal.db_connection.DBConstantContainer;
import model.logic.dal.db_connection.DBRequestContainer;
import model.logic.dal.db_connection.connection_pool.TourConnectionPool;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.TourConnectionPoolException;

import java.sql.*;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public class UserDAOImpl implements UserDAO {

    @Override
    public void signUp(String login, String password) throws DAOSQLException, TourConnectionPoolException {

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection = tourConnectionPool.getConnection();

        if (connection != null) {
            try (PreparedStatement statement =
                         connection.prepareStatement(DBRequestContainer.USER_SIGN_UP_REQUEST)) {

                statement.setString(1, login);
                statement.setString(2, password);
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new DAOSQLException(e);
            } finally {
                tourConnectionPool.returnConnection(connection);
            }
        }
    }

    @Override
    public User signIn(String login, String password) throws TourConnectionPoolException, DAOSQLException {
        User user = null;

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection = tourConnectionPool.getConnection();

        if(connection != null) {
            try (PreparedStatement statement =
                         connection.prepareStatement(DBRequestContainer.GET_USER_REQUEST)) {

                statement.setString(1, login);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt(DBConstantContainer.ID_USER));
                    user.setType(User.Type.valueOf(resultSet.getString(DBConstantContainer.USER_TYPE).toUpperCase()));
                    user.setLogin(resultSet.getString(DBConstantContainer.USER_LOGIN));
                    user.setPassword(resultSet.getString(DBConstantContainer.USER_PASSWORD));
                    user.setBalance(resultSet.getInt(DBConstantContainer.USER_BALANCE));
                    user.setDiscount(resultSet.getFloat(DBConstantContainer.USER_DISCOUNT));
                }

            } catch (SQLException e) {
                throw new DAOSQLException(e);
            } finally {
                tourConnectionPool.returnConnection(connection);
            }
        }
        return user;
    }

    @Override
    public void setBalance(String userID, int balance) {
        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection;
        try {
            connection = tourConnectionPool.getConnection();
            if(connection != null) {
                try (PreparedStatement preparedStatement =
                             connection.prepareStatement(DBRequestContainer.SET_BALANCE_REQUEST)) {

                    preparedStatement.setInt(1, balance);
                    preparedStatement.setString(2, userID);

                    preparedStatement.executeUpdate();

                } catch (SQLException e) {
                    throw new DAOSQLException(e);
                } finally {
                    tourConnectionPool.returnConnection(connection);
                }
            }
        } catch (TourConnectionPoolException | DAOSQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public float setDiscount(String userID) {
        int allOrdersCost = getAllOrdersCost(userID);
        float userDiscount = getUserDiscount(userID);
        float newDiscount;

        if (allOrdersCost < DBConstantContainer.LEVEL1_DISCOUNT_BORDER) {
            newDiscount = DBConstantContainer.DEFAULT_DISCOUNT;
        } else if (allOrdersCost < DBConstantContainer.LEVEL2_DISCOUNT_BORDER) {
            newDiscount = DBConstantContainer.LEVEL1_DISCOUNT;
        } else if (allOrdersCost < DBConstantContainer.LEVEL3_DISCOUNT_BORDER) {
            newDiscount = DBConstantContainer.LEVEL2_DISCOUNT;
        } else {
            newDiscount = DBConstantContainer.LEVEL3_DISCOUNT;
        }

        if(userDiscount != newDiscount) {
            insertNewDiscount(userID, newDiscount);
        }

        return newDiscount;
    }

    private void insertNewDiscount(String userID, float newDiscount) {
        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection;
        try {
            connection = tourConnectionPool.getConnection();
            if(connection != null) {
                try (PreparedStatement preparedStatement =
                             connection.prepareStatement(DBRequestContainer.SET_DISCOUNT_REQUEST)) {

                    preparedStatement.setFloat(1, newDiscount);
                    preparedStatement.setString(2, userID);

                    preparedStatement.executeUpdate();

                } catch (SQLException e) {
                    throw new DAOSQLException(e);
                } finally {
                    tourConnectionPool.returnConnection(connection);
                }
            }
        } catch (TourConnectionPoolException | DAOSQLException e) {
            //log
        }
    }

    private int getAllOrdersCost(String userID) {
        int allOrdersCost = 0;

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection;
        try {
            connection = tourConnectionPool.getConnection();
            if(connection != null) {
                try (PreparedStatement preparedStatement =
                             connection.prepareStatement(DBRequestContainer.GET_ALL_ORDERS_COST)) {

                    preparedStatement.setString(1, userID);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {
                        allOrdersCost += resultSet.getInt(DBConstantContainer.ORDER_TOTAL_PRICE);
                    }

                } catch (SQLException e) {
                    throw new DAOSQLException(e);
                } finally {
                    tourConnectionPool.returnConnection(connection);
                }
            }
        } catch (TourConnectionPoolException | DAOSQLException e) {
            e.printStackTrace();
        }
        return allOrdersCost;
    }

    private float getUserDiscount(String userID) {
        float userDiscount = 0;

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection;
        try {
            connection = tourConnectionPool.getConnection();
            if(connection != null) {
                try (PreparedStatement preparedStatement =
                             connection.prepareStatement(DBRequestContainer.GET_USER_DISCOUNT_REQUEST)) {

                    preparedStatement.setString(1, userID);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {
                        userDiscount = resultSet.getFloat(DBConstantContainer.USER_DISCOUNT);
                    }

                } catch (SQLException e) {
                    throw new DAOSQLException(e);
                } finally {
                    tourConnectionPool.returnConnection(connection);
                }
            }
        } catch (TourConnectionPoolException | DAOSQLException e) {
            e.printStackTrace();
        }
        return userDiscount;
    }
}
