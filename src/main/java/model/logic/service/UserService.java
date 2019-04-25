package model.logic.service;

import model.logic.exception.technical.DBconnectionException;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public interface UserService {

    int signUp(String login, String password) throws DBconnectionException;
}
