package model.logic.validator.implementation;

import model.ConstantContainer;
import model.logic.dal.db_connection.DBConstantContainer;
import model.logic.dal.db_connection.DBRequestContainer;
import model.logic.dal.db_connection.connection_pool.TourConnectionPool;
import model.logic.exception.technical.TourConnectionPoolException;
import model.logic.validator.Validator;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;

/**
 * @author Stanislau Palaukou on 30.04.2019
 * @project TravelAgency
 */

public class AccessValidator implements Validator {

    @Override
    public boolean validate(HttpServletRequest request) {
        String login = request.getParameter(ConstantContainer.LOGIN);
        String password = request.getParameter(ConstantContainer.PASSWORD);
        String expectedPassword = null;

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection;

        try {
            connection = tourConnectionPool.getConnection();
            if(connection != null) {
                try (PreparedStatement statement =
                             connection.prepareStatement(DBRequestContainer.GET_PASSWORD_REQUEST)) {
                    statement.setString(1, login);
                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        expectedPassword = resultSet.getString(DBConstantContainer.USER_PASSWORD);
                    }

                    if (password.equals(expectedPassword)) {
                        return true;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                return false;
            }
        } catch (TourConnectionPoolException e) {
            //log
        }
        return false;
    }
}
