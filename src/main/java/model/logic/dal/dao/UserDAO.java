package model.logic.dal.dao;

import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.DBconnectionException;
import model.logic.exception.technical.TourConnectionPoolException;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public interface UserDAO {

    int signUp(String login, String password) throws TourConnectionPoolException, DAOSQLException;
}
