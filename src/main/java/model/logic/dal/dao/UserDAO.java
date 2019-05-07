package model.logic.dal.dao;

import model.entity.User;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.DBconnectionException;
import model.logic.exception.technical.TourConnectionPoolException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public interface UserDAO {

    void signUp(String login, String password) throws TourConnectionPoolException, DAOSQLException;

    User signIn(String login, String password) throws TourConnectionPoolException, DAOSQLException;

    void setBalance(String userID, int balance);

    void setDiscount(String userID);
}
