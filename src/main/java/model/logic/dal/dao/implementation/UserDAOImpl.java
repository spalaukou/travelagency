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
}
















/////////////////////////////////////////////////////////
    /*@Override
    public int signUp(String login, String password) throws TourConnectionPoolException, DAOSQLException {

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection = tourConnectionPool.getConnection();

        int userID;

        try {
            CallableStatement statement = connection.prepareCall(DBRequestContainer.USER_SIGN_UP_REQUEST);
            statement.setString(1, login);
            statement.setString(2, password);
            statement.execute();

            Statement get = connection.createStatement();
            ResultSet resultSet = get.executeQuery(DBRequestContainer.GET_USER_ID_REQUEST);

            if(resultSet.next()) {
                userID = resultSet.getInt(DBConstantContainer.ID_USER);
                System.out.println(userID);
            } else {
                userID = DBConstantContainer.WRONG_RESPONSE;
            }

            return userID;
        } catch (SQLException e) {
            throw new DAOSQLException(e);
        }
        finally {
            tourConnectionPool.returnConnection(connection);
        }
    }
}*/
////////////////////////////////////


    /*private static String JDBC_MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/tour?useTimezone=true&serverTimezone=UTC";
    private static String DATABASE_USER = "root";
    private static String DATABASE_PASSWORD = "root";

    private static String SQL = "INSERT INTO `tour`.`user` (`login`, `password`) VALUES (?, ?);";
    private static String SQL2 = "SELECT `iduser` FROM `tour`.`user` WHERE login = `?`;";

    @Override
    public int signUp(String login, String password) throws TourConnectionPoolException, DAOSQLException {
        Connection connection = null;

        int userID = 0;

        try {
            Class.forName(JDBC_MYSQL_DRIVER);

            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

            CallableStatement statement = connection.prepareCall(SQL);

            statement.setString(1, login);
            statement.setString(2, password);

            statement.execute();

            Statement get = connection.createStatement();
            String sql = "SELECT `iduser` FROM `tour`.`user` WHERE login = '" + login + "';";
            ResultSet resultSet = get.executeQuery(sql);

            if(resultSet.next()) {
                userID = resultSet.getInt("iduser");
            }

            return userID;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}*/
