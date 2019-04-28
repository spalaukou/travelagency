package model.logic.validator.implementation;

import model.ConstantContainer;
import model.logic.dal.db_connection.DBConstantContainer;
import model.logic.dal.db_connection.DBRequestContainer;
import model.logic.dal.db_connection.connection_pool.ConnectionPool;
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

        if (login.length() >= ConstantContainer.LOGIN_MIN_LENGTH) {
            Connection connection = ConnectionPool.getConnection();

            try {
                Statement statement = connection.createStatement();

                String sql = DBRequestContainer.CHECK_LOGIN_BEGIN + login + DBRequestContainer.SQL_END;
                ResultSet resultSet = statement.executeQuery(sql);

                while(resultSet.next()) {
                    if(resultSet.getInt(DBConstantContainer.ID_USER) > 0) {
                        return false;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            return false;
        }
        return true;
    }
}
