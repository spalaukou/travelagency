package model.logic.service;

import model.entity.User;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.DBconnectionException;
import model.logic.exception.technical.TourConnectionPoolException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public interface UserService {

    int signUp(String login, String password);

    User signIn(HttpServletRequest request);

}
