package model.logic.validator.implementation;

import model.ConstantContainer;
import model.logic.dal.db_connection.DBConstantContainer;
import model.logic.dal.db_connection.DBRequestContainer;
import model.logic.dal.db_connection.connection_pool.TourConnectionPool;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.technical.DataSourceException;
import model.logic.exception.technical.TourConnectionPoolException;
import model.logic.service.ServiceFactory;
import model.logic.service.UserService;
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

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        try {
            String expectedPassword = userService.getPassword(login);

            if (password.equals(expectedPassword)) {
                return true;
            }
        } catch (DataSourceException e) {
            //log.error("Problems with data source", e);
        } catch (ServiceSQLException e) {
            //log.error("SQL error", e);
        }
        return false;
    }
}
