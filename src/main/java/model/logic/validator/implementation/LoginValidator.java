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
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 */

public class LoginValidator implements Validator {

    @Override
    public boolean validate(HttpServletRequest request) {
        String login = request.getParameter(ConstantContainer.LOGIN);

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection;

        try {
            connection = tourConnectionPool.getConnection();
            if(connection != null) {
                try (PreparedStatement statement =
                             connection.prepareStatement(DBRequestContainer.CHECK_LOGIN_REQUEST)) {
                    statement.setString(1, login);
                    ResultSet resultSet = statement.executeQuery();

                    while(resultSet.next()) {
                        if(resultSet.getInt(DBConstantContainer.ID_USER) > 0) {
                            return false;
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                //log
                return false;
            }
        } catch (TourConnectionPoolException e) {
            //log
        }
        return true;
    }

}
