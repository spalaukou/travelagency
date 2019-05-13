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
 * Implementation of User DAO.
 *
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public class UserDAOImpl implements UserDAO {

    /**
     * Executes DataBase query and creates an entry with the data of the new user.
     *
     * @param login
     * @param password
     * @throws DAOSQLException
     * @throws TourConnectionPoolException
     */
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

    /**
     * Executes DataBase query and retrieves user characteristics by login.
     *
     * @param login
     * @param password
     * @return User entity with all characteristics to set in the user's session.
     * @throws TourConnectionPoolException
     * @throws DAOSQLException
     */
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

    /**
     * Executes DataBase query and gets the user id by requested login.
     *
     * @param login
     * @return User ID if the User exists.
     * @throws TourConnectionPoolException
     * @throws DAOSQLException
     */
    @Override
    public int getID(String login) throws TourConnectionPoolException, DAOSQLException {
        int userID = DBConstantContainer.WRONG_USER_ID;

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection = tourConnectionPool.getConnection();

        if (connection != null) {
            try (PreparedStatement statement =
                         connection.prepareStatement(DBRequestContainer.GET_LOGIN_REQUEST)) {

                statement.setString(1, login);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    userID = resultSet.getInt(DBConstantContainer.ID_USER);
                }
            } catch (SQLException e) {
                throw new DAOSQLException(e);
            } finally {
                tourConnectionPool.returnConnection(connection);
            }
        }
        return userID;
    }

    /**
     * Executes DataBase query and gets the user password by requested login.
     *
     * @param login
     * @return User's password.
     * @throws TourConnectionPoolException
     * @throws DAOSQLException
     */
    @Override
    public String getPassword(String login) throws TourConnectionPoolException, DAOSQLException {
        String password = DBConstantContainer.WRONG_USER_PASSWORD;

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection = tourConnectionPool.getConnection();

        if (connection != null) {
            try (PreparedStatement statement =
                         connection.prepareStatement(DBRequestContainer.GET_PASSWORD_REQUEST)) {
                statement.setString(1, login);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    password = resultSet.getString(DBConstantContainer.USER_PASSWORD);
                }
            } catch (SQLException e) {
                throw new DAOSQLException(e);
            } finally {
                tourConnectionPool.returnConnection(connection);
            }
        }
        return password;
    }

    /**
     * Executes DataBase query and gets the user balance by requested login.
     *
     * @param login
     * @return
     * @throws DAOSQLException
     * @throws TourConnectionPoolException
     */
    @Override
    public int getBalance(String login) throws DAOSQLException, TourConnectionPoolException {
        int balance = DBConstantContainer.WRONG_USER_BALANCE;

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection = tourConnectionPool.getConnection();
        if (connection != null) {
            try (PreparedStatement statement =
                         connection.prepareStatement(DBRequestContainer.GET_USER_BALANCE_REQUEST)) {
                statement.setString(1, login);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    balance = Integer.parseInt(resultSet.getString(DBConstantContainer.USER_BALANCE));
                }
            } catch (SQLException e) {
                throw new DAOSQLException(e);
            } finally {
                tourConnectionPool.returnConnection(connection);
            }
        }
        return balance;
    }

    /**
     * Executes DataBase query and sets the user balance by requested user id.
     *
     * @param connection
     * @param userID
     * @param balance
     * @throws DAOSQLException
     */
    @Override
    public void setBalance(Connection connection, String userID, int balance) throws DAOSQLException {
        if (connection != null) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement(DBRequestContainer.SET_BALANCE_REQUEST)) {

                preparedStatement.setInt(1, balance);
                preparedStatement.setString(2, userID);

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                throw new DAOSQLException(e);
            }
        }
    }

    /**
     * Method gets all orders cost and user discount by User ID, and sets new User discount if it is changed.
     *
     * @param connection
     * @param userID
     * @return User discount.
     * @throws TourConnectionPoolException
     * @throws DAOSQLException
     */
    @Override
    public float setDiscount(Connection connection, String userID) throws TourConnectionPoolException, DAOSQLException {
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
            insertNewDiscount(connection, userID, newDiscount);
        }

        return newDiscount;
    }

    /**
     * Executes DataBase query and sets the user discount by requested user id.
     *
     * @param connection
     * @param userID
     * @param newDiscount
     * @throws DAOSQLException
     */
    private void insertNewDiscount(Connection connection, String userID, float newDiscount) throws DAOSQLException {
        if (connection != null) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement(DBRequestContainer.SET_DISCOUNT_REQUEST)) {

                preparedStatement.setFloat(1, newDiscount);
                preparedStatement.setString(2, userID);

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                throw new DAOSQLException(e);
            }
        }
    }

    /**
     * Executes DataBase query and gets all the user's orders cost by requested user id.
     *
     * @param userID
     * @return
     * @throws TourConnectionPoolException
     * @throws DAOSQLException
     */
    private int getAllOrdersCost(String userID) throws TourConnectionPoolException, DAOSQLException {
        int allOrdersCost = DBConstantContainer.WRONG_ALL_ORDERS_COST;

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection = tourConnectionPool.getConnection();
        if (connection != null) {
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
        return allOrdersCost;
    }

    /**
     * Executes DataBase query and gets the user discount by requested user id.
     *
     * @param userID
     * @return
     * @throws TourConnectionPoolException
     * @throws DAOSQLException
     */
    private float getUserDiscount(String userID) throws TourConnectionPoolException, DAOSQLException {
        float userDiscount = DBConstantContainer.WRONG_USER_DISCOUNT;

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection = tourConnectionPool.getConnection();
        if (connection != null) {
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
        return userDiscount;
    }
}
