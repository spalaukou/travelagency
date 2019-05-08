package model.logic.service;

import model.entity.User;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.DBconnectionException;
import model.logic.exception.technical.DataSourceException;
import model.logic.exception.technical.TourConnectionPoolException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public interface UserService {

    void signUp(String login, String password) throws ServiceSQLException, DataSourceException;

    User signIn(String login, String password) throws DataSourceException, ServiceSQLException;

    int getID(String login) throws DataSourceException, ServiceSQLException;

    String getPassword(String login) throws DataSourceException, ServiceSQLException;

    int getBalance(String login) throws DataSourceException, ServiceSQLException;

    void setBalance(String userID, int balance) throws DataSourceException, ServiceSQLException;

    float setDiscount(String userID) throws DataSourceException, ServiceSQLException;
}
